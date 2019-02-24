package com.stackroute.searchservice.repository;

import com.mongodb.client.MongoCursor;
import com.stackroute.searchservice.domain.Question;
import com.stackroute.searchservice.domain.Topic;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SearchRepository extends MongoRepository<Topic,String> ,MongoTemplateRepository {
//    @Query(value= "SELECT m FROM Topic m WHERE m.topic=?1")
    Topic findByTopic(String topic);
    List<Question> findByTopicAndQuestion(Topic topic, String question);

//    @Query("{ 'topic' : ?0, 'status' : ?1}")
//    public List<Topic> findAllDocuments(long appId, int status);

    }

