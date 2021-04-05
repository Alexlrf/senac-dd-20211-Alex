package com.br.alex.controller;

import com.br.alex.model.bo.PessoaBO;
import com.br.alex.model.entity.PessoaVO;

public class PessoaController {
		
	PessoaBO pessoaBO = new PessoaBO();

	public int buscaPorNomeECpf(PessoaVO pessoaVO) {
		return pessoaBO.buscaPorNomeECpf(pessoaVO);
	}

	public int cadastraPesquisador(PessoaVO pessoa) {
		return pessoaBO.cadastraPesquisador(pessoa);
	}

}
