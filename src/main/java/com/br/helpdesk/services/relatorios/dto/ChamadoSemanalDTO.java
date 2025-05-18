package com.br.helpdesk.services.relatorios.dto;

import java.math.BigDecimal;

public record ChamadoSemanalDTO(
        String semanaInicio,
        BigDecimal diaSemanaNumero,
        String diaSemanaNome,
        long total
) {
}
