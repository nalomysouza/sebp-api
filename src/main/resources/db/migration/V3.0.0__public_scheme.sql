-- DROP TABLE IF EXISTS public.orgao CASCADE;
CREATE TABLE public.orgao(
	id bigserial NOT NULL,
	nome character varying(255) NOT NULL,
	email character varying(255),
	telefone character varying(15),
	fax character varying(15),
	logradouro character varying (255) NOT NULL,
    numero character varying (6),
    cep character varying (10),
    complemento character varying (150),
    bairro character varying (150),
    municipio_id integer NOT NULL,
	enabled boolean NOT NULL DEFAULT true,
	create_in timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	update_in timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT orgao_pkey PRIMARY KEY (id)
);
ALTER TABLE public.orgao OWNER TO postgres;
CREATE SEQUENCE public.seq_orgao INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE public.seq_orgao OWNER TO postgres;
ALTER TABLE public.orgao ADD CONSTRAINT orgao_municipio_id_fkey FOREIGN KEY (municipio_id) REFERENCES help.municipio(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;


-- DROP TABLE IF EXISTS public.biblioteca CASCADE;
CREATE TABLE public.biblioteca(
	id bigserial NOT NULL,
	nome character varying(255) NOT NULL,
	email character varying(255),
	data_fundacao timestamp,
	ato_criacao character varying(150),
	sigla character varying(40),
	telefone character varying(15),
	fax character varying(15),
	orgao_id bigint NOT NULL,
	tipo_biblioteca_id Integer NOT NULL,
	polo boolean,
	descredenciada boolean,
	implantada_pelo_pla boolean,
	cadastro_snbp boolean,
	ano_cadastro_snbp Integer,
	logradouro character varying (255) NOT NULL,
    numero character varying (6),
    cep character varying (10),
    complemento character varying (150),
    bairro character varying (150),
    municipio_id integer NOT NULL,
	observacoes text,
	enabled boolean NOT NULL DEFAULT true,
	update_in timestamp with time zone,
	create_in timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT biblioteca_pkey PRIMARY KEY (id)
);
ALTER TABLE public.biblioteca OWNER TO postgres;
CREATE SEQUENCE public.seq_biblioteca INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE public.seq_biblioteca OWNER TO postgres;
ALTER TABLE public.biblioteca ADD CONSTRAINT orgao_municipio_id_fkey FOREIGN KEY (municipio_id) REFERENCES help.municipio(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE public.biblioteca ADD CONSTRAINT orgao_id_fkey FOREIGN KEY (orgao_id) REFERENCES public.orgao(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE public.biblioteca ADD CONSTRAINT tipo_biblioteca_id_fkey FOREIGN KEY (tipo_biblioteca_id) REFERENCES help.tipo_biblioteca(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;


-- DROP TABLE IF EXISTS public.responsavel CASCADE;
CREATE TABLE public.responsavel(
	id bigserial NOT NULL,
	nome character varying (255) NOT NULL,
	treinado_em_sbp boolean,
	escolaridade_id integer NOT NULL,
	formacao_id integer NOT NULL,
	biblioteca_id bigint NOT NULL,
	CONSTRAINT responsavel_pkey PRIMARY KEY (id)
);
ALTER TABLE public.responsavel OWNER TO postgres;
CREATE SEQUENCE public.seq_responsavel INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE public.seq_responsavel OWNER TO postgres;
ALTER TABLE public.responsavel ADD CONSTRAINT escolaridade_id_fkey FOREIGN KEY (escolaridade_id) REFERENCES help.escolaridade(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE public.responsavel ADD CONSTRAINT formacao_id_fkey FOREIGN KEY (formacao_id) REFERENCES help.formacao(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE public.responsavel ADD CONSTRAINT biblioteca_id_fkey FOREIGN KEY (biblioteca_id) REFERENCES public.biblioteca(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;


-- DROP TABLE IF EXISTS public.funcionario CASCADE;
CREATE TABLE public.funcionario(
	id bigserial NOT NULL,
	qtd_total integer,
	qtd_com_ensino_superior integer,
	formacao character varying (255),
	qtd_com_1grau integer,
	qtd_com_2grau integer,
	qtd_treinado_em_sbp integer,
	ultimo_treinamento_em_sbp timestamp,
	biblioteca_id bigint NOT NULL,
	CONSTRAINT funcionario_pkey PRIMARY KEY (id)
);
ALTER TABLE public.funcionario OWNER TO postgres;
CREATE SEQUENCE public.seq_funcionario INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE public.seq_funcionario OWNER TO postgres;
ALTER TABLE public.funcionario ADD CONSTRAINT biblioteca_id_fkey FOREIGN KEY (biblioteca_id) REFERENCES public.biblioteca(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;


-- DROP TABLE IF EXISTS public.apoio_recebido CASCADE;
CREATE TABLE public.apoio_recebido(
	id bigserial NOT NULL,
	proares boolean,
	proares_descricao character varying(255),
	ubecm boolean,
	ubecm_descricao character varying(255),
	minc boolean,
	minc_descricao character varying(255),
	biblioteca_id bigint NOT NULL,
	CONSTRAINT apoio_recebido_pkey PRIMARY KEY (id)
);
ALTER TABLE public.apoio_recebido OWNER TO postgres;
CREATE SEQUENCE public.seq_apoio_recebido INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE public.seq_apoio_recebido OWNER TO postgres;
ALTER TABLE public.apoio_recebido ADD CONSTRAINT biblioteca_id_fkey FOREIGN KEY (biblioteca_id) REFERENCES public.biblioteca(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;


-- DROP TABLE IF EXISTS public.acervo CASCADE;
CREATE TABLE public.acervo(
	id bigserial NOT NULL,
	intervalo_livro_id Integer NOT NULL,
	livros boolean,
	mapas boolean,
	filmes boolean,
	fotografias boolean,
	discos boolean,
	periodicos boolean,
	fitas_k7 boolean,
	fitas_video boolean,
	acervo_outros character varying(255),
	etr_livros_tombados boolean,
	etr_folhas_soltas boolean,
	etr_cadernos boolean,
	etr_fichas_soltas boolean,
	etr_nao_registrados boolean,
	etr_outros character varying(255),
	eti_autor boolean,
	eti_titulo boolean,
	eti_assunto boolean,
	eti_outros character varying(255),
	etc_simplificada boolean,
	etc_dewey boolean,
	etc_universal boolean,
	etc_outros character varying(255),
	etcat_simplificada boolean,
	etcat_abnt boolean,
	etcat_outros character varying(255),
	aquisicao_por_compra boolean,
	aquisicao_por_doacao boolean,
	aquisicao_por_permuta boolean,
	maioria_registrado boolean,
	maioria_identificado boolean,
	maioria_classificado boolean,
	maioria_catalogado boolean,
	acervo_atende_leitor boolean,
	acervo_outras_necessidades character varying(255),
	periodico_id Integer NOT NULL,
	periodico_maioria_registrado boolean,
	periodico_outras_necessidades character varying(255),
	etreg_fichas_kardex boolean,
	etreg_cadernos boolean,
	etreg_nao_registrado boolean,
	etreg_outros character varying(255),
	biblioteca_id bigint  NOT NULL,
	CONSTRAINT acervo_pkey PRIMARY KEY (id)
);
ALTER TABLE public.acervo OWNER TO postgres;
CREATE SEQUENCE public.seq_acervo INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
ALTER SEQUENCE public.seq_acervo OWNER TO postgres;
ALTER TABLE public.acervo ADD CONSTRAINT intervalo_livro_id_fkey FOREIGN KEY (intervalo_livro_id) REFERENCES help.intervalo_livro(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE public.acervo ADD CONSTRAINT periodico_id_fkey FOREIGN KEY (periodico_id) REFERENCES help.periodico(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE public.acervo ADD CONSTRAINT biblioteca_id_fkey FOREIGN KEY (biblioteca_id) REFERENCES public.biblioteca(id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;

