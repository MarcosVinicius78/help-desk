package com.br.helpdesk.services.categoria;

import com.br.helpdesk.services.categoria.dto.CategoriaDto;
import com.br.helpdesk.services.categoria.form.CategoriaFiltroForm;
import com.br.helpdesk.services.categoria.form.CategoriaForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoriaService {
    List<CategoriaDto> listarCategorias();
    Page<CategoriaDto> listarCategoriasDaEmpresa(Long empNrId, Pageable pageable, CategoriaFiltroForm filtro);
    CategoriaDto buscarCategoriaPorId(Long id);
    CategoriaDto criarCategoria(CategoriaForm form);
    CategoriaDto atualizarCategoria(Long id, CategoriaForm form);
    void deletarCategoria(Long id);
}
