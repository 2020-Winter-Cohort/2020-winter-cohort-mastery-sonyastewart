package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TopicControllerTest {

    private TopicController underTest;
    private TopicStorage topicStorage;
    private Model model;
    private Topic testTopic;

    @BeforeEach
    void setUp() {
        topicStorage = mock(TopicStorage.class);
        underTest = new TopicController(topicStorage);
        model = mock(Model.class);
        testTopic = new Topic("Test Topic");
        when(topicStorage.retrieveSingleTopic(1L)).thenReturn(testTopic);

    }

    @Test
    public void displaySingleTopicShouldReturnSingleTopicTemplateName() {
        String templateName = underTest.displaySingleTopic(1L, model);
        assertThat(templateName).isEqualTo("single-topic-template");
    }

    @Test
    public void displaySingleTopicShouldRetrieveSingleTopicFromStorageAndAddItToModel() {
        underTest.displaySingleTopic(1L, model);
        verify(model).addAttribute("topic", testTopic);
    }

    @Test
    public void displaySingleTopicIsMappedForTheSingleTopicEndpoint() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/topics/1"))
                .andExpect(status().isOk());
    }
}
