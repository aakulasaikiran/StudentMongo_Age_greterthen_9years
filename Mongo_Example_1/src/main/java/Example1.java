import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Example1 {

	public static void main(String[] args) throws UnknownHostException {

		MongoClient mc = new MongoClient();
		DBCollection col = mc.getDB("test").getCollection("things");
		
		BasicDBObject object2 = new BasicDBObject("$match", new BasicDBObject("status", "A"));
		System.out.println(object2);
		
		/*
		BasicDBObject object3 = new BasicDBObject("$group", new BasicDBObject("_id", "$cust_id"));
		object3.append("Total", new BasicDBObject("$sum","sal"));
		System.out.println(object3);
		*/
		
		BasicDBObject object3 = new BasicDBObject("_id", "$cust_id");
		object3.append("Total", new BasicDBObject("$sum","$sal"));
		BasicDBObject object4 = new BasicDBObject();
		object4.append("$group", object3);
		System.out.println(object4);
		
		
		
		BasicDBObject object1 = new BasicDBObject();
		
		//object1.
		
	}

}
