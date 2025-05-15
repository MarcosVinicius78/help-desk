package com.br.helpdesk.services.chamados.impl;

import com.br.helpdesk.models.chamados.ChamadosEntidade;
import com.br.helpdesk.models.chamados.enums.StatusChamados;
import com.br.helpdesk.repository.ChamadoRepository;
import com.br.helpdesk.services.chamados.ChamadosServices;
import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import com.br.helpdesk.services.chamados.form.ChamadoForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChamadoServiceImpl implements ChamadosServices {

    private final ChamadoRepository chamadoRepository;

    @Override
    public List<ChamadoDto> listarChamados() {
        return chamadoRepository.findAll().stream()
                .map(ChamadoDto::new)
                .toList();
    }

    @Override
    public ChamadoDto buscarChamadoPorId(Long id) {
        return chamadoRepository.findById(id).map(ChamadoDto::new).orElseThrow(() -> new RuntimeException("Chamado nao encontrado"));
    }

    @Override
    public ChamadoDto criarChamado(ChamadoForm dto) {
        ChamadosEntidade chamado = new ChamadosEntidade();
        chamado.setChaTxTitulo(dto.chaTxTitulo());
        chamado.setChaTxDescricao(dto.chaTxDescricao());
        chamado.setChaTxStatus(StatusChamados.ABERTO);
        chamado.setUsuNrIdCliente(dto.chaNrIdCliente());
        chamado.setUsuNrIdTecnico(dto.chaNrIdTecnico());
        chamado.setChaDtDataCriacao(LocalDateTime.now());
        chamado.setChaDtDataAtualizacao(LocalDateTime.now());
        return new ChamadoDto(chamadoRepository.save(chamado));
    }

    @Override
    public ChamadoDto atualizarChamado(Long id, ChamadoForm dto) {
        return chamadoRepository.findById(id)
                .map(c -> {
                    c.setChaTxTitulo(dto.chaTxTitulo());
                    c.setChaTxDescricao(dto.chaTxDescricao());
                    c.setChaTxStatus(dto.chaTxStatus());
                    c.setUsuNrIdCliente(dto.chaNrIdCliente());
                    c.setUsuNrIdTecnico(dto.chaNrIdTecnico());
                    c.setChaDtDataAtualizacao(LocalDateTime.now());
                    return new ChamadoDto(chamadoRepository.save(c));
                }).orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
    }

    @Override
    public void deletarChamado(Long id) {
        buscarChamadoPorId(id);
        chamadoRepository.deleteById(id);
    }
}
