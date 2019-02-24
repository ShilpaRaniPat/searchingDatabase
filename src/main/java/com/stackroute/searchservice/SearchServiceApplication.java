package com.stackroute.searchservice;

import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.stackroute.searchservice.domain.Topic;
import com.stackroute.searchservice.repository.SearchRepository;
import org.apache.catalina.authenticator.SingleSignOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.*;

@EnableAutoConfiguration
@SpringBootApplication
public class SearchServiceApplication {
	@Autowired
	SearchRepository searchRepository;


	public static void main(String[] args)

	{
		SpringApplication.run(SearchServiceApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//		BufferedReader br = null;
//		Gson gson = new Gson();
//
//		try {
//			br = new BufferedReader(new FileReader(("./search3.json")));
//			// convert json string to object
//			Topic topic = gson.fromJson(br, Topic.class);
//			searchRepository.save(topic);
//			System.out.println("Question Name: " + topic.getTopic());
//			System.out.println(topic.getQuestions());
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//	}
}




