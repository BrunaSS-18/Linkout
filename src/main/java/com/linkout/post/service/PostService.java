package com.linkout.post.service;

import com.linkout.post.dtos.PostRequest;
import com.linkout.post.dtos.PostResponse;
import com.linkout.post.dtos.PostUpdateRequest;
import com.linkout.post.mapper.PostMapper;
import com.linkout.post.model.Post;
import com.linkout.post.repository.PostRepository;
import com.linkout.user.model.User;
import com.linkout.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, UserRepository userRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postMapper = postMapper;
    }

    public PostResponse create(PostRequest request){
        User author = userRepository.findById(request.authorId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + request.authorId()));

        Post post = postMapper.toEntity(request);
        post.setAuthor(author);

        Post savedPost = postRepository.save(post);

        return postMapper.toResponse(savedPost);
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        postRepository.delete(post);
    }

    public PostResponse update(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        post.setContent(request.content());

        return postMapper.toResponse(postRepository.save(post));
    }
}
