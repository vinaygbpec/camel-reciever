package com.pixel.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqRouteReciever extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		restConfiguration().host("https://stage-api.legalselfrep.com");
		//from("activemq:my-activemq-queue")
       // .to("log: recieved message from queue");
		from("timer: rest-api-consumer?period=5000")
		.log("${body}")
		.to("rest:get:/v1/customer/getcourts")
		.log("${body}");
	}

}
