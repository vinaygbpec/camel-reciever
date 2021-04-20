package com.pixel.camel.processor;

import com.pixel.model.JournalEntryBulkCreateRequest;
import com.pixel.service.SoupEnvelopeCreatorService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DATFileProcessor implements Processor {
    @Autowired
    private SoupEnvelopeCreatorService soupEnvelopeCreatorService;

    @Override
    public void process(Exchange exchange) throws Exception {
        String body=exchange.getIn().getBody(String.class);
        System.out.println(body);
        JournalEntryBulkCreateRequest journalEntryBulkCreateRequest=soupEnvelopeCreatorService.getJournalEntryBulkCreateRequestObject();
        exchange.getIn().setBody(soupEnvelopeCreatorService.generateSoapFile(journalEntryBulkCreateRequest,"soap-output.xml"));
    }
}
