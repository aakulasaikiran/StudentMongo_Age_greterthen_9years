package com.lsn.repository;

import java.util.List;

import com.lsn.domain.Student;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


public class comman {
	public static DBCursor getStudentmorethen(int age){
		DBCursor cursor =null;
	try {
		/*MongoClient mongoClient = new MongoClient("localhost",27017);*/
		
		
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("db100");
		DBCollection collection = db.getCollection("student");
		System.out.println(collection);
		BasicDBObject bdo=new BasicDBObject("age", new BasicDBObject("$gte",age));
		bdo.append("stname","saikiran");
		cursor = collection.find(bdo);
		
		
		System.out.println();
		System.out.println(cursor);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	} catch (Exception e) {
		e.printStackTrace();
	
}
	return cursor;
}
}