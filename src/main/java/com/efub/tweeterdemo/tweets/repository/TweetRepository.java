package com.efub.tweeterdemo.tweets.repository;

import com.efub.tweeterdemo.tweets.domain.Tweet;
import com.efub.tweeterdemo.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Optional<Tweet> findByWriterUserId(Long userId);

    List<Tweet> findAllByOrderByCreatedAtDesc();
}
