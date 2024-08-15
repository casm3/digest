package com.saosebastiao.digest.dto;

public record EnderecoDto(
        Long id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {
}
