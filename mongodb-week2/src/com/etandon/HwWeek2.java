/**
 * 
 */
package com.etandon;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author eshantandon
 *
 */
public class HwWeek2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClientOptions options= MongoClientOptions.builder().connectionsPerHost(100).build();
		MongoClient client = new MongoClient(new ServerAddress(),options);
		MongoDatabase db=client.getDatabase("students");
		MongoCollection<Document> coll=db.getCollection("grades");
		Bson filter=new Document("type","homework");
		Bson sort=new Document("student_id",1).append("score",1);
		ArrayList<Document> all=coll.find(filter)
				                    .sort(sort)
				                    .into(new ArrayList<Document>());
		Integer prev_student_id=-1;
		for(Document curr:all)
		   {
			if(!prev_student_id.toString().equals(curr.get("student_id").toString()))
			  {
				System.out.println("Delete");
				Bson Delfilter=new Document("_id",curr.get("_id"));
				coll.deleteOne(Delfilter);
			  }
			prev_student_id=(Integer) curr.get("student_id");
			System.out.println(curr.toJson());
		   }
		
		
	}

}
