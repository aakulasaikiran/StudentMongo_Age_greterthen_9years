
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class Display2 {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);

			DB db = mongo.getDB("db5");
			DBCollection collection = db.getCollection("emp999");

			System.out.println("setup ok");
			// DBCursor find2 = col.find(new BasicDBObject("_id", new BasicDBObject("$in",
			// list)));
			DBCursor cursor = collection.find(new BasicDBObject("cust_id", "A123"));

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

			System.out.println("Successfully Display Records");
		} catch (Exception e) {

		}
	}

}
