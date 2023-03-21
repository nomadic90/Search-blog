package com.hyuryu.searchblog.service;

import com.hyuryu.searchblog.base.enums.SearchErrorType;
import com.hyuryu.searchblog.base.model.SearchException;
import com.hyuryu.searchblog.model.BlogSearchResult;
import com.hyuryu.searchblog.provider.BlogSearchProvider;
import com.hyuryu.searchblog.provider.KakaoBlogSearchProvider;
import com.hyuryu.searchblog.provider.NaverBlogSearchProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BlogSearchService {
    private final List<BlogSearchProvider> blogSearchProviders;

    public BlogSearchService(List<BlogSearchProvider> blogSearchProviders) {
        this.blogSearchProviders = blogSearchProviders;
    }

    public List<BlogSearchResult> search(String query, String sort, int page, int size) throws SearchException {
        for (BlogSearchProvider provider: blogSearchProviders) {
            try {
                return provider.search(query, sort, page, size);
            } catch (Exception e) {
                log.warn("provider: {} 장애로 검색 안됨", provider.getClass().getName());
            }
        }

        throw new SearchException(SearchErrorType.INTERNAL_ERROR, "검색 provider all down");
    }
}
