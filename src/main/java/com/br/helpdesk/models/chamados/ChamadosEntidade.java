package com.br.helpdesk.models.chamados;

import com.br.helpdesk.models.chamados.enums.StatusChamados;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cha_chamados")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChamadosEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cha_nr_id")
    private Long chaNrId;

    @Column(name = "cha_tx_titulo")
    private String chaTxTitulo;

    @Column(name = "cha_tx_descricao")
    private String chaTxDescricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "cha_Tx_status")
    private StatusChamados chaTxStatus;

    @Column(name = "cha_dt_data_criacao")
    private LocalDateTime chaDtDataCriacao;

    @Column(name = "cha_dt_data_atualizacao")
    private LocalDateTime chaDtDataAtualizacao;

    @Column(name = "usu_nr_id_cliente")
    private Long usuNrIdCliente;

    @Column(name = "usu_nr_id_tecnico")
    private Long usuNrIdTecnico;
}
