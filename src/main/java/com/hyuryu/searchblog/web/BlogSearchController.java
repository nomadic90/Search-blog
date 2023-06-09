package com.hyuryu.searchblog.web;

import com.hyuryu.searchblog.base.model.CodeResponse;
import com.hyuryu.searchblog.provider.KakaoBlogSearchProvider;
import com.hyuryu.searchblog.provider.NaverBlogSearchProvider;
import com.hyuryu.searchblog.service.BlogSearchCountService;
import com.hyuryu.searchblog.service.BlogSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogSearchController {
    @Autowired
    private BlogSearchCountService blogSearchCountService;

    private BlogSearchService blogSearchService;

    public BlogSearchController() {
        this.blogSearchService = new BlogSearchService(List.of(new KakaoBlogSearchProvider(), new NaverBlogSearchProvider()));
    }

    @GetMapping("/api/v1/search")
    public CodeResponse search(@RequestParam String query,
                                         @RequestParam(required = false, defaultValue = "accuracy") String sort,
                                         @RequestParam(required = false, defaultValue = "1") int page,
                                         @RequestParam(required = false, defaultValue = "10") int size) {
        blogSearchCountService.incrementSearchCount(query);
        return CodeResponse.successResult(blogSearchService.search(query, sort, page, size));
    }

    @GetMapping("/api/v1/top-keywords")
    public CodeResponse getTopKeyowrds() {
        return CodeResponse.successResult(blogSearchCountService.getTop10Keywords());
    }
}
