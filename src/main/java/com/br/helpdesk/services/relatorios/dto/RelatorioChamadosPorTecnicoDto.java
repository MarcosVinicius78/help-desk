package com.br.helpdesk.services.relatorios.dto;

public record RelatorioChamadosPorTecnicoDto(
        String tecnico,
        Long totalChamados
) {
}
