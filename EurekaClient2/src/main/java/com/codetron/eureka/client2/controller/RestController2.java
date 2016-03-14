package com.codetron.eureka.client2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by josete on 11/03/16.
 */
@RestController
public class RestController2 implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {

    private Integer runningPort;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public ResponseEntity<?> retrieveData() {
        final String response = String.format("Hello from client2 at port %s",runningPort);
        return ResponseEntity.ok(response);
    }


    @Override
    public void onApplicationEvent(final EmbeddedServletContainerInitializedEvent event) {
        runningPort = event.getEmbeddedServletContainer().getPort();
    }


}

