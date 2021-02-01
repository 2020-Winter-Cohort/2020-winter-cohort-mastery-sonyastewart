package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;
    private TopicStorage topicStorage;

    public PostController(PostStorage postStorage, TopicStorage topicStorage) {
        this.postStorage = postStorage;
        this.topicStorage = topicStorage;
    }
@GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        return "single-post-template";
    }

    @PostMapping("/addPost")
    public String addPostToTopic(@RequestParam String title, @RequestParam String topicId, @RequestParam String author, @RequestParam String content) {
        Long id = Long.parseLong(topicId);
        Topic addTopic = topicStorage.retrieveSingleTopic(id);
        Post addedPost = new Post(title,addTopic,author,content);
        postStorage.save(addedPost);
        topicStorage.addPostToTopic(id, addedPost);
        return "redirect:/";
    }




}
