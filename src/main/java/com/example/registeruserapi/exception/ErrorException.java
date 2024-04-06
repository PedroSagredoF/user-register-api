package com.example.registeruserapi.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorException extends RuntimeException {
    @JsonProperty("message")
    private String message;
    @JsonProperty("status_code")
    private int statusCode;

    public ErrorException(int statusCode, String message, String uriRequested) {
        this.message = message;
        this.statusCode = statusCode;

    }
}
