package com.survivingcodingbootcamp.blog.storage.repository;

import com.survivingcodingbootcamp.blog.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
}
