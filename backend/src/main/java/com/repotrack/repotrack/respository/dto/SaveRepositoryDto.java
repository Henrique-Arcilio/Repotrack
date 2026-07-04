package com.repotrack.repotrack.respository.dto;

import com.repotrack.repotrack.respository.enums.Priority;
import com.repotrack.repotrack.respository.enums.Status;
import jakarta.validation.constraints.*;

public record SaveRepositoryDto (
        @NotNull(message = "O ID do GitHub é obrigatório.")
        Long githubId,

        @NotBlank(message = "O nome do repositório é obrigatório.")
        String name,

        @NotBlank(message = "O nome completo do repositório é obrigatório.")
        String fullName,

        @Size(max = 200, message = "A descrição deve ter no máximo 200 caracteres.")
        String description,

        String language,

        @NotBlank(message = "A URL do avatar é obrigatória.")
        String avatarUrl,

        @NotBlank(message = "A URL do repositório é obrigatória.")
        String repositoryUrl,

        @PositiveOrZero(message = "A quantidade de estrelas não pode ser negativa.")
        @NotNull(message = "Deve ser informada a quantidade de estrelas no repositorio ")        Integer stars,


        @PositiveOrZero(message = "A quantidade de forks não pode ser negativa.")
        @NotNull(message = "Deve ser informada a quantidade de forks no repositorio ")
        Integer forks,

        @NotNull(message = "A prioridade é obrigatória.")
        Priority priority,

        @NotNull(message = "O status é obrigatório.")
        Status status,

        @Size(max = 500, message = "As observações devem ter no máximo 500 caracteres.")
        String notes
){}

