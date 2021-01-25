package com.survivingcodingbootcamp.blog.integration;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class WebMvcLayerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicStorage topicStorage;
    @MockBean
    private PostStorage postStorage;

    @Test
    public void shouldReceiveOKAndViewOfHomeTemplateFromHomeEndpoint() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("topics"))
                .andExpect(view().name("home-template"));
    }
    @Test
    public void shouldReceiveOKAndViewOfTopicTemplateFromSingleTopicEndpoint() throws Exception {
        Topic testTopic = new Topic("Test Topic");
        when(topicStorage.retrieveSingleTopic(1L)).thenReturn(testTopic);
        mockMvc.perform(get("/topics/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("topic"))
                .andExpect(model().attribute("topic", testTopic))
                .andExpect(view().name("single-topic-template"));
    }
    @Test
    public void shouldReceiveOkAndViewOfPostTemplateFromSinglePostEndpoint() throws Exception {
        Topic testTopic = new Topic("Test Topic");
        Post testPost = new Post("Test Post", testTopic, "Sample content.");
        when(postStorage.retrievePostById(1L)).thenReturn(testPost);
        mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attribute("post", testPost))
                .andExpect(view().name("single-post-template"));
    }
}
