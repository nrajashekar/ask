package com.mapmylocation.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.mapmylocation.dao.Mylocation;
import com.mapmylocation.dao.RegisterDeviceRequest;


@Controller
@RequestMapping(value="/mylocation")
public class MylocationController {

	String message;
	 
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Mylocation getTesting(@PathVariable String name) {
 
		Mylocation loc = new Mylocation();
		loc.setLatitude(name);
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
