package com.generationschool.student.service;


import com.generationschool.student.dto.request.RequestAlunoDTO;
import com.generationschool.student.dto.response.ResponseAlunoDTO;

import java.util.List;

public interface AlunoService {

    ResponseAlunoDTO findById(Long id);

    List<ResponseAlunoDTO> findAll();

    ResponseAlunoDTO register(RequestAlunoDTO alunoDTO);

    ResponseAlunoDTO update(Long id, RequestAlunoDTO alunoDTO);

    String delete(Long id);
}
