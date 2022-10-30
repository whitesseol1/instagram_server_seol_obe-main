package com.clone.instagram.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class PostRequest {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class create{
        private int postIdx;
        private int user;
        private String content;
        private String location;
        private String openLevel;
        private String random;
        private LocalDateTime created_at;
        private LocalDateTime updated_at;

    }
}
