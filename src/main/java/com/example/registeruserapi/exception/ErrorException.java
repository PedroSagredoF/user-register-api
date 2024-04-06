package com.example.registeruserapi.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorException extends RuntimeException {
    @JsonProperty("message")
    private String message;
    @JsonProperty("status_code")
    private int statusCode;

}
