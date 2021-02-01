package com.survivingcodingbootcamp.blog.integration;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
import com.survivingcodingbootcamp.blog.storage.repository.TopicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private TopicRepository topicRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private HashtagRepository hashtagRepo;

    @Test
    public void postsShouldHaveATopic() {
        Topic testTopic = new Topic("Name");
        topicRepo.save(testTopic);

        Post testPost1 = new Post("Title", testTopic, "Content", "Sample Author");
        postRepo.save(testPost1);
        Post testPost2 = new Post("Another Title", testTopic, "Content", "Sample Author");
        postRepo.save(testPost2);

        entityManager.flush();
        entityManager.clear();

        Topic retrievedTopic = topicRepo.findById(testTopic.getId()).get();

        assertThat(retrievedTopic.getPosts()).containsExactlyInAnyOrder(testPost1, testPost2);
    }
    @Test
    public void hashtagsShouldHaveManyPostsAndPostsShouldHaveManyHashtags(){
        Topic testTopic = new Topic("Name");
        topicRepo.save(testTopic);

        Post testPost1 = new Post("Title", testTopic, "Content", "Sample Author");
        postRepo.save(testPost1);
        Post testPost2 = new Post("Another Title", testTopic, "Content", "Sample Author");
        postRepo.save(testPost2);

        Hashtag testHashtag1 = new Hashtag("name1");
        hashtagRepo.save(testHashtag1);
        Hashtag testHashtag2 = new Hashtag("name2");
        hashtagRepo.save(testHashtag2);
        Hashtag testHashtag3 = new Hashtag("name3");
        hashtagRepo.save(testHashtag3);

        entityManager.flush();
        entityManager.clear();

        Post retrievedPost1 = postRepo.findById(testPost1.getId()).get();
        Post retrievedPost2 = postRepo.findById(testPost2.getId()).get();

        assertThat(retrievedPost1.getHashtags()).contains(testHashtag1, testHashtag2);
        assertThat(retrievedPost2.getHashtags()).contains(testHashtag1, testHashtag3);


    }


}
