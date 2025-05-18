package com.br.helpdesk.services.login.dto;

public record LoginRequest(
        String usuTxEmail,
        String usuTxSenha
) {
}
