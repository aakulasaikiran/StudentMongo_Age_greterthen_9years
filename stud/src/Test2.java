import java.util.Iterator;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.sun.xml.internal.txw2.Document;

import javafx.print.Collation;

public class Test2 {

	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient();

			DB db = mongoClient.getDB("db100");
			DBCollection collection = db.getCollection("student");
			System.out.println(collection);
			BasicDBObject bdo=new BasicDBObject("age", new BasicDBObject("$gte", 22));
			DBCursor cursor = collection.find(bdo);
			System.out.println();
			System.out.println(cursor);
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
