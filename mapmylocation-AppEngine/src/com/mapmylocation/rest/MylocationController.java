package com.mapmylocation.rest;

import java.util.ArrayList;
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
import com.google.appengine.api.datastore.Query.FilterOperator;
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
		
		Key key = KeyFactory.createKey("question", request.getQuestion());
		//create the question table
		Entity entity = new Entity(key);
		entity.setProperty("key", key);
		entity.setProperty("question", request.getQuestion());
		entity.setProperty("owner",request.getOwnerId());
		List<Integer> recipientList = new ArrayList<Integer>();
		recipientList.add(request.getRecipientId());
		entity.setProperty("recipientList",recipientList);
		entity.setProperty("answers","");
		datastore.put(entity);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/get", method = RequestMethod.GET)
	@ResponseBody
	public GetRelatedQuestionsResponse createQuestion(@PathVariable int id ) throws NotFoundException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		// create a new question
		Query query = new Query("question");
		query.addFilter("owner", FilterOperator.EQUAL, id);
		PreparedQuery pq = datastore.prepare(query);
		Iterable<Entity> entityIterable= pq.asIterable();
		Iterator<Entity> entityIterator = entityIterable.iterator();
		List<Question> questionsList = new ArrayList<Question>();
		while( entityIterator.hasNext()) {
			Entity entity = (Entity)entityIterator.next();
			Question question = new Question();
			String questionStr = (String) entity.getProperty("question");
			int owner = (Integer) entity.getProperty("owner");
			int[] recipientList = (int[]) entity.getProperty("recipient");
			String[] answers  = (String[]) entity.getProperty("answers");
			question.setQuestionStr(questionStr);
			question.setAnswers(answers);
			question.setOwnerId(owner);
			question.setRecipientIdList(recipientList);
			questionsList.add(question);
			
		}
		GetRelatedQuestionsResponse response = new GetRelatedQuestionsResponse();
		response.setQuestions((Question[])questionsList.toArray());
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
