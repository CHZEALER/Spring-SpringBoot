package com.example.demo;


import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.ServletRequestHandledEvent;


@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args ->{
			System.out.println("------list bean"+ ctx.getBeanDefinitionCount());
			String[] beanNames  = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			
		};
	}	
	@Bean
	public ApplicationRunner appRunner() {
		return args ->{
			
			System.out.println();
			System.out.println("-----application Runner");
			for (String opt : args.getOptionNames()) {
				System.out.println();
				System.out.println("->");
				System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining(",", "[", "]")));
				//String.join(",", args.getOptionValues(opt));
			}
			
		};
	}
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener() {
		final String HELLO_URL = "/hello";
		return (ApplicationEvent event) ->{
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(HELLO_URL))
					System.out.println("visit hello");
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
