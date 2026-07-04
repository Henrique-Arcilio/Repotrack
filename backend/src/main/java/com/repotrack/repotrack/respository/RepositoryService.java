package com.repotrack.repotrack.respository;

import com.repotrack.repotrack.respository.exception.DuplicateRepositoryException;
import com.repotrack.repotrack.respository.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    @Transactional(readOnly = false)
    public List<Repository> getAll(){
        return repoRepository.findAll();
    }

    @Transactional(readOnly = false)
    public Repository findById(UUID id){
        return repoRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Repositório com Id" + id +" não encontrado"));
    }

}
