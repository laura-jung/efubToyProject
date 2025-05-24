package com.efub.tweeterdemo.users.repository;

import com.efub.tweeterdemo.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
