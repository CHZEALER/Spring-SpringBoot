package com.example.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@Value("${name}")
	private String name;
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }    
    
    
	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	@PostConstruct
	public void logSomething() {
		log.debug("======= Debug Message");
		log.info("======= Info Message");
		log.trace("======= trace Message");
		log.error("======= error Message");
        log.warn("======= Message");
		
	}
		
	
}