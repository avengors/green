package com.avengors.repository;

import com.avengors.entity.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {
    int save(Post post);
}
