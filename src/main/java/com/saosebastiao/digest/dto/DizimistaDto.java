package com.saosebastiao.digest.dto;

import com.saosebastiao.digest.entity.Contribuicao;
import com.saosebastiao.digest.entity.Dizimista;
import com.saosebastiao.digest.entity.Endereco;

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
