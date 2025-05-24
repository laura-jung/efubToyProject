package com.efub.tweeterdemo.tweets.controller;

import com.efub.tweeterdemo.tweets.domain.Tweet;
import com.efub.tweeterdemo.tweets.dto.request.TweetCreateRequest;
import com.efub.tweeterdemo.tweets.dto.response.TweetCreateResponse;
import com.efub.tweeterdemo.tweets.dto.response.TweetListResponse;
import com.efub.tweeterdemo.tweets.dto.response.TweetResponse;
import com.efub.tweeterdemo.tweets.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class tweetController {

    private final TweetService tweetService;

    //트윗 등록
    @PostMapping
    public ResponseEntity<TweetCreateResponse> createTweet(@RequestBody TweetCreateRequest request){
        Tweet tweet = tweetService.createTweet(request);
        TweetCreateResponse response = TweetCreateResponse.from(tweet);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tweet.getTweetId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    //트윗 삭제
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<String> deleteTweet(@PathVariable("tweetId") Long tweetId,
                                              @RequestHeader("AUTH_ID") Long userId,
                                              @RequestHeader("AUTH_PASSWORD") String password){
        tweetService.deleteTweet(tweetId, userId, password);
        return ResponseEntity.ok("트윗이 삭제되었습니다.");
    }

    //전체 트윗 조회
    @GetMapping
    public ResponseEntity<TweetListResponse> getAllTweets(){
        TweetListResponse response = tweetService.getAllTweets();
        return ResponseEntity.ok(response);
    }

    //트윗 상세조회
    @GetMapping("/{tweetId}")
    public ResponseEntity<TweetResponse> getTweet(@PathVariable("tweetId") Long tweetId){
        TweetResponse response = tweetService.getTweetByID(tweetId);
        return ResponseEntity.ok(response);
    }

}
