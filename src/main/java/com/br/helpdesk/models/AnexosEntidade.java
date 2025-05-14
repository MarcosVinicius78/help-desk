package com.br.helpdesk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ane_anexos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnexosEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ane_nr_id")
    private Long aneNrId;

    @Column(name = "ane_tx_anexo_url")
    private String aneTxAnexoUrl;

    @Column(name = "ane_dt_data_upload")
    private LocalDateTime aneDtDataUpload;

    @Column(name = "cha_nr_id")
    private Long chaNrId;

    @Column(name = "usu_nr_id")
    private Long usuNrId;
}
