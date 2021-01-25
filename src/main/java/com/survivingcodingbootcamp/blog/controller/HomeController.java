package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private TopicStorage topicStorage;

    public HomeController(TopicStorage topicStorage) {

        this.topicStorage = topicStorage;
    }

    @GetMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("topics", topicStorage.retrieveAllTopics());
        return "home-template";
    }
}
