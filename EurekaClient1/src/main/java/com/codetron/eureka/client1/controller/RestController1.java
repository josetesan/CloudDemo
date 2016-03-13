package com.codetron.eureka.client1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by josete on 11/03/16.
 */
@RestController
public class RestController1 {


    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "/client1")
    @HystrixCommand(fallbackMethod = "sayHello")
    public ResponseEntity<?> retrieveData() {
        String response = restTemplate.getForObject("http://eureka-client2/hello",String.class);
        return ResponseEntity.ok(response);
    }


    private ResponseEntity<?> sayHello() {
        return ResponseEntity.ok("Hello from fallback method");
    }
}
