/**
 * 
 */
package com.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * @author eshantandon
 *
 */
public class HelooWroldSparkFreemarker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
            	StringWriter writer=null;
        		Configuration config=new Configuration();
                config.setClassForTemplateLoading(HelooWroldSparkFreemarker.class, "/");
                try {
        			Template helloTemplate=config.getTemplate("heloo.ftl");
        			writer=new StringWriter();
        			Map<String,Object> map=new HashMap<String,Object>();
        			map.put("name", "Freemarker");
        			helloTemplate.process(map, writer);
        			System.out.println(writer);
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            	return writer;
            }
        });
	}

}
