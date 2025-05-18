package com.br.helpdesk.controlles;

import com.br.helpdesk.services.Roles.UsuarioRoleService;
import com.br.helpdesk.services.Roles.dto.RolesDto;
import com.br.helpdesk.services.usuario.UsuarioService;
import com.br.helpdesk.services.usuario.dto.UsuarioDto;
import com.br.helpdesk.services.usuario.form.UsuarioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioRoleService usuarioRoleService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> buscarUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody UsuarioForm form) {
        UsuarioDto usuarioCriado = usuarioService.criarUsuario(form);
        return ResponseEntity.ok(usuarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioForm form) {
        UsuarioDto usuarioAtualizado = usuarioService.atualizarUsuario(id, form);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{usuNrId}/roles/{rolNrId}")
    public ResponseEntity<?> atribuirRole(@PathVariable Long usuNrId, @PathVariable Long rolNrId) {
        usuarioRoleService.atribuirRole(usuNrId, rolNrId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{usuNrId}/roles/{rolNrId}")
    public ResponseEntity<?> removerRole(@PathVariable Long usuNrId, @PathVariable Long rolNrId) {
        usuarioRoleService.removerRole(usuNrId, rolNrId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar-roles")
    public ResponseEntity<List<RolesDto>> listarRoles() {
        return ResponseEntity.ok().body(usuarioRoleService.listarRoles());
    }
}
