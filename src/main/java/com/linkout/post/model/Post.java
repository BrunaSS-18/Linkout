package com.linkout.post.model;

import com.linkout.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3000, nullable = false)
    private String content;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(nullable = false) //Não pode existir um post sem autor
    private User author;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime updateAt;

    @PrePersist
    void onCreate(){
        LocalDateTime agora = LocalDateTime.now();
        createdAt = agora;
        updateAt = agora;
    }

    @PreUpdate
    void onUpdate(){
        updateAt = LocalDateTime.now();
    }
}
