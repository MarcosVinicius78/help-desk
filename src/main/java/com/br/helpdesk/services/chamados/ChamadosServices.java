package com.br.helpdesk.services.chamados;

import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import com.br.helpdesk.services.chamados.form.ChamadoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ChamadosServices {

    Page<ChamadoDto> listarChamados(Pageable pageable);

    Page<ChamadoDto> listarChamadosPorCliente(Long usuNrIdCliente, Pageable pageable);

    Page<ChamadoDto> listarChamadosPorTecnico(Long usuNrIdTecnico, Pageable pageable);

    ChamadoDto buscarChamadoPorId(Long id);

    ChamadoDto criarChamado(ChamadoForm dto);

    ChamadoDto atualizarChamado(Long id, ChamadoForm dto);

    ChamadoDto atribuirChamado(Long chaNrId, Long usuNrIdTecnico);

    void deletarChamado(Long id);
}
