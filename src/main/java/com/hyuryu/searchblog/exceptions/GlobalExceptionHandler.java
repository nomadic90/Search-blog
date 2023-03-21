package com.hyuryu.searchblog.exceptions;

import com.hyuryu.searchblog.base.enums.SearchErrorType;
import com.hyuryu.searchblog.base.model.CodeResponse;
import com.hyuryu.searchblog.base.model.SearchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    SearchErrorType errorType;

    @ExceptionHandler
    @ResponseBody
    public CodeResponse handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        if (ex instanceof SearchException) {
            errorType = ((SearchException) ex).getErrorType();
            log.warn("[GlobalExceptionHandler] WARN : [{}] {}, {}", request.getRequestURI(), errorType.getCode(), errorType.getMessage());
        } else {
            errorType = SearchErrorType.INTERNAL_ERROR;
            log.error("[GlobalExceptionHandler] ERROR : [{}] {}", request.getRequestURI(), ex);
        }

        return CodeResponse.builder()
                            .code(errorType.getCode())
                            .message(errorType.getMessage())
                            .build();
    }
}
