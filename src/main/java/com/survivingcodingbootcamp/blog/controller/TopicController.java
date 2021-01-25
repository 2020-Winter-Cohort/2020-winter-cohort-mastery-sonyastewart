package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicStorage topicStorage;

    public TopicController(TopicStorage topicStorage) {

        this.topicStorage = topicStorage;
    }
    @GetMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicStorage.retrieveSingleTopic(id));
        return "single-topic-template";
    }
}
