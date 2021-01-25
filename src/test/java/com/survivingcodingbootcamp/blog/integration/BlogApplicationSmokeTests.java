package com.survivingcodingbootcamp.blog.integration;

import com.survivingcodingbootcamp.blog.controller.HomeController;
import com.survivingcodingbootcamp.blog.controller.TopicController;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BlogApplicationSmokeTests {
    @Autowired
    private HomeController homeController;
    @Autowired
    private TopicStorage topicStorage;
    @Autowired
    private TopicController topicController;
    @Autowired
    private PostStorage postStorage;

    @Test
    void contextLoads() {
    }

    @Test
    void beanCreation() {
        assertNotNull(homeController);
        assertNotNull(topicStorage);
        assertNotNull(topicController);
        assertNotNull(postStorage);

    }
}
