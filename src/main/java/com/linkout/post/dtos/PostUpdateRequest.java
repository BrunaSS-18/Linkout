package com.linkout.post.dtos;

import jakarta.validation.constraints.NotBlank;

public record PostUpdateRequest(
        @NotBlank(message = "O conteúdo é obrigatório")
        String content
) {
}
