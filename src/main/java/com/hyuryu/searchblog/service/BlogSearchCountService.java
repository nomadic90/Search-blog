package com.hyuryu.searchblog.service;

import com.hyuryu.searchblog.entity.SearchCount;
import com.hyuryu.searchblog.repository.SearchCountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogSearchCountService {
    private SearchCountRepository searchCountRepository;

    public BlogSearchCountService(SearchCountRepository searchCountRepository) {
        this.searchCountRepository = searchCountRepository;
    }

    public void incrementSearchCount(String keyword) {
        SearchCount searchCount = searchCountRepository.findByKeyword(keyword);
        if (searchCount == null) {
            searchCount = new SearchCount(keyword, 1);
        } else {
            searchCount.setCount(searchCount.getCount()+1);
        }

        searchCountRepository.save(searchCount);
    }

    public List<SearchCount> getTop10Keywords() {
        return searchCountRepository.findTop10ByOrderByCountDesc();
    }
}
