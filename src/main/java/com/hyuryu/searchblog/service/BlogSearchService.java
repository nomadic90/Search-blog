package com.hyuryu.searchblog.service;

import com.hyuryu.searchblog.model.BlogSearchResult;
import com.hyuryu.searchblog.provider.BlogSearchProvider;
import com.hyuryu.searchblog.provider.KakaoBlogSearchProvider;
import com.hyuryu.searchblog.provider.NaverBlogSearchProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogSearchService {
    private final List<BlogSearchProvider> blogSearchProviders;

    public BlogSearchService(List<BlogSearchProvider> blogSearchProviders) {
        this.blogSearchProviders = blogSearchProviders;
    }

    public List<BlogSearchResult> search(String query, String sort, int page, int size) {
        for (BlogSearchProvider provider: blogSearchProviders) {
            try {
                return provider.search(query, sort, page, size);
            } catch (Exception e) {

            }
        }

        throw new RuntimeException("모든 검색 프로바이더에서 실패");
    }
}
