package com.generationschool.student.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_aluno")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", nullable = true, unique = false)
    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, message = "O nome deve ter pelos menos 3 caracteres.")
    private String name;

    @Column(name = "idade", nullable = false, unique = false)
    private Integer idade;

    @Column(name = "notaPrimeiroModulo", nullable = false, unique = false)
    private Double notaPrimeiroSemestre;

    @Column(name = "notaSegundoModulo", nullable = false, unique = false)
    private Double notaSegundoSemestre;

    // @Column(name = "media", nullable = false, unique = false)
    // private Integer media;
  
    @Builder
    public Aluno(String name, Integer idade, Double notaPrimeiroSemestre, Double notaSegundoSemestre) {
       this.name = name;
        this.idade = idade;
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
        this.notaSegundoSemestre = notaSegundoSemestre;
      
    }
}
