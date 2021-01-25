package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Topic;

public interface TopicStorage {
    Iterable<Topic> retrieveAllTopics();

    void save(Topic topicToSave);

    Topic retrieveSingleTopic(long id);
}
