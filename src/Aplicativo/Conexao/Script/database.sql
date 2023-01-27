
DROP DATABASE IF EXISTS db_teste;
CREATE DATABASE IF NOT EXISTS db_teste;
USE db_teste;

CREATE TABLE IF NOT EXISTS produto(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
descricao VARCHAR(255),
custo DOUBLE,
margemVenda DOUBLE,
precovenda DOUBLE,
quantidade DOUBLE,
PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS usuario(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
senha VARCHAR(255),
nomeCompleto VARCHAR(255),
rg VARCHAR(255),
cfp VARCHAR(255),
PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS cargo(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
premissao VARCHAR(255) default null,
PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS exercicio(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
descricao VARCHAR(255) default null,
PRIMARY KEY(id)
);



CREATE TABLE IF NOT EXISTS metodo(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
descricao VARCHAR(255) default null,
PRIMARY KEY(id)
);



CREATE TABLE IF NOT EXISTS cliente(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
senha VARCHAR(255),
nomeCompleto VARCHAR(255),
rg VARCHAR(255),
cfp VARCHAR(255),
PRIMARY KEY(id)
);



CREATE TABLE IF NOT EXISTS fornecedor(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
senha VARCHAR(255),
nomeCompleto VARCHAR(255),
rg VARCHAR(255),
cfp VARCHAR(255),
PRIMARY KEY(id)
);






CREATE TABLE IF NOT EXISTS venda(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
descricao VARCHAR(255),
custo DOUBLE,
margemVenda DOUBLE,
presovenda DOUBLE,
quantidade DOUBLE,
PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS VendaItem(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
descricao VARCHAR(255),
custo DOUBLE,
margemVenda DOUBLE,
presovenda DOUBLE,
quantidade DOUBLE,
PRIMARY KEY(id)
);




CREATE TABLE IF NOT EXISTS pedido(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
descricao VARCHAR(255),
custo DOUBLE,
margemVenda DOUBLE,
presovenda DOUBLE,
quantidade DOUBLE,
PRIMARY KEY(id)
);




CREATE TABLE IF NOT EXISTS pedidoItem(
id INT AUTO_INCREMENT,
nome VARCHAR(255),
descricao VARCHAR(255),
custo DOUBLE,
margemVenda DOUBLE,
presovenda DOUBLE,
quantidade DOUBLE,
PRIMARY KEY(id)
);






-- fonoaudiologo
# ficha
CREATE TABLE IF NOT EXISTS usuario(
id INT AUTO_INCREMENT,
id_pessoa INT,
nome VARCHAR(255),
senha VARCHAR(255),
nomeCompleto VARCHAR(255),
rg VARCHAR(255),
cfp VARCHAR(255),
PRIMARY KEY(id)
);




# audio
#CREATE TABLE audio();
# execicio
#CREATE TABLE execicio();
# metodos
#CREATE TABLE metodo();

-- outro
# ficha
# documento
#