package com.efub.tweeterdemo.users.dto.response;

import com.efub.tweeterdemo.tweets.dto.response.TweetCreateResponse;
import com.efub.tweeterdemo.users.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class UserResponse {
    private Long userId;
    private String userName;
    private Date birth;
    private String phone;
    private String bio;
    private int follower;
    private int following;
    //트윗 목록 추가 필요


    public static UserResponse from(User user){
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .birth(user.getBirth())
                .bio(user.getBio())
                .phone(user.getPhone())
                .follower(user.getFollower())
                .following(user.getFollowing())  //트윗 목록 추가 필요
                .build();
    }
}
