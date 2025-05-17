package com.br.helpdesk.services.chamados.impl;

import com.br.helpdesk.models.chamados.ChamadosEntidade;
import com.br.helpdesk.models.chamados.enums.StatusChamados;
import com.br.helpdesk.repository.ChamadoRepository;
import com.br.helpdesk.services.chamados.ChamadosServices;
import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import com.br.helpdesk.services.chamados.form.ChamadoForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChamadoServiceImpl implements ChamadosServices {

    private final ChamadoRepository chamadoRepository;

    @Override
    public Page<ChamadoDto> listarChamados(Pageable pageable) {
        return chamadoRepository.findAll(pageable).map(ChamadoDto::new);
    }

    @Override
    public Page<ChamadoDto> listarChamadosPorCliente(Long usuNrIdCliente, Pageable pageable) {
        return chamadoRepository.findByUsuNrIdCliente(usuNrIdCliente, pageable)
                .map(ChamadoDto::new);
    }

    @Override
    public Page<ChamadoDto> listarChamadosPorTecnico(Long usuNrIdTecnico, Pageable pageable) {
        return chamadoRepository.findByUsuNrIdTecnico(usuNrIdTecnico, pageable)
                .map(ChamadoDto::new);
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
        chamado.setCatNrId(dto.catNrId());
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
                    c.setCatNrId(dto.catNrId());
                    return new ChamadoDto(chamadoRepository.save(c));
                }).orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
    }

    @Override
    public ChamadoDto atribuirChamado(Long chaNrId, Long usuNrIdTecnico) {
        return chamadoRepository.findById(chaNrId)
                .map(chamado -> {
                    chamado.setUsuNrIdTecnico(usuNrIdTecnico);
                    return new ChamadoDto(chamadoRepository.save(chamado));
                }).orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
    }

    @Override
    public void deletarChamado(Long id) {
        buscarChamadoPorId(id);
        chamadoRepository.deleteById(id);
    }
}
