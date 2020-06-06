create database pifarmacia;
use pifarmacia;

create table produto (
	id smallint not null auto_increment,
    nome char(30),
    unidade char(30),
    preco decimal(10,2),
    validade datetime,
    categoria char(30),
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

CREATE TABLE `vendas` (
  `id_venda` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(80) NOT NULL,
  `id_prod` varchar(40) NOT NULL,
  `data_venda` date NOT NULL,
  `qnt_vendida` int(11) NOT NULL,
  `preco_total` float NOT NULL,
  PRIMARY KEY (`id_venda`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;


select * from vendas;