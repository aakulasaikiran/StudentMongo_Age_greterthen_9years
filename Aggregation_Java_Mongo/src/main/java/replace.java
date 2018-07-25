
import java.util.Arrays;
import java.util.List;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class replace {

	public static void main(String[] args) {
		Integer numberOfTriples = 0;
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);

			DB db = mongo.getDB("db5");
			DBCollection collection = db.getCollection("emp999");

			System.out.println("setup ok");
			System.out.println("The Aggregation Result :");

			BasicDBObject groupFields = new BasicDBObject("_id", "$_id");
			  DBCursor cursor=collection.find();
			  //cursor.replaceOne(new BasicDBObject("x", 1), new BasicDBObject("x", 2));

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
