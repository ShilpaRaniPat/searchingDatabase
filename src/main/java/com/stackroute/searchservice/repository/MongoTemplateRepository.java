package com.stackroute.searchservice.repository;

import com.stackroute.searchservice.domain.Question;
import com.stackroute.searchservice.domain.Topic;

import java.util.List;

public interface MongoTemplateRepository {

    Question findByQuestionsQuestion(String question);
}
