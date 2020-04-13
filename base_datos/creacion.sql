create database db_notas;
use  db_notas;

create table NOTAS(
	codigo int auto_increment primary key,
    nombre varchar(50) not null,
    titulo varchar(50) not null,
    contenido text not null    
);