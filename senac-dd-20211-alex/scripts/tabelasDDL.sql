create database db_vacinas;
-- set sql_safe_updates=0;

create table pessoa (
	id_pessoa int not null auto_increment  
    , nome varchar(150) not null
    , dataNascimento date not null
	, sexo enum('masculino','feminino') not null
    , cpf varchar(11) not null
    , categoria varchar(20) not null
    , constraint pk_pessoa primary key (id_pessoa)   
);

create table vacina (
	id_vacina int not null auto_increment 
    , id_pessoa_responsavel int not null
	, nome_vacina varchar(100) not null	
	, pais_origem varchar(50) not null
	, quantidade_doses int not null
	, estagio_pesquisa varchar(30) not null
	, inicio_pesquisa date not null
	, fase_vacina varchar(30) not null     
    , constraint pk_vacina primary key (id_vacina)
    , constraint fk_vacina_pessoa foreign key (id_pessoa_responsavel) references pessoa (id_pessoa)
);


create table aplicacao_vacina (
	id_aplicacao_vacina int not null auto_increment 
	-- , id_vacina int not null
    , id_pessoa int not null
	, reacao int not null
	, data_aplicacao date not null
	, constraint pk_aplicacao_vacina primary key (id_aplicacao_vacina)   
    -- , constraint fk_aplicacao_vacina_vacina foreign key (id_vacina) references vacina (id_vacina)
    , constraint fk_aplicacao_vacina_pessoa foreign key (id_pessoa) references pessoa (id_pessoa)
);

