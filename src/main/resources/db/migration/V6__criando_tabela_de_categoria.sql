CREATE TABLE cat_categoria (
    cat_nr_id bigserial  NOT NULL,
    cat_tx_nome varchar(20)  NOT NULL,
    emp_nr_id int8,
    CONSTRAINT cat_categoria_pk PRIMARY KEY (cat_nr_id),
    CONSTRAINT cat_categoria_emp_empresa_fk FOREIGN KEY (emp_nr_id) REFERENCES emp_empresa(emp_nr_id)
);