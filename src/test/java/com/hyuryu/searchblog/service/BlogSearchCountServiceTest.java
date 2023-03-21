package com.hyuryu.searchblog.service;

import com.hyuryu.searchblog.entity.SearchCount;
import com.hyuryu.searchblog.repository.SearchCountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;

public class BlogSearchCountServiceTest {
//    private BlogSearchCountService blogSearchCountService;
//    private SearchCountRepository searchCountRepository;
//
//    @BeforeEach
//    public void setUp() {
//        searchCountRepository = Mockito.mock(SearchCountRepository.class);
//        blogSearchCountService = new BlogSearchCountService(searchCountRepository);
//    }
//
//    @Test
//    public void incrementSearchCountTest() {
//        // Arrange
//        SearchCount searchCount = new SearchCount("query", 1);
//        Mockito.when(searchCountRepository.findByKeyword(anyString())).thenReturn(null);
//        Mockito.when(searchCountRepository.save(any(SearchCount.class))).thenReturn(searchCount);
//
//        // Act
//        blogSearchCountService.incrementSearchCount("query");
//
//        // Assert
//        Mockito.verify(searchCountRepository).findByKeyword("query");
//        Mockito.verify(searchCountRepository).save(searchCount);
//    }
//
//    @Test
//    public void getTop10KeywordsTest() {
//        // Arrange
//        List<SearchCount> expectedResult = Arrays.asList(
//                new SearchCount("query1", 5),
//                new SearchCount("query2", 3)
//        );
//        Mockito.when(searchCountRepository.findTop10ByOrderByCountDesc()).thenReturn(expectedResult);
//
//        // Act
//        List<SearchCount> actualResult = blogSearchCountService.getTop10Keywords();
//
//        // Assert
//        assertEquals(expectedResult, actualResult);
//        Mockito.verify(searchCountRepository).findTop10ByOrderByCountDesc();
//    }
}
