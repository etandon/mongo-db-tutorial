/**
 * 
 */
package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * @author eshantandon
 *
 */
public class SparkComplex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World From Spark";
            }
        });
		
		Spark.get(new Route("/GET") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World From GET";
            }
        });
		
		Spark.get(new Route("/POST/:thing") {
            @Override
            public Object handle(Request request, Response response) {
                return request.params(":thing");
            }
        });
	}

}
