package com.hyuryu.searchblog.base.model;

import com.hyuryu.searchblog.base.enums.SearchErrorType;
import lombok.Getter;

@Getter
public class SearchException extends RuntimeException {
    private SearchErrorType errorType;

    public SearchException(SearchErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public SearchException(SearchErrorType errorType, Throwable cause) {
        super(cause);
        this.errorType = errorType;
    }
}
