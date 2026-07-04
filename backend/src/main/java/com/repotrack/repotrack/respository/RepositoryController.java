package com.repotrack.repotrack.respository;

import com.repotrack.repotrack.respository.dto.EditRepositoryDto;
import com.repotrack.repotrack.respository.dto.RepositoryDto;
import com.repotrack.repotrack.respository.dto.RepositoryMapper;
import com.repotrack.repotrack.respository.dto.SaveRepositoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/repositories")
@RequiredArgsConstructor
public class RepositoryController {

    private final RepositoryService repositoryService;

    @PostMapping
    public ResponseEntity<RepositoryDto> save(@RequestBody  @Valid SaveRepositoryDto dto){
        Repository repository = repositoryService.save(RepositoryMapper.toEntity(dto));
        return ResponseEntity.ok(RepositoryMapper.toDto(repository));
    }

    @GetMapping
    public ResponseEntity<List<RepositoryDto>> getAll(){
        List<RepositoryDto> response =
                repositoryService
                        .getAll()
                        .stream()
                        .map(RepositoryMapper::toDto)
                        .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepositoryDto> getByid(@PathVariable UUID id){
        return ResponseEntity.ok(RepositoryMapper.toDto(repositoryService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepositoryDto> edit(@PathVariable UUID id, @RequestBody EditRepositoryDto dto ){
        return ResponseEntity.ok(RepositoryMapper.toDto(repositoryService.edit(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        repositoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
