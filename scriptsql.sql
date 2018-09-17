create database jogo_forca_GA

create table jogo
	id int primary key auto_increment,
	jogador varchar(255),
	dificuldade varchar(255),
	inicio datetime,
	fim datetime,
	palavra_palpite datetime,
	resultado varchar(255)
