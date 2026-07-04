package com.repotrack.repotrack.respository;

import com.repotrack.repotrack.respository.exception.DuplicateRepositoryException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RepositoryService {
    private final RepositoryRepository repoRepository;

    @Transactional
    public Repository save(Repository repository){

        repoRepository.findByGithubId(repository.getGithubId())
                .ifPresent(repo -> {
                    throw new DuplicateRepositoryException(
                            String.format(
                                    "Já existe um repositório com o GitHub ID %d.",
                                    repo.getGithubId()
                            )
                    );
                });

        return repoRepository.save(repository);
    }

}
