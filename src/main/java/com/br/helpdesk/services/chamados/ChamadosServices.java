package com.br.helpdesk.services.chamados;

import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import com.br.helpdesk.services.chamados.form.ChamadoForm;

import java.util.List;
import java.util.Optional;

public interface ChamadosServices {

    List<ChamadoDto> listarChamados();

    ChamadoDto buscarChamadoPorId(Long id);

    ChamadoDto criarChamado(ChamadoForm dto);

    ChamadoDto atualizarChamado(Long id, ChamadoForm dto);

    ChamadoDto atribuirChamado(Long chaNrId, Long usuNrIdTecnico);

    void deletarChamado(Long id);
}
