package com.efub.tweeterdemo.global.exception;

public class EmptyTweetException extends CustomException{
    public EmptyTweetException(){
        super(ErrorCode.EMPTY_TWEET_CONTENT);
    }
}
