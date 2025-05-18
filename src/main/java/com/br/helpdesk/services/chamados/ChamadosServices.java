package com.br.helpdesk.services.chamados;

import com.br.helpdesk.services.chamados.dto.ChamadoDadosCompletosDto;
import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import com.br.helpdesk.services.chamados.form.ChamadoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ChamadosServices {

    Page<ChamadoDadosCompletosDto> listarChamados(ChamadoForm filtro, Pageable pageable);

    Page<ChamadoDadosCompletosDto> listarChamadosPorCliente(Long usuNrIdCliente, ChamadoForm filtro, Pageable pageable);

    Page<ChamadoDadosCompletosDto> listarChamadosPorTecnico(Long usuNrIdTecnico, ChamadoForm filtro, Pageable pageable);

    ChamadoDto buscarChamadoPorId(Long id);

    ChamadoDto criarChamado(ChamadoForm dto);

    ChamadoDto atualizarChamado(Long id, ChamadoForm dto);

    ChamadoDto atribuirChamado(Long chaNrId, Long usuNrIdTecnico);

    void deletarChamado(Long id);
}
