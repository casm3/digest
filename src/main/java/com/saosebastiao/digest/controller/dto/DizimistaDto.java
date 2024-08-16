package com.saosebastiao.digest.controller.dto;

import java.time.LocalDate;
import java.util.List;

public record DizimistaDto(
        Long id,
        String nome,
        String cpf,
        EnderecoDto endereco,
        String telefone,
        String email,
        LocalDate dataNascimento,
        LocalDate dataCadastro,
        List<ContribuicaoDto> contribuicoes) {

}
