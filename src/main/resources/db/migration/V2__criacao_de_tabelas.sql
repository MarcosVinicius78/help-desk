-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-05-14 23:27:29.93

-- tables
-- Table: ane_anexos
CREATE TABLE ane_anexos (
    ane_nr_id bigserial  NOT NULL,
    ane_tx_anexo_url text  NOT NULL,
    ane_dt_data_upload timestamp  NOT NULL,
    cha_nr_id bigint  NOT NULL,
    usu_nr_id bigint  NOT NULL,
    CONSTRAINT ane_anexos_pk PRIMARY KEY (ane_nr_id)
);

-- Table: cha_chamados
CREATE TABLE cha_chamados (
    cha_nr_id bigserial  NOT NULL,
    cha_tx_titulo varchar(100)  NOT NULL,
    cha_tx_descricao text  NOT NULL,
    cha_tx_status varchar(20)  NOT NULL,
    cha_dt_data_criacao timestamp  NOT NULL,
    cha_dt_data_atualizacao timestamp  NOT NULL,
    usu_nr_id_tecnico bigint  NOT NULL,
    usu_nr_id_cliente bigint  NOT NULL,
    CONSTRAINT cha_chamados_pk PRIMARY KEY (cha_nr_id)
);

-- Table: com_comentarios
CREATE TABLE com_comentarios (
    com_nr_id bigserial  NOT NULL,
    com_tx_descricao text  NOT NULL,
    com_dt_data_criacao timestamp  NOT NULL,
    cha_nr_id bigint  NOT NULL,
    usu_nr_id_cliente bigint  NOT NULL,
    usu_nr_id_tecnico bigint  NOT NULL,
    CONSTRAINT com_comentarios_pk PRIMARY KEY (com_nr_id)
);

-- Table: emp_empresa
CREATE TABLE emp_empresa (
    emp_nr_id bigserial  NOT NULL,
    emp_tx_nome int  NOT NULL,
    emp_nr_cnpj int  NOT NULL,
    CONSTRAINT emp_empresa_pk PRIMARY KEY (emp_nr_id)
);

-- Table: rol_roles
CREATE TABLE rol_roles (
    rol_nr_id bigserial  NOT NULL,
    rol_tx_descricao varchar(20)  NOT NULL,
    CONSTRAINT rol_roles_pk PRIMARY KEY (rol_nr_id)
);

-- Table: usu_usuarios
CREATE TABLE usu_usuarios (
    usu_nr_id bigserial  NOT NULL,
    usu_tx_nome varchar(100)  NOT NULL,
    usu_tx_email varchar(200)  NOT NULL,
    usu_tx_senha text  NOT NULL,
    usu_bl_ativo boolean  NOT NULL,
    rol_nr_id bigint  NOT NULL,
    emp_nr_id int8  NOT NULL,
    CONSTRAINT rol_nr_id_fk1 UNIQUE (rol_nr_id) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT usu_nr_id_pk PRIMARY KEY (usu_nr_id)
);

-- foreign keys
-- Reference: ane_anexos_usu_usuarios (table: ane_anexos)
ALTER TABLE ane_anexos ADD CONSTRAINT ane_anexos_usu_usuarios
    FOREIGN KEY (usu_nr_id)
    REFERENCES usu_usuarios (usu_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: cha_chamados_ane_anexos (table: ane_anexos)
ALTER TABLE ane_anexos ADD CONSTRAINT cha_chamados_ane_anexos
    FOREIGN KEY (cha_nr_id)
    REFERENCES cha_chamados (cha_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: cha_chamados_com_comentarios (table: com_comentarios)
ALTER TABLE com_comentarios ADD CONSTRAINT cha_chamados_com_comentarios
    FOREIGN KEY (cha_nr_id)
    REFERENCES cha_chamados (cha_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: cha_chamados_usu_usuarios_cliente (table: cha_chamados)
ALTER TABLE cha_chamados ADD CONSTRAINT cha_chamados_usu_usuarios_cliente
    FOREIGN KEY (usu_nr_id_cliente)
    REFERENCES usu_usuarios (usu_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: cha_chamados_usu_usuarios_tecnico (table: cha_chamados)
ALTER TABLE cha_chamados ADD CONSTRAINT cha_chamados_usu_usuarios_tecnico
    FOREIGN KEY (usu_nr_id_tecnico)
    REFERENCES usu_usuarios (usu_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: com_comentarios_usu_usuarios_cliente (table: com_comentarios)
ALTER TABLE com_comentarios ADD CONSTRAINT com_comentarios_usu_usuarios_cliente
    FOREIGN KEY (usu_nr_id_cliente)
    REFERENCES usu_usuarios (usu_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: com_comentarios_usu_usuarios_tecnico (table: com_comentarios)
ALTER TABLE com_comentarios ADD CONSTRAINT com_comentarios_usu_usuarios_tecnico
    FOREIGN KEY (usu_nr_id_tecnico)
    REFERENCES usu_usuarios (usu_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: usu_usuario_rol_roles (table: usu_usuarios)
ALTER TABLE usu_usuarios ADD CONSTRAINT usu_usuario_rol_roles
    FOREIGN KEY (rol_nr_id)
    REFERENCES rol_roles (rol_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: usu_usuarios_emp_empresa (table: usu_usuarios)
ALTER TABLE usu_usuarios ADD CONSTRAINT usu_usuarios_emp_empresa
    FOREIGN KEY (emp_nr_id)
    REFERENCES emp_empresa (emp_nr_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- End of file.