package com.br.helpdesk.controlles;

import com.br.helpdesk.config.JwtUtil;
import com.br.helpdesk.models.RolesEntidade;
import com.br.helpdesk.models.UsuarioEntidade;
import com.br.helpdesk.repository.RolesRepository;
import com.br.helpdesk.repository.UsuarioRepository;
import com.br.helpdesk.services.login.dto.LoginRequest;
import com.br.helpdesk.services.login.dto.TokenResponse;
import com.br.helpdesk.services.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
        UsuarioEntidade usuarioEntidade = usuarioRepository.buscarUsuarioPorEmail(login.usuTxEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        RolesEntidade rolesEntidade = rolesRepository.findById(usuarioEntidade.getRolNrId())
                .orElseThrow(() -> new RuntimeException("Role nao encontrada"));

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.usuTxEmail(),
                            login.usuTxSenha()
                    )
            );
        } catch (BadCredentialsException ex) {
            // E‑mail ou senha inválidos
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "E-mail ou senha inválidos"));
        } catch (DisabledException ex) {
            // Usuário existe mas está desativado
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(Map.of("error", "Usuário desativado"));
        } catch (AuthenticationException ex) {
            // Qualquer outro problema de autenticação
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Falha na autenticação"));
        }

        // Se chegou aqui, autenticou OK
        String token = jwtUtil.gerarToken(login.usuTxEmail(), rolesEntidade.getRolTxDescricao());
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest login) {
        UsuarioEntidade novo = new UsuarioEntidade();
        novo.setUsuTxEmail(login.usuTxEmail());
        novo.setUsuTxSenha(encoder.encode(login.usuTxSenha()));
        novo.setUsuTxNome("Novo Usuário");
        novo.setUsuBlAtivo(true);
        novo.setRolNrId(2L);
        novo.setEmpNrId(1L);
        RolesEntidade rolesEntidade = rolesRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("Role nao encontrada"));
        // coloque um role e empresa válidos aqui
        usuarioRepository.save(novo);

        String token = jwtUtil.gerarToken(login.usuTxEmail(), rolesEntidade.getRolTxDescricao());
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
