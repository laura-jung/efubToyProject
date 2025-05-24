package com.efub.tweeterdemo.tweets.dto.response;

import com.efub.tweeterdemo.tweets.domain.Tweet;

import java.time.LocalDateTime;

public record TweetCreateResponse(Long tweetId,
                                  Long userId,
                                  String userName,
                                  String content,
                                  LocalDateTime createdAt) {
    public static TweetCreateResponse from(Tweet tweet){
        return new TweetCreateResponse(
            tweet.getTweetId(),
                tweet.getWriter().getUserId(),
                tweet.getWriter().getUserName(),
                tweet.getContent(),
                tweet.getCreatedAt()
        );
    }
}
