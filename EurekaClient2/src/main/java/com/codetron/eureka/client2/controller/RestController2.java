package com.codetron.eureka.client2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by josete on 11/03/16.
 */
@RestController
public class RestController2 {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public ResponseEntity<?> retrieveData() {
        return ResponseEntity.ok("Hello from client2");
    }


}

