package com.example.sweater.Repo;

import com.example.sweater.Domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
