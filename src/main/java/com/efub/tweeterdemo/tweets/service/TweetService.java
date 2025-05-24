package com.efub.tweeterdemo.tweets.service;

import com.efub.tweeterdemo.global.exception.TweetNotFoundException;
import com.efub.tweeterdemo.global.exception.UserNotFoundException;
import com.efub.tweeterdemo.tweets.domain.Tweet;
import com.efub.tweeterdemo.tweets.dto.request.TweetCreateRequest;
import com.efub.tweeterdemo.tweets.dto.response.TweetListResponse;
import com.efub.tweeterdemo.tweets.dto.response.TweetResponse;
import com.efub.tweeterdemo.tweets.repository.TweetRepository;
import com.efub.tweeterdemo.users.domain.User;
import com.efub.tweeterdemo.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    //트윗 등록
    @Transactional
    public Tweet createTweet(TweetCreateRequest request){
        Long userId = request.userId();
        User writer = findByUserId(userId);
        Tweet newTweet = request.toEntity(writer);
        return tweetRepository.save(newTweet);
    }

    //트윗 삭제
    @Transactional
    public void deleteTweet(Long tweetId, Long userId, String password){
        Tweet tweet = findByTweetId(tweetId);
        User user = findByUserId(userId);
        authorizeTweetOwner(tweet, user, password);
        tweetRepository.delete(tweet);
    }

    //전체 트윗 조회
    @Transactional
    public TweetListResponse getAllTweets(){
        List<TweetResponse> tweets = tweetRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(TweetResponse::new)
                .collect(Collectors.toList());

        return new TweetListResponse(tweets);
    }

    //트윗 상세 정보 조회
    @Transactional
    public TweetResponse getTweetByID(Long tweetId){
        Tweet tweet = findByTweetId(tweetId);
        return new TweetResponse(tweet);
    }
    public User findByUserId(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public Tweet findByTweetId(Long tweetId){
        return tweetRepository.findById((tweetId))
                .orElseThrow(TweetNotFoundException::new);
    }

    private void authorizeTweetOwner(Tweet tweet, User user, String password) {
        if (!tweet.getWriter().equals(user) || !tweet.getWriter().getPassword().equals(password)) {
            throw new IllegalArgumentException("작성자가 아닙니다.");
        }
    }
}
