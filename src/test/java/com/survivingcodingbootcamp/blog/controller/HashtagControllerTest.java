package com.survivingcodingbootcamp.blog.controller;
import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class HashtagControllerTest {
    private HashtagController underTest;
    private HashtagStorage hashtagStorage;
    private PostStorage postStorage;
    private HashtagRepository hashtagRepo;
    private PostRepository postRepo;
    private Model model;
    private Hashtag testHashtag;
    @BeforeEach
    void setUp() {
        hashtagStorage = mock(HashtagStorage.class);
        underTest = new HashtagController(hashtagStorage, postStorage);
        model = mock(Model.class);
        testHashtag = new Hashtag("Test Hashtag");
        when(hashtagStorage.retrieveHashtagById(testHashtag.getId()));
    }
    @Test
    public void displaySingleHashtagShouldReturnSingleHashtagTemplateName() {
        String templateName = underTest.displaySingleHashtag(1L, model);
        assertThat(templateName).isEqualTo("single-hashtag-template");
    }
    @Test
    public void displaySingleHashtagShouldRetrieveSingleHashtagFromStorageAndAddItToModel() {
        underTest.displaySingleHashtag(1L, model);
        verify(model).addAttribute("hashtag", testHashtag);
    }
    @Test
    public void displaySingleHashtagIsMappedForTheSingleHashtagEndpoint() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/hashtags/1"))
                .andExpect(status().isOk());
    }
}
