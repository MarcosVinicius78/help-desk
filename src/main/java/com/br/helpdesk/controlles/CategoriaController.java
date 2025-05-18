package com.br.helpdesk.controlles;

import com.br.helpdesk.services.categoria.CategoriaService;
import com.br.helpdesk.services.categoria.dto.CategoriaDto;
import com.br.helpdesk.services.categoria.form.CategoriaFiltroForm;
import com.br.helpdesk.services.categoria.form.CategoriaForm;
import com.br.helpdesk.services.chamados.dto.ChamadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listarCategoria() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/empresa/{empNrId}")
    public ResponseEntity<Page<CategoriaDto>> listarCategoriasDaEmpresa(
            @PathVariable Long empNrId,
            CategoriaFiltroForm filtro,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(categoriaService.listarCategoriasDaEmpresa(empNrId, pageable, filtro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscarCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarCategoriaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> criarCategoria(@RequestBody CategoriaForm form) {
        return ResponseEntity.ok(categoriaService.criarCategoria(form));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaForm form) {
        return ResponseEntity.ok(categoriaService.atualizarCategoria(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}