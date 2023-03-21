package com.hyuryu.searchblog.model;

import lombok.Getter;

import java.util.List;

@Getter
public class NaverBlogSearchResponse {
    private List<NaverBlogSearchItem> items;

    @Getter
    public static class NaverBlogSearchItem {
        private String title;
        private String link;
        private String bloggername;
        private String postdate;
    }
}
