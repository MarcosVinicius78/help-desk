package com.br.helpdesk.services.categoria.impl;

import com.br.helpdesk.models.CategoriaEntidade;
import com.br.helpdesk.repository.CategoriaRepository;
import com.br.helpdesk.services.categoria.CategoriaService;
import com.br.helpdesk.services.categoria.dto.CategoriaDto;
import com.br.helpdesk.services.categoria.form.CategoriaFiltroForm;
import com.br.helpdesk.services.categoria.form.CategoriaForm;
import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDto> listarCategorias() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaDto::new)
                .toList();
    }

    @Override
    public Page<CategoriaDto> listarCategoriasDaEmpresa(Long empNrId, Pageable pageable, CategoriaFiltroForm filtro) {
        return categoriaRepository.findByEmpNrId(empNrId, pageable, filtro)
                .map(CategoriaDto::new);
    }

    @Override
    public CategoriaDto buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(CategoriaDto::new)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    @Override
    public CategoriaDto criarCategoria(CategoriaForm form) {
        CategoriaEntidade categoria = new CategoriaEntidade();
        categoria.setCatTxNome(form.catTxNome());
        categoria.setEmpNrId(form.empNrId());
        return new CategoriaDto(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDto atualizarCategoria(Long id, CategoriaForm form) {
        return categoriaRepository.findById(id)
                .map(c -> {
                    c.setCatTxNome(form.catTxNome());
                    c.setEmpNrId(form.empNrId());
                    return new CategoriaDto(categoriaRepository.save(c));
                }).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    @Override
    public void deletarCategoria(Long id) {
        buscarCategoriaPorId(id);
        categoriaRepository.deleteById(id);
    }
}