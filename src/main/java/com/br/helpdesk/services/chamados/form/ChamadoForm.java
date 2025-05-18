package com.br.helpdesk.services.chamados.form;

import com.br.helpdesk.models.chamados.enums.StatusChamados;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record ChamadoForm(
        String chaTxTitulo,
        String chaTxDescricao,
        @Enumerated(EnumType.STRING)
        StatusChamados chaTxStatus,
        Long chaNrIdCliente,
        Long chaNrIdTecnico,
        Long catNrId
) {
        public String chaTxStatusStr() {
                return chaTxStatus != null ? chaTxStatus.name() : null;
        }
}
