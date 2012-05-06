package com.arm.nimbus.collab.server;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class TaskService {

	public static void initDB(){
		MongoService.drop();
		//MongoService.execute("db.createCollection(\"task\")");
		DB  db = MongoService.get();

		DBCollection task = db.createCollection("task", null);
		task.insert((DBObject)JSON.parse("{title:\"Hello mongo\", author: \"vicben01\"}"));
		task.insert((DBObject)JSON.parse("{title:\"Amazing db\", author: \"vicben01\"}"));
	}
	
	public static String list(){
		DB  db = MongoService.get();
		DBCollection task = db.getCollection("task");
		DBCursor c = task.find();
		String s = "[";
		while(c.hasNext()){
			s = s + JSON.serialize(c.next()) + ",";
		}
		s += "]";
		return s;
	}
}
