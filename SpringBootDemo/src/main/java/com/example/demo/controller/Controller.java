package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ConfigBean;

@RestController
public class Controller {
	/*@Value("${yy.name}")
	private String name;
	@Value("${yy.age}")
	private int age;*/
	
	
	@Autowired
	ConfigBean configBean;
	
	@RequestMapping(value = "/config")
	public String config() {
		return configBean.toString();
	}
	
	/*@RequestMapping(value = "/hello")//localhost:8081/hello  /hello的用处
*/	

	
	/*public String index() {
		return "HelloYangYe  "+ "  name:  " + name + "  age:  " + age;
	}*/
}
