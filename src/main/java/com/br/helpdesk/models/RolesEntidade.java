package com.br.helpdesk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rol_roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolesEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_nr_id")
    private Long rolNrId;

    @Column(name = "rol_tx_descricao")
    private String rolTxDescricao;
}
