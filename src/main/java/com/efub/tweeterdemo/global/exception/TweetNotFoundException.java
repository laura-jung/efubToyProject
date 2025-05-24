package com.efub.tweeterdemo.global.exception;

public class TweetNotFoundException extends CustomException{
    public TweetNotFoundException(){
        super(ErrorCode.TWEET_NOT_FOUND);
    }
}
