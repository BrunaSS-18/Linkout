package com.linkout.post.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostRequest(

        @Size(max = 5000, message = "O conteúdo deve ter no máximo 5000 caracteres")
        String content,

        String imageUrl,

        @NotNull(message = "O ID do autor é obrigatório")
        Long authorId
) {
}
