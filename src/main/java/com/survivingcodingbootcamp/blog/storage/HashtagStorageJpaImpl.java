package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;

import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HashtagStorageJpaImpl implements HashtagStorage {
    @Resource
    private HashtagRepository hashtagRepo;

    public HashtagStorageJpaImpl(HashtagRepository hashtagRepo) {

        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void saveHashtag(Hashtag hashtag) {
        hashtagRepo.save(hashtag);
    }

    @Override
    public Iterable<Hashtag> retrieveAllHashtags() {
        return hashtagRepo.findAll();
    }

    @Override
    public Hashtag retrieveHashtagById(long id) {
        return hashtagRepo.findById(id).get();
    }

    @Override
    public void save(Hashtag hashtagToAdd) { hashtagRepo.save(hashtagToAdd);

    }


//    @Override
//    public Iterable<Hashtag> retrieveAllHashtags(){
//        return hashtagRepo.findAll();
//    }
//
//    @Override
//    public Hashtag retrieveHashtagById(long id) {
//        return hashtagRepo.findById(id).get();
//    }
//
//    @Override
//    public void save(Hashtag hashtagToAdd) {
//        hashtagRepo.save(hashtagToAdd);
//
//    }

//    @Override
//    public void addPost(Long id, Post post) {
//        Hashtag hashtag1 = retrieveHashtagById(id);
//        hashtag1.addPost(post);
//        save(hashtag1);
//    }
}
