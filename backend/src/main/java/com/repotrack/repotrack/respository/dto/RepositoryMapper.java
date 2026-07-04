package com.repotrack.repotrack.respository.dto;

import com.repotrack.repotrack.respository.Repository;

public class RepositoryMapper {

    public static Repository toEntity(SaveRepositoryDto dto){
        return new Repository(
                        dto.githubId(),
                        dto.name(),
                        dto.fullName(),
                        dto.description(),
                        dto.language(),
                        dto.avatarUrl(),
                        dto.repositoryUrl(),
                        dto.stars(),
                        dto.forks(),
                        dto.priority(),
                        dto.status(),
                        dto.notes()
        );
    }

    public static RepositoryDto toDto(Repository repository){
        return new RepositoryDto(
                repository.getId(),
                repository.getGithubId(),
                repository.getName(),
                repository.getFullName(),
                repository.getDescription(),
                repository.getLanguage(),
                repository.getAvatarUrl(),
                repository.getRepositoryUrl(),
                repository.getStars(),
                repository.getForks(),
                repository.getPriority(),
                repository.getStatus(),
                repository.getNotes(),
                repository.getCreatedAt()
        );
    }
}
