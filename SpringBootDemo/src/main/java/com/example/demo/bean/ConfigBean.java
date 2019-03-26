package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import groovy.transform.ToString;
import lombok.Data;



@ConfigurationProperties(prefix = "yy")
@Configuration
//@Data //lonbak在类上 自动添加get、set、tostring等方法
//@ToString
public class ConfigBean {
	@Override
	public String toString() {
		return "ConfigBean [name=" + name + ", age=" + age + ", number=" + number + ", uuid=" + uuid + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	private String name;
	private int age;
	private int number;
	private String uuid;
	
}
