package com.br.helpdesk.controlles;

import com.br.helpdesk.config.JwtUtil;
import com.br.helpdesk.models.UsuarioEntidade;
import com.br.helpdesk.repository.UsuarioRepository;
import com.br.helpdesk.services.login.dto.LoginRequest;
import com.br.helpdesk.services.login.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.usuTxEmail(), login.usuTxSenha()));

        String token = jwtUtil.gerarToken(login.usuTxEmail());
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
        novo.setEmpNrId(6L);
        // coloque um role e empresa válidos aqui
        usuarioRepository.save(novo);

        String token = jwtUtil.gerarToken(login.usuTxEmail());
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
