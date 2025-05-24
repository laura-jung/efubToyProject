package com.efub.tweeterdemo.tweets.dto.request;

import com.efub.tweeterdemo.tweets.domain.Tweet;
import com.efub.tweeterdemo.users.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetCreateRequest(@NotNull Long userId,
                                 @NotBlank(message = "내용을 입력해주세요") String content) {

    public Tweet toEntity(User user){
        return Tweet.builder()
                .writer(user)
                .content(content)
                .build();
    }
}
