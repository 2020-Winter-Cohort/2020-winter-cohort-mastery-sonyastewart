package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostStorageJpaImpl implements PostStorage {
    private PostRepository postRepo;

    public PostStorageJpaImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Iterable<Post> retrieveAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post retrievePostById(long id) {
        return postRepo.findById(id).get();
    }

    @Override
    public void save(Post postToAdd) {
        postRepo.save(postToAdd);
    }
}
