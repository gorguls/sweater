package com.example.sweater.Repo;

import com.example.sweater.Domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    public List<Message> findByTag(String tag);
}
