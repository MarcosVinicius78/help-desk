package com.br.helpdesk.services.comentarios;

import com.br.helpdesk.services.comentarios.dto.ComentariosDto;
import com.br.helpdesk.services.comentarios.form.ComentariosForm;

import java.util.List;

public interface ComentariosService {
    List<ComentariosDto> listarComentarios();
    ComentariosDto buscarComentarioPorId(Long id);
    ComentariosDto criarComentario(ComentariosForm form);
    ComentariosDto atualizarComentario(Long id, ComentariosForm form);
    void deletarComentario(Long id);
}
