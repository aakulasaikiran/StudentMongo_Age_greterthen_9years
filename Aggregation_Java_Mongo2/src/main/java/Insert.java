
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class Insert {

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);

			DB db = mongo.getDB("db5");
			DBCollection collection = db.getCollection("emp999");

			System.out.println("setup ok");

			BasicDBObject document1 = new BasicDBObject();
			document1.append("_id", "A123");
			document1.append("amount", 500);
			document1.append("status", "A");

			BasicDBObject document2 = new BasicDBObject();
			document2.append("_id", "B212");
			document2.append("amount", 200);
			document2.append("status", "A");

			BasicDBObject document3 = new BasicDBObject();
			document3.append("_id", "A123");
			document3.append("amount", 300);
			document3.append("status", "D");

			BasicDBObject document4 = new BasicDBObject();
			document4.append("_id", "A123");
			document4.append("amount", 2000);
			document4.append("status", "A");

			collection.insert(document1);
			collection.insert(document2);
			collection.insert(document3);
			collection.insert(document4);
			System.out.println("Successfully Inserted Records");
		} catch (Exception e) {

		}
	}

}
