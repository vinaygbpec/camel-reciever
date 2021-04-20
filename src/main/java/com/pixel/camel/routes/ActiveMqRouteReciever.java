package com.pixel.camel.routes;

import com.pixel.camel.processor.DATFileProcessor;
import com.pixel.model.JournalEntryBulkCreateRequest;
import com.pixel.service.SoupEnvelopeCreatorService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqRouteReciever extends RouteBuilder {



	@Autowired
	private DATFileProcessor datFileProcessor;
	@Override
	public void configure() throws Exception {
		from("file://source?delay=100000").process(datFileProcessor).to("file://destination?fileName=soap.xml");

	}

}
