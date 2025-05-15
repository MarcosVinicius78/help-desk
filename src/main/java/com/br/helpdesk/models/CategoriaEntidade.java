package com.br.helpdesk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cat_categoria")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoriaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_nr_id")
    private Long catNrId;

    @Column(name = "cat_tx_nome")
    private String catTxNome;

    @Column(name = "emp_nr_id")
    private Long empNrId;
}
