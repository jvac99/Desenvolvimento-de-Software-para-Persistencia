CREATE DATABASE universidade
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

Create table if not exists aluno (
	id_aluno serial not null,
	nome_aluno varchar(150) not null,
	cpf_aluno varchar (15) unique not null,
	telefone_aluno varchar (15),
	matricula_aluno varchar (150) unique not null,
	Constraint aluno_pk Primary key (id_aluno, cpf_aluno)
); 