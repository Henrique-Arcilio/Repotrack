package com.repotrack.repotrack.respository.dto;

import com.repotrack.repotrack.respository.enums.Priority;
import com.repotrack.repotrack.respository.enums.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EditRepositoryDto (
    @NotNull(message = "A prioridade é obrigatória.")
    Priority priority,

    @NotNull(message = "O status é obrigatório.")
    Status status,

    @Size(max = 500, message = "As observações devem ter no máximo 500 caracteres.")
    String notes
){}
