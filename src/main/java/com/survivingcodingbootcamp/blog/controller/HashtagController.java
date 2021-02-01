package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    private HashtagStorage hashtagStorage;
    private PostStorage postStorage;

    public HashtagController(HashtagStorage hashtagStorage, PostStorage postStorage) {
        this.hashtagStorage = hashtagStorage;
        this.postStorage = postStorage;

    }

    @GetMapping("/{id}")
    public String displaySingleHashtag(@PathVariable long id, Model model) {
        model.addAttribute("hashtag", hashtagStorage.retrieveHashtagById(id));
        return "single-hashtag-template";
    }
    @GetMapping("")
    public String displayAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.retrieveAllHashtags());
        return "all-hashtags-template";
    }
    @PostMapping("/addHashtag")
    public String addHashtag(@RequestParam String newHashtag, @RequestParam String postId) {
        Hashtag addedHashtag = new Hashtag(newHashtag);
        hashtagStorage.save(addedHashtag);
        long id = Long.parseLong(postId);
        postStorage.addHashtagToPost(id, addedHashtag);
        return "redirect:/posts/" + postId;
    }

    @PostMapping("/hashtag/post/{id}")
    public String displayPostsInHashtag(Model model, @PathVariable long id) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        model.addAttribute("allHashtags", hashtagStorage.retrieveAllHashtags());
        model.addAttribute("postInHash", postStorage.retrieveAllPosts());
        return "single-hashtag-template";
    }
}
