package com.custom_annotations_demo;

import com.custom_annotations_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomAnnotationsDemoApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CustomAnnotationsDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.performOperation();
		userService.printName("maxim primak");
		userService.createUser("admin");
		userService.riskyMethod();
	}
}
