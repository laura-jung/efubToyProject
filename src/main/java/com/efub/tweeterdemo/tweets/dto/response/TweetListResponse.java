package com.efub.tweeterdemo.tweets.dto.response;

import lombok.Getter;
import java.util.*;

@Getter
public class TweetListResponse {
    private final List<TweetResponse> tweets;

    public TweetListResponse(List<TweetResponse> tweets){
        this.tweets = tweets;
    }
}
