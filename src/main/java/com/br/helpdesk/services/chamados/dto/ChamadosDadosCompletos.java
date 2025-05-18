package com.br.helpdesk.services.chamados.dto;

import com.br.helpdesk.models.chamados.enums.StatusChamados;

import java.time.LocalDateTime;

public interface ChamadosDadosCompletos {
    Long getChaNrId();
    String getChaTxTitulo();
    String getChaTxDescricao();
    StatusChamados getChaTxStatus();
    LocalDateTime getChaDtDataCriacao();
    LocalDateTime getChaDtDataAtualizacao();
    Long getChaNrIdCliente();
    Long getChaNrIdTecnico();
    Long getCatNrId();
    String getCatTxNome();
    String getNomeCliente();
    String getNomeTecnico();
}
