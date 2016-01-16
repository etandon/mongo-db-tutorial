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
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


/**
 * @author eshantandon
 *
 */
public class Prime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MongoClientOptions options= MongoClientOptions.builder().connectionsPerHost(100).build();
		MongoClient client = new MongoClient(new ServerAddress(),options);
		MongoDatabase db=client.getDatabase("test");
		MongoCollection<Document> coll=db.getCollection("testCollection");
		coll.drop();
		//System.out.println(coll.count());
		//Document doc=new Document().append("str", "Mongo Db").append("int", 42);
		//Document doc1=new Document().append("str1", "Mongo Db").append("int1", 42);
		//System.out.println(doc.getString("str"));
		//System.out.println(doc.get("int"));
		//coll.insertOne(doc);
		//coll.insertOne(doc1);
		for (int i=0;i<10;i++)
		    {
			 coll.insertOne(new Document("x",i).append("y", i+10)); 
		    }
		Document instance=coll.find().first();
		//System.out.println(instance.toJson());
		ArrayList<Document> all=coll.find().into(new ArrayList<Document>());
		for(Document curr:all)
		   {
			//System.out.println(curr.toJson());
		   }
		MongoCursor<Document> cursor =coll.find().iterator();
		while(cursor.hasNext())
		    {
			  Document currentDoc=cursor.next();
			  //System.out.println(currentDoc.toJson());
		    }
		Bson filter= new Document("x",new Document("$gt",3)).append("y", new Document("$lt",18));
		ArrayList<Document> all1=coll.find(filter).into(new ArrayList<Document>());
		for(Document curr:all1)
		   {
			System.out.println(curr.toJson());
		   }
		client.close();
		

	}

}
