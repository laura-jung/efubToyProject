package com.efub.tweeterdemo.global.exception.dto;

import com.efub.tweeterdemo.global.exception.ErrorCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus().value();
        this.error = errorCode.getStatus().name();
        this.message = errorCode.getMessage();
        this.timestamp = LocalDateTime.now();
    }

}
