package com.saosebastiao.digest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContribuicaoDto(
        Long id,
        BigDecimal valor,
        LocalDate dataContribuicao,
        String metodoContribuicao
) {
}
