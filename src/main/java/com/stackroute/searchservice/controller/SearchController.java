package com.stackroute.searchservice.controller;


import com.stackroute.searchservice.domain.Question;
import com.stackroute.searchservice.domain.Topic;
import com.stackroute.searchservice.exceptions.TopicNotFoundException;
import com.stackroute.searchservice.repository.MongoTemplateRepository;
import com.stackroute.searchservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController //used to enable @Controller, and  @Responsebody
@RequestMapping(value="api/v1")
public class SearchController extends ResponseEntityExceptionHandler {


    //A variable of type MuzixService
    SearchService searchService;

    //Autowired constructor
    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    MongoTemplateRepository mongoTemplateRepository;
    @Autowired
    public SearchController(MongoTemplateRepository mongoTemplateRepository){this.mongoTemplateRepository=mongoTemplateRepository;}

    //Mehtod to track by name
    @GetMapping("Topic/{topics}")
    public ResponseEntity<?> getByName(@PathVariable String topics) throws TopicNotFoundException {
        ResponseEntity responseEntity;
        try {

            Topic topic = searchService.trackByTopicName(topics);
            responseEntity = new ResponseEntity<Topic>(topic, HttpStatus.OK);
        } catch (TopicNotFoundException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("{topics}/{question}")
    public ResponseEntity<?> getByName(@PathVariable String topics,@PathVariable String questions) throws TopicNotFoundException {
        ResponseEntity responseEntity;
//        Topic topic = searchService.trackByTopicName(topics);
//        responseEntity = new ResponseEntity<Topic>(topic, HttpStatus.OK);
        if (topics.isEmpty())
            return null;

        Question question = mongoTemplateRepository.findByQuestionsQuestion(questions);
            responseEntity = new ResponseEntity<Question>(question, HttpStatus.OK);

        return responseEntity;
    }



}

