package com.generationschool.student.controller;

import com.generationschool.student.dto.request.RequestAlunoDTO;
import com.generationschool.student.dto.response.ResponseAlunoDTO;
import com.generationschool.student.entity.Aluno;
import com.generationschool.student.repository.AlunoRepository;
import com.generationschool.student.service.AlunoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    @Autowired 
    private AlunoRepository alunoRepository;

    @GetMapping(value = "/alunos/{id}")
    public ResponseEntity<ResponseAlunoDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(alunoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponseAlunoDTO>> findAll() {
        return ResponseEntity.ok().body(alunoService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<Aluno> register(@Valid @RequestBody Aluno aluno, UriComponentsBuilder uriBuilder) {

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
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
