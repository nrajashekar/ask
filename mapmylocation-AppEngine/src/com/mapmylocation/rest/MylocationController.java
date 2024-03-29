package com.mapmylocation.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.labs.repackaged.com.google.common.primitives.Ints;
import com.mapmylocation.dao.CreateQuestionRequest;
import com.mapmylocation.dao.GetRelatedQuestionsRequest;
import com.mapmylocation.dao.GetRelatedQuestionsResponse;
import com.mapmylocation.dao.Mylocation;
import com.mapmylocation.dao.Question;
import com.mapmylocation.dao.RegisterDeviceRequest;


@Controller
@RequestMapping(value="/mylocation")
public class MylocationController {

	String message;
	private static final Logger log = Logger.getLogger(MylocationController.class.getName()); 
	 
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Mylocation getTesting(@PathVariable String name) {
 
		Mylocation loc = new Mylocation();
		loc.setLatitude(name + "sreeni");
		loc.setLongitude(name);
		
		String str = "sreeni";  
		
		return loc;
 
	}
 
	@RequestMapping(value="/reg", method = RequestMethod.POST)
	public void registerDevice(@RequestBody RegisterDeviceRequest request ) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey("Username", request.getName());
		Entity entity = null;
		try {
			//check if the device is already registered
			 entity = datastore.get(key);
		} catch (EntityNotFoundException e) {
			//if not registered, register to gcm and also store it in datastore
			 entity = new Entity(key);
			 entity.setProperty("deviceId", request.getDeviceId());
			 datastore.put(entity); 
			 return;
		}
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/create", method = RequestMethod.POST)
	@ResponseBody
	public void createQuestion(@RequestBody CreateQuestionRequest request ) throws NotFoundException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		// create a new question
		//Query query = new Query("question");
		//query.addFilter("question", FilterOperator.EQUAL, request.getQuestion());
		//PreparedQuery pq = datastore.prepare(query);
		//Entity entity = pq.asSingleEntity();	
		//TODO: to do it in the next pass
		// if the entity is null create a new one.
		// if the entity is not null.the check if the ownerId and the question already exists. If it does, we just need to update the question
		List<Entity> recipientMappingEntityList = new ArrayList<Entity>();
		Key questionKey = KeyFactory.createKey("question", request.getQuestion() + new Integer(request.getOwnerId()).toString());
		//create the question table
		Entity questionEntity = new Entity("questionEntity", questionKey + new Integer(request.getOwnerId()).toString());
		if( questionEntity.getProperties().size() != 2 ) {
			//new entry is created
			questionEntity.setProperty("question", request.getQuestion());
			questionEntity.setProperty("owner",request.getOwnerId());
			datastore.put(questionEntity);
			
			//add the owner to recipient mapping table
			Entity recipientMappingEntity = new Entity( "recipientMappingEntity", questionKey + new Integer(request.getOwnerId()).toString());
			recipientMappingEntity.setProperty("questionKey", questionKey);
			recipientMappingEntity.setProperty("recipient", request.getOwnerId());
			recipientMappingEntityList.add(recipientMappingEntity);
		}
		
		//create question to recipient
		for(int i = 0; i< request.getRecipientIdList().length; i++) {
			Entity recipientMappingEntity = new Entity( "recipientMappingEntity", questionKey + new Integer(request.getRecipientIdList()[i]).toString());
			if( recipientMappingEntity.getProperties().size() != 2 ) {
				recipientMappingEntity.setProperty("questionKey", questionKey);
				recipientMappingEntity.setProperty("recipient", request.getRecipientIdList()[i]);
				recipientMappingEntityList.add(recipientMappingEntity);
			}
		
		}
		
		datastore.put(recipientMappingEntityList);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/my/{id}", method = RequestMethod.GET)
	@ResponseBody
	public GetRelatedQuestionsResponse getMyQuestions(@PathVariable int id ) throws NotFoundException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		// get questions from question -owner table
		Filter ownerFilter = new FilterPredicate("owner",FilterOperator.EQUAL,id);
		Query query = new Query("questionEntity").setFilter(ownerFilter);	
		PreparedQuery pq = datastore.prepare(query);
		Iterable<Entity> entityIterable= pq.asIterable();
		Iterator<Entity> entityIterator = entityIterable.iterator();
		List<Question> questionsList = new ArrayList<Question>();
		while( entityIterator.hasNext()) {
			Entity entity = (Entity)entityIterator.next();
			Question question = new Question();
			String questionStr = (String) entity.getProperty("question");
			int owner = new Integer(entity.getProperty("owner").toString());
			question.setQuestionStr(questionStr);
			question.setOwnerId(owner);
			questionsList.add(question);
			
		}
		
		GetRelatedQuestionsResponse response = new GetRelatedQuestionsResponse();
		response.setQuestions(questionsList.toArray(new Question[questionsList.size()]));
		return response;
		
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/related/{id}", method = RequestMethod.GET)
	@ResponseBody
	public GetRelatedQuestionsResponse getAssociatedQuestions(@PathVariable int id ) throws NotFoundException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		// get questionkeys from question -recipientMapping table
		Filter recipientFilter = new FilterPredicate("recipient",FilterOperator.EQUAL,id);
		Query recipientTableQuery = new Query("recipientMapping").setFilter(recipientFilter);	
		PreparedQuery pqr = datastore.prepare(recipientTableQuery);
		Iterable<Entity> rentityIterable= pqr.asIterable();
		Iterator<Entity> rentityIterator = rentityIterable.iterator();
		List<String> questionKeyList = new ArrayList<String>();
		while( rentityIterator.hasNext()) {
			Entity entity = (Entity)rentityIterator.next();
			String questionStr = entity.getProperty("questionKey").toString();
			questionKeyList.add(questionStr);
		}
		
		// get question strings from question -owner table
		Filter questionKeyFilter = new FilterPredicate( Entity.KEY_RESERVED_PROPERTY,FilterOperator.IN,questionKeyList);
		Query questionTableQuery = new Query("question").setFilter(questionKeyFilter);
		PreparedQuery pqq = datastore.prepare(questionTableQuery);
		Iterable<Entity> qentityIterable= pqq.asIterable();
		Iterator<Entity> qentityIterator = qentityIterable.iterator();
		List<Question> questionsList = new ArrayList<Question>();
		while( qentityIterator.hasNext()) {
			Entity entity = (Entity)qentityIterator.next();
			Question question = new Question();
			String questionStr = (String) entity.getProperty("question");
			int owner = new Integer(entity.getProperty("owner").toString());
			question.setQuestionStr(questionStr);
			question.setOwnerId(owner);
			questionsList.add(question);
		}
		
		GetRelatedQuestionsResponse response = new GetRelatedQuestionsResponse();
		response.setQuestions(questionsList.toArray(new Question[questionsList.size()]));
		return response;
		
	}
	
	private boolean questionAlreadyExists( Entity entity, int ownerID, String question) {
		return (entity != null && (Integer) entity.getProperty("owner") != ownerID && 
				!entity.getProperty("question").toString().equals(question));
	}
	
	@RequestMapping(value="/publish", method = RequestMethod.POST)
	@ResponseBody
	public void publishLocation(@RequestBody RegisterDeviceRequest request ) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		// save my current location
		Key key = KeyFactory.createKey("Username", request.getName());
		Entity entity = null;
		try {
			entity = datastore.get(key);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		if( entity != null ) {
			entity.setProperty("lat", "val");
			entity.setProperty("long", "val");
			datastore.put(entity);
		}
		// publish my position to all my friends (in the future recipients to be passed in request)
		Query query = new Query("Username");
		List<Entity> results = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		// send push notifications to all the entities in the result with the username of the updated person
	}
	
	
	@RequestMapping(value="/getlatest", method = RequestMethod.GET)
	@ResponseBody
	public void getLocationUpdates(@RequestBody RegisterDeviceRequest request ) {
		// this will be called by the devices that get an update via GCM that they have something new on the server.
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		//retrieve updates of the user
	}
}
