package com.br.helpdesk.controlles;

import com.br.helpdesk.services.categoria.CategoriaService;
import com.br.helpdesk.services.categoria.dto.CategoriaDto;
import com.br.helpdesk.services.categoria.form.CategoriaForm;
import lombok.RequiredArgsConstructor;
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