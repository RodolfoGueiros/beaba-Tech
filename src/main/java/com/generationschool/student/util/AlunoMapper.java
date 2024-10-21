package com.generationschool.student.util;

import com.generationschool.student.dto.request.RequestAlunoDTO;
import com.generationschool.student.dto.response.ResponseAlunoDTO;
import com.generationschool.student.entity.Aluno;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlunoMapper {
    public Aluno toaluno(RequestAlunoDTO alunoDTO) {

        return Aluno.builder()
                .name(alunoDTO.getName())
                .idade(alunoDTO.getIdade())
                .notaPrimeiroSemestre(alunoDTO.getNotaPrimeiroSemestre())
                .notaSegundoSemestre(alunoDTO.getNotaSegundoSemestre())
                .build();

    }

    public ResponseAlunoDTO toAlunoDTO(Aluno aluno) {
        return new ResponseAlunoDTO(aluno);
    }

    public List<ResponseAlunoDTO> toAlunoDTO(List<Aluno> alunoList) {
        return alunoList.stream().map(ResponseAlunoDTO::new).collect(Collectors.toList());
    }

    public void updateAlunoData(Aluno aluno, RequestAlunoDTO alunoDTO) {

        aluno.setName(alunoDTO.getName());
        aluno.setIdade(alunoDTO.getIdade());
        aluno.setNotaPrimeiroSemestre(alunoDTO.getNotaSegundoSemestre());
        aluno.setNotaSegundoSemestre(alunoDTO.getNotaSegundoSemestre());
      

    }

}