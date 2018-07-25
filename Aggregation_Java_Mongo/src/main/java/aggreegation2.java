
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

			BasicDBObject groupFields = new BasicDBObject("_id", "");

			groupFields.append("amount", new BasicDBObject("$sum", "$amount"));

			DBObject group = new BasicDBObject("$group", groupFields);
			System.out.println(group);

			List<DBObject> pipeline = Arrays.asList(group);
			AggregationOutput output = collection.aggregate(group);

			for (DBObject result : output.results()) {
				numberOfTriples = (Integer) result.get("amount");
				System.out.println(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
