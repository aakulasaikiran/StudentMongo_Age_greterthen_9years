package com.stuff;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class RetrieveIds {

	public static void main(String[] args) throws UnknownHostException {

		MongoClient mc = new MongoClient();
		DBCollection col = mc.getDB("test").getCollection("things");

		// set up some test data
		for (int i = 0; i < 100; i++) {
			col.insert(new BasicDBObject("_id", i).append("desc", "this is field: " + i));
		}
		System.out.println("set up some test data  int i = 0; i < 100; i++" + "\n" + col);
		System.out.println("\n");
		System.out.println("\n");
		// query for documents with _id greater than or equal to 50

		DBCursor find = col.find(new BasicDBObject("_id", new BasicDBObject("$gte", 0)));
		System.out.println("documents with _id greater than or equal to 50" + "\n" + find);
		System.out.println("\n");
		System.out.println("\n");
		// store the _id values in an Integer array
		List<Integer> ids = new ArrayList<Integer>();
		while (find.hasNext()) {
			ids.add((Integer) find.next().get("_id"));
		}
		System.out.println("store the _id values in an Integer array" + "\n" + ids);
		System.out.println("\n");
		System.out.println("\n");
		// query things collection using the array and print the desc fields

		DBCursor find2 = col.find(new BasicDBObject("_id", new BasicDBObject("$in", ids)));
		System.out.println(" query things collection using the array and print the desc fields" + "\n" + find2);
		while (find2.hasNext()) {
			System.out.println(find2.next().get("desc"));
		}

		mc.close();
	}

}
