package com.br.helpdesk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "com_comentarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComentariosEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_nr_id")
    private Long comNrId;

    @Column(name = "com_tx_descricao")
    private String comTxDescricao;

    @Column(name = "com_dt_data_criacao")
    private LocalDateTime comDtDataCriacao;

    @Column(name = "cha_nr_id")
    private Long chaNrId;

    @Column(name = "usu_nr_id_cliente")
    private Long usuNrIdCliente;
}
