package com.clone.instagram.controller;

import com.clone.instagram.domain.Post;
import com.clone.instagram.dto.JsonResponse;
import com.clone.instagram.dto.PostRequest;
import com.clone.instagram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post/create")
    public ResponseEntity<Object> createPost(@RequestBody PostRequest.create create){
        int postIdx = postService.createPost(create);
        return ResponseEntity.ok(new JsonResponse(200, true,"createPost", postIdx));
    }

    @GetMapping("/postList")
    public ResponseEntity<Object> getPostList(){
        List<Post> postList = postService.getPostList();
        return ResponseEntity.ok(new JsonResponse(200, true, "getPostList",postList));
    }
}
