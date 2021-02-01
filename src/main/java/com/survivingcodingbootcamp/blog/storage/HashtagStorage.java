package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;

public interface HashtagStorage {
//    Hashtag saveHashtag(Hashtag test);

    Iterable<Hashtag> retrieveAllHashtags();

    Hashtag retrieveHashtagById(long id);

    void save(Hashtag hashtagToAdd);

    void saveHashtag(Hashtag test);


}
