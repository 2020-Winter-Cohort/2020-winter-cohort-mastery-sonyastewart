package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;


public class HashtagStorageJpaImplTest {

    @Test
    public void hashtagStorageShouldSaveHashtag(){
        HashtagRepository hashtagRepo = mock(HashtagRepository.class);
        HashtagStorage underTest = new HashtagStorageJpaImpl(hashtagRepo);

        underTest.saveHashtag(new Hashtag("test"));

        verify(hashtagRepo).save(new Hashtag("test"));
    }

    @Test
    public void hashtagStorageShouldRetrieveAllHashtags(){
        HashtagRepository hashtagRepo = mock(HashtagRepository.class);
        HashtagStorage underTest = new HashtagStorageJpaImpl(hashtagRepo);
        when(hashtagRepo.findAll()).thenReturn(Collections.emptyList());

        Iterable<Hashtag> retrievedHashtags = underTest.retrieveAllHashtags();

        assertThat(retrievedHashtags).isEmpty();
    }

    @Test
    public void hashtagStorageShouldRetrieveHashtagById(){
        HashtagRepository hashtagRepo = mock(HashtagRepository.class);
        HashtagStorage underTest = new HashtagStorageJpaImpl(hashtagRepo);
        Hashtag mockHashtag = mock(Hashtag.class);
        when(hashtagRepo.findById(1L)).thenReturn(Optional.of(mockHashtag));

        Hashtag retrievedHashtag = underTest.retrieveHashtagById(1L);

        assertThat(retrievedHashtag).isEqualTo(mockHashtag);
    }
}
