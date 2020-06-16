package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel {
	
	public static void main(String[] args) {
		
		try(CamelContext context = new DefaultCamelContext()) {
			context.addRoutes(new RouteBuilder() {
				
				@Override
				public void configure() throws Exception {
					from("file:data/input?noop=true")
						.to("file:data/output");
				}
			});
			
			context.start();
            Thread.sleep(5000);
            context.stop();
            
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Inside Exception : " + e);
		}
	}

}
