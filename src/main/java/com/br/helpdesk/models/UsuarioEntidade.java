package com.br.helpdesk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usu_usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_nr_id")
    private Long usuNrId;

    @Column(name = "usu_tx_nome")
    private String usuTxNome;

    @Column(name = "usu_tx_email")
    private String usuTxEmail;

    @Column(name = "usu_tx_senha")
    private String usuTxSenha;

    @Column(name = "usu_bl_ativo")
    private Boolean usuBlAtivo;

    @Column(name = "rol_nr_id")
    private Long rolNrId;

    @Column(name = "emp_nr_id")
    private Long empNrId;
}
