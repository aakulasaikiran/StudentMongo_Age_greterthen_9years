
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class Display {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);

			DB db = mongo.getDB("db5");
			DBCollection collection = db.getCollection("emp999");

			System.out.println("setup ok");
      DBCursor cursor=collection.find();
      
      while(cursor.hasNext()) {
    	  System.out.println(cursor.next());
      }
      
			System.out.println("Successfully Display Records");
		} catch (Exception e) {

		}
	}

}
