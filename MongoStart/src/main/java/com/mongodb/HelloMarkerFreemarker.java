/**
 * 
 */
package com.mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author eshantandon
 *
 */
public class HelloMarkerFreemarker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Configuration config=new Configuration();
        config.setClassForTemplateLoading(HelloMarkerFreemarker.class, "/");
        try {
			Template helloTemplate=config.getTemplate("heloo.ftl");
			StringWriter writer=new StringWriter();
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("name", "Freemarker");
			helloTemplate.process(map, writer);
			System.out.println(writer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
