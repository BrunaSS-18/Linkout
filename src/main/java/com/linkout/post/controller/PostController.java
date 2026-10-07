package com.linkout.post.controller;

import com.linkout.post.dtos.PostRequest;
import com.linkout.post.dtos.PostResponse;
import com.linkout.post.dtos.PostUpdateRequest;
import com.linkout.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Posts", description = "CRUD de Posts")
public class PostController {
    
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }
    
    @PostMapping
    @Operation(summary = "Cria um novo post")
    public ResponseEntity<PostResponse> create (@Valid @RequestBody PostRequest request){
        return ResponseEntity.status(201).body(service.create(request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um post")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um post")
    public PostResponse update(@PathVariable Long id, @Valid @RequestBody PostUpdateRequest postRequest){
        return service.update(id, postRequest);
    }
}
