package com.br.helpdesk.services.categoria;

import com.br.helpdesk.services.categoria.dto.CategoriaDto;
import com.br.helpdesk.services.categoria.form.CategoriaForm;

import java.util.List;

public interface CategoriaService {
    List<CategoriaDto> listarCategorias();
    CategoriaDto buscarCategoriaPorId(Long id);
    CategoriaDto criarCategoria(CategoriaForm form);
    CategoriaDto atualizarCategoria(Long id, CategoriaForm form);
    void deletarCategoria(Long id);
}
