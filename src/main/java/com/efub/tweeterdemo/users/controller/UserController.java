package com.efub.tweeterdemo.users.controller;

import com.efub.tweeterdemo.users.dto.response.UserResponse;
import com.efub.tweeterdemo.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //사용자 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long userId){
        UserResponse response =userService.getUser(userId);
        return ResponseEntity.ok(response);
    }
}
