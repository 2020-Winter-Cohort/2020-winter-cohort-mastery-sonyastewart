package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.repository.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicStorageJpaImpl implements TopicStorage {
    private TopicRepository topicRepo;

    public TopicStorageJpaImpl(TopicRepository topicRepo) {
        this.topicRepo = topicRepo;
    }

    @Override
    public Iterable<Topic> retrieveAllTopics() {
        return topicRepo.findAll();
    }

    @Override
    public Topic retrieveSingleTopic(long id) {
        return topicRepo.findById(id).get();
    }

    @Override
    public void save(Topic topicToSave) {
        topicRepo.save(topicToSave);
    }
}
