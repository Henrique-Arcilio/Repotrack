package com.repotrack.repotrack.respository;

import com.repotrack.repotrack.respository.enums.Priority;
import com.repotrack.repotrack.respository.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private Long githubId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String fullName;

    @Column(length = 200)
    private String description;

    private String language;

    private String avatarUrl;

    @Column(nullable = false)
    private String repositoryUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(length = 500)
    private String notes;

    @Column(nullable = false)
    private Integer stars;

    @Column(nullable = false)
    private Integer forks;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Repository(Long githubId,
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
                      String notes) {
        this.githubId = githubId;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.language = language;
        this.avatarUrl = avatarUrl;
        this.repositoryUrl = repositoryUrl;
        this.stars = stars;
        this.forks = forks;
        this.priority = priority;
        this.status = status;
        this.notes = notes;
    }
}
