package com.efub.tweeterdemo.tweets.dto.response;

import com.efub.tweeterdemo.tweets.domain.Tweet;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TweetResponse {
    private Long tweetId;
    private String userName;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public TweetResponse(Tweet tweet){
        this.tweetId = tweet.getTweetId();
        this.userName = tweet.getWriter().getUserName();
        this.content = tweet.getContent();
        this.createdAt = tweet.getCreatedAt();
        this.modifiedAt = tweet.getModifiedAt();
    }

}
