package com.br.helpdesk.services.comentarios.impl;

import com.br.helpdesk.models.ComentariosEntidade;
import com.br.helpdesk.repository.ComentariosRepository;
import com.br.helpdesk.services.comentarios.ComentariosService;
import com.br.helpdesk.services.comentarios.dto.ComentariosDto;
import com.br.helpdesk.services.comentarios.form.ComentariosForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentariosServiceImpl implements ComentariosService {

    private final ComentariosRepository comentariosRepository;

    @Override
    public List<ComentariosDto> listarComentarios() {
        return comentariosRepository.findAll().stream()
                .map(ComentariosDto::new)
                .toList();
    }

    @Override
    public ComentariosDto buscarComentarioPorId(Long id) {
        return comentariosRepository.findById(id)
                .map(ComentariosDto::new)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    @Override
    public ComentariosDto criarComentario(ComentariosForm form) {
        ComentariosEntidade comentario = new ComentariosEntidade();
        comentario.setComTxDescricao(form.comTxDescricao());
        comentario.setComDtDataCriacao(form.comDtDataCriacao());
        comentario.setChaNrId(form.chaNrId());
        comentario.setUsuNrIdCliente(form.usuNrIdCliente());
        return new ComentariosDto(comentariosRepository.save(comentario));
    }

    @Override
    public ComentariosDto atualizarComentario(Long id, ComentariosForm form) {
        return comentariosRepository.findById(id)
                .map(comentario -> {
                    comentario.setComTxDescricao(form.comTxDescricao());
                    comentario.setComDtDataCriacao(form.comDtDataCriacao());
                    comentario.setChaNrId(form.chaNrId());
                    comentario.setUsuNrIdCliente(form.usuNrIdCliente());
                    return new ComentariosDto(comentariosRepository.save(comentario));
                })
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    @Override
    public void deletarComentario(Long id) {
        buscarComentarioPorId(id); // Lança erro se não existir
        comentariosRepository.deleteById(id);
    }
}
