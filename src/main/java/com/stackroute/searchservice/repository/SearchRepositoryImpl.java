package com.stackroute.searchservice.repository;

import com.stackroute.searchservice.domain.Question;
import com.stackroute.searchservice.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public class SearchRepositoryImpl implements MongoTemplateRepository {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Question findByQuestionsQuestion(String question) {
        Query query = new Query();
        query.addCriteria(Criteria.where("questions.question").is(question));
        query.fields().include("questions.$");
        return (Question) mongoTemplate.find(query, Topic.class);
    }



}
