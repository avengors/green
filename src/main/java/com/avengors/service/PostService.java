package com.avengors.service;

import com.avengors.entity.Post;
import com.avengors.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post write(int midx, Post post, MultipartFile file, String path) throws IOException {
        if (!file.isEmpty()) {
            saveFile(file, path);
            post.setUploadfile(file.getOriginalFilename());
        }

        post.setMidx(midx);

        postRepository.save(post);
        return post;
    }

    private void saveFile(MultipartFile file, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) dir.mkdirs();

        String fullPath = path + "/" + file.getOriginalFilename();
        file.transferTo(new File(fullPath));
    }
}
