create database pifarmacia;
use pifarmacia;

create table produto (
	id smallint not null auto_increment,
    nome char(30),
    unidade char(30),
    preco decimal(10,2),
    validade datetime,
    categoria int,
    estoque int,
    primary key (id)
);

select * from produto;


create table categoria (
	id smallint not null auto_increment,
    nome char(30),
    primary key (id)
);

select * from categoria;

CREATE TABLE pedido (
  id smallint not null auto_increment,
  cliente int,
  total decimal(10,2),
  inclusao date NOT NULL,
  primary key (id)
);

select * from pedido;

CREATE TABLE pedido_item (
  id smallint not null auto_increment,
  id_venda int,
  id_produto int,
  preco decimal(10,2),
  quantidade int,
  total decimal(10,2),
  primary key (id)
);

select * from pedido_item;

CREATE TABLE fornecedor (
  id smallint not null auto_increment,
  nome varchar(45),
  CPF varchar(14),
  telefone char(20),
  item varchar(45),
  valorTotal float,
  qtd int,
  dataEntrega date,
  PRIMARY KEY (id)
);

select * from fornecedor;

CREATE TABLE cliente (
  id smallint not null auto_increment,
  nome char(30),
  cpf char(11),
  primary key (id)
);

select * from cliente;

