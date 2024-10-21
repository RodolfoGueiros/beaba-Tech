package com.generationschool.student.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_aluno")
@NoArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "idade", nullable = false, unique = false)
    private Integer idade;

    @Column(name = "notaPrimeiroSemestre", nullable = false, unique = false)
    private Double notaPrimeiroSemestre;

    @Column(name = "notaSegundoSemestre", nullable = false, unique = false)
    private Double notaSegundoSemestre;

    @Column(name = "nomeProfessor", nullable = false, unique = false)
    private String nomeProfessor;

    @Column(name = "numeroSala", nullable = false, unique = false)
    private Integer numeroSala;

    @Builder
    public Aluno(String name, Integer idade, Double notaPrimeiroSemestre, Double notaSegundoSemestre, String nomeProfessor, Integer numeroSala ) {
        this.name = name;
        this.idade = idade;
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
        this.notaSegundoSemestre = notaSegundoSemestre;
        this.nomeProfessor = nomeProfessor;
        this.numeroSala = numeroSala;
    }
}
