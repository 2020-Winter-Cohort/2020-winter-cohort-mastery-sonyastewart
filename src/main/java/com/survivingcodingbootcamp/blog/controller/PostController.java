package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.storage.PostStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }
@GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        return "single-post-template";
    }

    @PostMapping("/addPost/{id}")
    public String addPost(@PathVariable long id, @RequestParam String title, @RequestParam String author, String content, String hashtag) {
        return "";
    }

}
