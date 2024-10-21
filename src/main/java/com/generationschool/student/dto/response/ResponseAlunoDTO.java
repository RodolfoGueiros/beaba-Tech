package com.generationschool.student.dto.response;

import com.generationschool.student.entity.Aluno;
import lombok.Getter;

@Getter
public class ResponseAlunoDTO {

    private Long id;

    private String name;

    private Integer idade;

    private Double notaPrimeiroSemestre;

    private Double notaSegundoSemestre;

    public ResponseAlunoDTO(Long id, String name, Integer idade, Double notaPrimeiroSemestre, Double notaSegundoSemestre, String nomeProfessor, Integer numeroSala) {
        this.id = id;
        this.name = name;
        this.idade = idade;
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
        this.notaSegundoSemestre = notaSegundoSemestre;
        
    }

    public ResponseAlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.name = aluno.getName();
        this.idade = aluno.getIdade();
        this.notaPrimeiroSemestre = aluno.getNotaPrimeiroSemestre();
        this.notaSegundoSemestre = aluno.getNotaSegundoSemestre();
       
    }
}
