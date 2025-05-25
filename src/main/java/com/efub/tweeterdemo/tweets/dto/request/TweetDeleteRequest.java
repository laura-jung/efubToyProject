package com.efub.tweeterdemo.tweets.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TweetDeleteRequest {
    private Long userId;
    private String password;


}
