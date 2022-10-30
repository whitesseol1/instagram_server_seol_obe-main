package com.clone.instagram.repository;

import com.clone.instagram.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDao {
    private final JdbcTemplate jdbcTemplate;

    public int createPost(Post post){
        String createPostQuery = "insert into Post (user, content, location, open_level, random) VALUES (?,?,?,?,?)";
        Object[] createPostParams = new Object[]{post.getUser(), post.getContent(), post.getLocation(), post.getOpenLevel(), post.getRandom()};
        this.jdbcTemplate.update(createPostQuery, createPostParams);

        String lastInsertIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, int.class);
    }

    public List<Post> getPosts(){
        String getUsersQuery = "select post_idx, user, content, location, open_level, random from Post";
        return this.jdbcTemplate.query(getUsersQuery,
                (rs,rowNum) -> new Post(
                        rs.getInt("post_idx"),
                        rs.getInt("user"),
                        rs.getString("content"),
                        rs.getString("location"),
                        rs.getString("open_level"),
                        rs.getString("random")
                ));
    }
}
