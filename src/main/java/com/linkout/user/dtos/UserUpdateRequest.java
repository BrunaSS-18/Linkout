package com.linkout.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(
        @Size(max = 100)
        @NotBlank(message = "Nome é obrigatório")
        String name,

        @Size(max = 500)
        String bio,

        @Size(max = 150)
        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        String email
) {
}
