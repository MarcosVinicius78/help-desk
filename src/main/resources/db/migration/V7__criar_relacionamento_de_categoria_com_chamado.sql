alter table cha_chamados add column cat_nr_id int8;

ALTER TABLE cha_chamados
ADD CONSTRAINT cha_chamados_cat_categoria_fk
FOREIGN KEY (cat_nr_id) REFERENCES cat_categoria(cat_nr_id);