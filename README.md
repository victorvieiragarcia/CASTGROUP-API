create table CATEGORIA(codigo int NOT NULL AUTO_INCREMENT,
descricao varchar(100) not null,
PRIMARY key(codigo));
create table CURSO(
codigo int NOT NULL AUTO_INCREMENT,
descricao_do_assunto  varchar(100) not null,
data_inicio date not null,
data_termino date not null,
quantidade_alunos_turma integer,
codigo_categoria integer not null,
foreign key (codigo_categoria) references CATEGORIA(codigo),
PRIMARY KEY(codigo)
);
insert into CATEGORIA (descricao) values("Comportamental"),("Programação"),("Qualidade"),("Processos");