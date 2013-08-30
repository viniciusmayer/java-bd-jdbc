CREATE ROLE eleonorvinicius LOGIN
	ENCRYPTED PASSWORD 'md590380049c78a6d00b9a28d720ca6ad26'
	SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;
  
CREATE DATABASE eleonorvinicius_test
	WITH OWNER = eleonorvinicius
	ENCODING = 'UTF8'
	TABLESPACE = pg_default
	LC_COLLATE = 'en_US.UTF-8'
	LC_CTYPE = 'en_US.UTF-8'
	CONNECTION LIMIT = -1;

CREATE TABLE usuario (
	id serial NOT NULL,
	email text NOT NULL,
	senha text NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id),
	CONSTRAINT usuario_email_uk UNIQUE (email)
) WITH (
  OIDS=FALSE
);

ALTER TABLE usuario OWNER TO eleonorvinicius;