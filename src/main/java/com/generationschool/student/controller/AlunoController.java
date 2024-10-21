package com.generationschool.student.controller;

import jakarta.validation.Valid;
import com.generationschool.student.dto.request.RequestAlunoDTO;
import com.generationschool.student.dto.response.ResponseAlunoDTO;
import com.generationschool.student.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping(value = "/alunos/{id}")
    public ResponseEntity<ResponseAlunoDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(alunoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponseAlunoDTO>> findAll() {
        return ResponseEntity.ok().body(alunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ResponseAlunoDTO> register(@Valid @RequestBody RequestAlunoDTO requestAlunoDTO, UriComponentsBuilder uriBuilder) {

        ResponseAlunoDTO responseAlunoDTO = alunoService.register(requestAlunoDTO);

        URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(responseAlunoDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(responseAlunoDTO);
    }

    @PutMapping(value = "/alunos/{id}")
    public ResponseEntity<ResponseAlunoDTO> update(@RequestBody RequestAlunoDTO alunoDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(alunoService.update(id, alunoDTO));
    }

    @DeleteMapping(value = "/alunos/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(alunoService.delete(id));
    }


}
