package com.linkout.user.dtos;

public record UserResponse(
        Long id,
        String name,
        String email,
        String username,
        String profileImageUrl,
        String bio
) {
}