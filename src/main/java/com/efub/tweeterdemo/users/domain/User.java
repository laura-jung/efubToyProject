package com.efub.tweeterdemo.users.domain;

import com.efub.tweeterdemo.global.entity.BaseTimeEntity;
import com.efub.tweeterdemo.tweets.domain.Tweet;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    //닉네임
    @Column(nullable = false, unique = true)
    private String userName;

    //생일
    @Column
    private Date birth;

    //번호
    @Column
    private String phone;

    //팔로워
    @Column
    private int follower;

    //팔로잉
    @Column
    private int following;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //한줄 소개 default = 한줄 소개를 추가해주세요
    @Column
    private String bio = "한줄 소개를 추가해주세요";

    // 작성한 tweet 목록
    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tweet> tweetList = new ArrayList<>();

    @Builder
    public User (String userName, Date birth, String phone, String password, String bio) {
        this.userName = userName;
        this.birth = birth;
        this.phone = phone;
        this.password = password;
        this.bio = (bio != null) ? bio : "한줄 소개를 추가해주세요";
        this.follower = 0;
        this.following = 0;
    }
}
