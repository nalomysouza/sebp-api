-- DROP SCHEMA IF EXISTS security CASCADE;
CREATE SCHEMA security;
-- ddl-end --
ALTER SCHEMA security OWNER TO postgres;
-- ddl-end --
SET search_path TO pg_catalog,
security;
-- ddl-end --
-- object: security.role | type: TABLE --
-- DROP TABLE IF EXISTS security.role CASCADE;
CREATE TABLE security.role
(
   id serial NOT NULL,
   name character varying (20) NOT NULL,
   CONSTRAINT role_pkey PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE security.role OWNER TO postgres;
-- ddl-end --
-- object: security.seq_role | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS security.seq_role CASCADE;
CREATE SEQUENCE security.seq_role INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE security.seq_role OWNER TO postgres;
-- ddl-end --
-- object: security.user | type: TABLE --
-- DROP TABLE IF EXISTS security.user CASCADE;
CREATE TABLE security.user
(
   id bigserial NOT NULL,
   username character varying (150),
   email character varying (200) NOT NULL,
   password character varying (200) NOT NULL,
   role_id bigint NOT NULL,
   enabled boolean NOT NULL,
   create_in timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
   update_in timestamp with time zone,
   CONSTRAINT user_pkey PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE security.user OWNER TO postgres;
-- ddl-end --
-- object: empresa_representante_id_fkey | type: CONSTRAINT --
-- ALTER TABLE public.empresa DROP CONSTRAINT IF EXISTS empresa_representante_id_fkey CASCADE;
ALTER TABLE security.user ADD CONSTRAINT role_id_fkey FOREIGN KEY (role_id) REFERENCES security.role (id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --
-- object: security.seq_user | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS security.seq_user CASCADE;
CREATE SEQUENCE security.seq_user INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1 NO CYCLE OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE security.seq_user OWNER TO postgres;
-- ddl-end --


CREATE TABLE security.user_role
(
user_id bigint NOT NULL,
role_id integer NOT NULL,
 CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id)
);

ALTER TABLE security.user_role OWNER TO postgres;

ALTER TABLE security.user_role ADD CONSTRAINT user_role_user_id_fkey FOREIGN KEY (user_id) REFERENCES security.user (id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE security.user_role ADD CONSTRAINT user_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES security.role (id) MATCH SIMPLE ON DELETE NO ACTION ON UPDATE NO ACTION;
