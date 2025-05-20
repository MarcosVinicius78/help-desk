package com.br.helpdesk.config;

import com.br.helpdesk.models.RolesEntidade;
import com.br.helpdesk.models.UsuarioEntidade;
import com.br.helpdesk.repository.RolesRepository;
import com.br.helpdesk.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtUtil {

    private final UsuarioRepository usuarioRepository;
    private final RolesRepository rolesRepository;

    private final String SECRET = "JZPzJg8UtQdYxkA3NdN7WTZMXruyQa1KkMEHvhq8lGg";

    public String gerarToken(String username) {
        UsuarioEntidade usuario = usuarioRepository.buscarUsuarioPorEmail(username
        ) .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        RolesEntidade role = rolesRepository.findByRolNrId(usuario.getRolNrId());
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("empNrId", usuario.getEmpNrId())
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
