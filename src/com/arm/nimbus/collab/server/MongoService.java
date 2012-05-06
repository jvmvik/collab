package com.arm.nimbus.collab.server;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.CommandResult;
import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

/***
 * 
 * @doc http://www.mongodb.org/display/DOCS/Java+Tutorial
 * @author victorbenarbia
 *
 */
public class MongoService {
	
	static Logger log = Logger.getLogger(MongoService.class.getName());
	static final String dbName = "collab-dev";
	public static DB db;
	
	public static DB get(){
		if(db != null){
			return db;
		}
		
		Mongo m = null;
		try {
			m = new Mongo( "localhost" );
		} catch (UnknownHostException e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();			
		} catch (MongoException e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		if(m == null){
			return null;
		}
		db = m.getDB( dbName );
		return db;
	}
	
	public static boolean check() {
		return get().getMongo().debugString() != null;
	}
	
	public static void drop(){
		get().dropDatabase();
	}

	public static void execute(String query) {
		CommandResult r = get().command(query);
		log.info("result: " + r.toString());
	}
}