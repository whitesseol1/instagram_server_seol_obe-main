package com.clone.instagram.domain;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int postIdx;
    private int user;
    private String content;
    private String location;
    private String openLevel;
    private String random;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Builder
    public Post(int postIdx,int user, String content, String location, String openLevel, String random) {
        this.postIdx = postIdx;
        this.user = user;
        this.content = content;
        this.location = location;
        this.openLevel = openLevel;
        this.random = random;
    }
}
