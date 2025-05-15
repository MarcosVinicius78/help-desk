package com.br.helpdesk.controlles;

import com.br.helpdesk.services.comentarios.ComentariosService;
import com.br.helpdesk.services.comentarios.dto.ComentariosDto;
import com.br.helpdesk.services.comentarios.form.ComentariosForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentariosController {

    private final ComentariosService comentariosService;

    @GetMapping
    public ResponseEntity<List<ComentariosDto>> listarComentarios() {
        return ResponseEntity.ok(comentariosService.listarComentarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentariosDto> buscarComentarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(comentariosService.buscarComentarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<ComentariosDto> criarComentario(@RequestBody ComentariosForm form) {
        return ResponseEntity.ok(comentariosService.criarComentario(form));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentariosDto> atualizarComentario(@PathVariable Long id, @RequestBody ComentariosForm form) {
        return ResponseEntity.ok(comentariosService.atualizarComentario(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id) {
        comentariosService.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }
}
