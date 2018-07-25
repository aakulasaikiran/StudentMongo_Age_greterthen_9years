
import java.util.Arrays;
import java.util.List;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class aggreegation2 {

	public static void main(String[] args) {
		Integer numberOfTriples = 0;
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);

			DB db = mongo.getDB("db5");
			DBCollection collection = db.getCollection("emp999");

			System.out.println("setup ok");
			System.out.println("The Aggregation Result :");

			BasicDBObject groupFields = new BasicDBObject("status", "A");
			
			//BasicDBObject groupFields = new BasicDBObject("id", "$_id");
			
			 groupFields.append("_id", new BasicDBObject("_id", "$_id"));
			groupFields.append("amount", new BasicDBObject("$sum", "$amount"));
			DBObject group1 = new BasicDBObject("$match", groupFields);
			DBObject group2 = new BasicDBObject("$group", group1);
			System.out.println(group1);
			System.out.println(group2);
			List<DBObject> pipeline = Arrays.asList(group2);
			AggregationOutput output = collection.aggregate(group2);

			for (DBObject result : output.results()) {
				numberOfTriples = (Integer) result.get("amount");
				System.out.println(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
