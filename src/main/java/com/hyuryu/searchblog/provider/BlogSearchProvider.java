package com.hyuryu.searchblog.provider;

import com.hyuryu.searchblog.model.BlogSearchResult;

import java.util.List;

public interface BlogSearchProvider {
    List<BlogSearchResult> search(String query, String sort, int page, int size);
}
