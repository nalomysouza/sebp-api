-- DROP SCHEMA IF EXISTS help CASCADE;
CREATE SCHEMA help;
-- ddl-end --
ALTER SCHEMA help OWNER TO postgres;
-- ddl-end --
SET search_path TO pg_catalog,
public,
security,
help;
-- ddl-end --
-- DROP TABLE IF EXISTS help.formacao CASCADE;
CREATE TABLE help.formacao
(
   id serial NOT NULL,
   descricao character varying (100) NOT NULL,
   enabled boolean NOT NULL DEFAULT true,
   update_in timestamp with time zone,
   create_in timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT formacao_pkey PRIMARY KEY (id)
);
ALTER TABLE help.formacao OWNER TO postgres;
CREATE SEQUENCE help.seq_formacao INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE help.seq_formacao OWNER TO postgres;


-- DROP TABLE IF EXISTS help.escolaridade CASCADE;
CREATE TABLE help.escolaridade
(
   id serial NOT NULL,
   descricao character varying (100) NOT NULL,
   CONSTRAINT escolaridade_pkey PRIMARY KEY (id)
);
ALTER TABLE help.escolaridade OWNER TO postgres;
CREATE SEQUENCE help.seq_escolaridade INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE help.seq_escolaridade OWNER TO postgres;


-- DROP TABLE IF EXISTS help.municipio CASCADE;
CREATE TABLE help.municipio
(
   id serial NOT NULL,
   nome character varying (200) NOT NULL,
   uf character varying (2) NOT NULL,
   CONSTRAINT municipio_pkey PRIMARY KEY (id)
);
ALTER TABLE help.municipio OWNER TO postgres;
CREATE SEQUENCE help.seq_municipio INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE help.seq_municipio OWNER TO postgres;


-- DROP TABLE IF EXISTS help.periodico CASCADE;
CREATE TABLE help.periodico
(
   id serial NOT NULL,
   descricao character varying (40) NOT NULL,
   CONSTRAINT periodico_pkey PRIMARY KEY (id)
);
ALTER TABLE help.periodico OWNER TO postgres;
CREATE SEQUENCE help.seq_periodico INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE help.seq_periodico OWNER TO postgres;


-- DROP TABLE IF EXISTS help.tipo_biblioteca CASCADE;
CREATE TABLE help.tipo_biblioteca
(
   id serial NOT NULL,
   descricao character varying (40) NOT NULL,
   CONSTRAINT tipo_biblioteca_pkey PRIMARY KEY (id)
);
ALTER TABLE help.tipo_biblioteca OWNER TO postgres;
CREATE SEQUENCE help.seq_tipo_biblioteca INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE help.seq_tipo_biblioteca OWNER TO postgres;


-- DROP TABLE IF EXISTS help.intervalo_livro CASCADE;
CREATE TABLE help.intervalo_livro
(
   id serial NOT NULL,
   descricao character varying (40) NOT NULL,
   CONSTRAINT intervalo_livro_pkey PRIMARY KEY (id)
);
ALTER TABLE help.intervalo_livro OWNER TO postgres;
CREATE SEQUENCE help.seq_intervalo_livro INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE help.seq_intervalo_livro OWNER TO postgres;


-- DROP TABLE IF EXISTS help.motivo_frequencia CASCADE;
CREATE TABLE help.motivo_frequencia
(
   id serial NOT NULL,
   descricao character varying (40) NOT NULL,
   CONSTRAINT motivo_frequencia_pkey PRIMARY KEY (id)
);
ALTER TABLE help.motivo_frequencia OWNER TO postgres;
CREATE SEQUENCE help.seq_motivo_frequencia INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE help.seq_motivo_frequencia OWNER TO postgres;