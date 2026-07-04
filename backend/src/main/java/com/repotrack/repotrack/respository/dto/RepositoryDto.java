package com.repotrack.repotrack.respository.dto;

import com.repotrack.repotrack.respository.enums.Priority;
import com.repotrack.repotrack.respository.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record RepositoryDto(
        UUID id,
        Long githubId,
        String name,
        String fullName,
        String description,
        String language,
        String avatarUrl,
        String repositoryUrl,
        Integer stars,
        Integer forks,
        Priority priority,
        Status status,
        String notes,
        LocalDateTime createdAt
) {}