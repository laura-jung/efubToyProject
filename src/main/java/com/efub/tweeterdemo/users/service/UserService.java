package com.efub.tweeterdemo.users.service;

import com.efub.tweeterdemo.global.exception.UserNotFoundException;
import com.efub.tweeterdemo.users.domain.User;
import com.efub.tweeterdemo.users.dto.response.UserResponse;
import com.efub.tweeterdemo.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //회원 상세 조회
    @Transactional(readOnly = true)
    public UserResponse getUser(Long userId){
        User user = findByUserId(userId);
        return UserResponse.from(user);

    }

    public User findByUserId(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}
