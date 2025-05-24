package com.efub.tweeterdemo.tweets.domain;

import com.efub.tweeterdemo.global.entity.BaseTimeEntity;
import com.efub.tweeterdemo.users.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;

    //작성한 사용자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User writer;

    //내용
    @Column(nullable = false, length = 200)
    @Size(max = 200, message = "트윗은 200자까지 작성 가능합니다.")
    private String content;

    @Builder
    public Tweet(User writer, String content){
        this.writer = writer;
        this.content = content;
    }


}
