package com.clone.instagram.service;

import com.clone.instagram.domain.Post;
import com.clone.instagram.dto.PostRequest;
import com.clone.instagram.repository.PostDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public int createPost(PostRequest.create create){
        try{
            String random = randomString();
            Post post = Post.builder()
                    .content(create.getContent())
                    .location(create.getLocation())
                    .openLevel(create.getOpenLevel())
                    .random(random)
                    .user(create.getUser())
                    .build();
            int postIdx = postDao.createPost(post);
            return postIdx;
        }catch (Exception e){
            log.info("SQL exception : " + e.getMessage());
            throw new IllegalArgumentException("SQL exception");
        }
    }

    private String randomString(){
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        Random generator = new java.util.Random();
        generator.setSeed(System.currentTimeMillis());
        return String.valueOf(generator.nextInt(1000000) % 1000000);
    }


    public List<Post> getPostList() {
        List<Post> postList = postDao.getPosts();
        return postList;
    }
}
