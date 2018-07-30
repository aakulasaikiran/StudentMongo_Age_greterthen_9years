package com.lsn.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.lsn.domain.Student;
import com.lsn.repository.StudentDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class StudentDAOImpl implements StudentDAO {
	MongoTemplate mongoTemplate;
	
	
	
	
	
	
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void saveStudent(Student student) {
		mongoTemplate.save(student);
		System.out.println("Inserted Successfully");
	}

	public Student getStudent(int id) {

		Object sid = id;
		return mongoTemplate.findById(sid, Student.class);
	}

	public void createCollection() {
		if (!mongoTemplate.collectionExists(Student.class)) {
			mongoTemplate.createCollection(Student.class);
		}

	}

	public void dropCollection() {
		if (mongoTemplate.collectionExists(Student.class)) {
			mongoTemplate.dropCollection(Student.class);
		}

	}

	public void deleteStudent(String stname) {

		mongoTemplate.remove(new Query(Criteria.where("stname").is(stname)), Student.class);
		System.out.println("data deleted");

	}

	public void deleteStudent(Student student) {
		mongoTemplate.remove(new Query(Criteria.where("_id").is(student.getStid())), Student.class);
		System.out.println("data deleted");

	}

	public List<Student> getAllStudents() {

		return mongoTemplate.findAll(Student.class);
	}

	public void display(List<Student> list) {
		Iterator<Student> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

	public WriteResult updateStudent(String stname, String gender) {

		return mongoTemplate.updateFirst(new Query(Criteria.where("stname").is(stname)),
				Update.update("gender", gender), Student.class);
	}

	/*
	 * public CommandResult getStudentmorethen(int age) { BasicDBObject cmdBody =
	 * new BasicDBObject("aggregate", "student"); BasicDBObject cmdBody1 = new
	 * BasicDBObject("age",new BasicDBObject("$gt",age)); //ArrayList<BasicDBObject>
	 * pipeline = new ArrayList<BasicDBObject>(); //pipeline.add(cmdBody1);
	 * //cmdBody.put("pipeline", pipeline);
	 * 
	 * System.out.println(cmdBody); //CommandResult commandResult =
	 * mongoTemplate.executeCommand(cmdBody);
	 * 
	 * return mongoTemplate.executeCommand(cmdBody); CommandResult result =
	 * mongoTemplate.executeCommand("{\"age\" : { \"$gte\" : 2000}}");
	 * 
	 * 
	 * 
	 * }
	 */

	public List<Student> getStudentmorethen(int age) {
		
		BasicDBObject bdo = new BasicDBObject("age", new BasicDBObject("$gt", age));
		//BasicDBObject bdo = new BasicDBObject("$gt", age);
		System.out.println(bdo);
		/*Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.all(bdo);
		query.addCriteria(criteria);*/
		
		
		
		
		//Criteria criteria = new Criteria();
	
		Query query = new Query();
		
		return  null;

	}
	
	
}