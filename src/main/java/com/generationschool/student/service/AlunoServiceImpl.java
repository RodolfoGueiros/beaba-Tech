package com.generationschool.student.service;

import com.generationschool.student.dto.request.RequestAlunoDTO;
import com.generationschool.student.dto.response.ResponseAlunoDTO;
import com.generationschool.student.entity.Aluno;
import com.generationschool.student.repository.AlunoRepository;
import com.generationschool.student.util.AlunoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper;


    @Override
    public ResponseAlunoDTO findById(Long id) {
        return alunoMapper.toAlunoDTO(returnAluno(id));
    }

    @Override
    public List<ResponseAlunoDTO> findAll() {
        return alunoMapper.toAlunoDTO(alunoRepository.findAll());
    }

    @Override
    public ResponseAlunoDTO register(RequestAlunoDTO alunoDTO) {

        Aluno aluno = alunoMapper.toaluno(alunoDTO);

        return alunoMapper.toAlunoDTO(alunoRepository.save(aluno));
    }

    @Override
    public ResponseAlunoDTO update(Long id, RequestAlunoDTO alunoDTO) {

        Aluno aluno = returnAluno(id);

        alunoMapper.updateAlunoData(aluno,alunoDTO);

        return alunoMapper.toAlunoDTO(alunoRepository.save(aluno));
    }

    @Override
    public String delete(Long id) {
        alunoRepository.deleteById(id);
        return "Aluno id: "+id+" Removido";
    }

    private Aluno returnAluno(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não foi encontrado na base de dados"));
    }

}