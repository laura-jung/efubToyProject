package com.efub.tweeterdemo.global.exception;

public class LongTweetException extends CustomException{
    public LongTweetException(){
        super(ErrorCode.LONG_TWEET_CONTENT);
    }
}
