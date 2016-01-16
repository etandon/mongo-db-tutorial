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
public class HelloWorldSparkStyle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World From Spark";
            }
        });
    }

}
