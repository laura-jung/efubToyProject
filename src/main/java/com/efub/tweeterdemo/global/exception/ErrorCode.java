package com.efub.tweeterdemo.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    //user
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    DUPLICATE_USERNAME(HttpStatus.BAD_REQUEST,"이미 존재하는 사용자 닉네임입니다."),

    //tweet
    TWEET_NOT_FOUND(HttpStatus.NOT_FOUND, "트윗을 찾을 수 없습니다."),
    EMPTY_TWEET_CONTENT(HttpStatus.BAD_REQUEST, "트윗 내용은 비어있을 수 없습니다. "),
    LONG_TWEET_CONTENT(HttpStatus.BAD_REQUEST, "트윗 내용은 200자 이내로 작성해주세요."),

    // 기타
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
