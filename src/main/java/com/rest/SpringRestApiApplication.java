package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;

import com.rest.dao.Repository;

@SpringBootApplication
public class SpringRestApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestApiApplication.class, args);
		Repository repository = context.getBean(Repository.class);
	}

}
