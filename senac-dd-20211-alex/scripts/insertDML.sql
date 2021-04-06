
insert into pessoa(nome, dataNascimento, sexo, cpf, categoria)
		values
			('Alexei Pogowski', '1989-03-03', 'masculino', '11111', 'PESQUISADOR'),
			('Chin Xo In', '2011-01-03', 'feminino', '22222', 'PESQUISADOR');
        

insert into vacina (id_pessoa_responsavel, nome_vacina, pais_origem, quantidade_doses, estagio_pesquisa, inicio_pesquisa, fase_vacina, situacao ) 
		values
			(1, 'Vacina1', 'Rússia', 2, 'INICIAL', '2020-08-08', 'VOLUNTARIO', 'ATIVO'),
			(2, 'Vacina2', 'China', 1, 'TESTES', '2020-09-28', 'PUBLICO GERAL', 'ATIVO'),
            (2, 'Vacine3', 'China', 2, 'APLICAÇÃO EM MASSA', '2020-05-03', 'PUBLICO GERAL', 'ATIVO');