package com.br.helpdesk.services.chamados.form;

public record ChamadoForm(
        String chaTxTitulo,
        String chaTxDescricao,
        String chaTxStatus,
        Long chaNrIdCliente,
        Long chaNrIdTecnico
) {
}
