package com.br.helpdesk.services.anexos.dto;

import com.br.helpdesk.models.AnexosEntidade;

import java.time.LocalDateTime;

public record AnexoDto(
        Long aneNrId,
        String aneTxAnexoUrl,
        LocalDateTime aneDtDataUpload,
        Long chaNrId,
        Long usuNrId
) {
    public AnexoDto(AnexosEntidade entity) {
        this(
                entity.getAneNrId(),
                entity.getAneTxAnexoUrl(),
                entity.getAneDtDataUpload(),
                entity.getChaNrId(),
                entity.getUsuNrId()
        );
    }
}
