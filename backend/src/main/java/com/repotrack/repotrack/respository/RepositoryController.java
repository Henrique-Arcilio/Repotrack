package com.repotrack.repotrack.respository;

import com.repotrack.repotrack.respository.dto.RepositoryDto;
import com.repotrack.repotrack.respository.dto.RepositoryMapper;
import com.repotrack.repotrack.respository.dto.SaveRepositoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/repositorios")
@RequiredArgsConstructor
public class RepositoryController {

    private final RepositoryService repositoryService;

    @PostMapping
    public ResponseEntity<RepositoryDto> save(@RequestBody  @Valid SaveRepositoryDto dto){
        Repository repository = repositoryService.save(RepositoryMapper.toEntity(dto));
        return ResponseEntity.ok(RepositoryMapper.toDto(repository));
    }


}
