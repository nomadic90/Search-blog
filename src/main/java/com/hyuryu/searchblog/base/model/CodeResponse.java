package com.hyuryu.searchblog.base.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@Builder
@AllArgsConstructor
public class CodeResponse implements Serializable {
    public final static String SUCCESS = "0";
    public final static String FAIL = "9999";

    @JsonProperty("code")
    String code;

    @JsonProperty("message")
    String message;

    @JsonProperty("result")
    Object result;

    public static CodeResponse successResult(Object result) {
        return CodeResponse.builder()
                .code(SUCCESS)
                .result(result)
                .build();
    }

    public static CodeResponse errorResult(String message) {
        return CodeResponse.builder()
                .code(FAIL)
                .message(message)
                .build();
    }
}
