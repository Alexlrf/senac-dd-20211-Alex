package com.br.alex.model.bo;

import java.sql.SQLException;

import com.br.alex.model.dao.PessoaDAO;
import com.br.alex.model.entity.PessoaVO;

public class PessoaBO {
	
	PessoaDAO pessoaDAO =  new PessoaDAO();
	PessoaVO pessoaVO = new PessoaVO();

	public int buscaPorNomeECpf(PessoaVO pessoaVO) {
		int idPesquisador = pessoaDAO.buscaPorNomeECpf(pessoaVO);
		
		if (idPesquisador != 0) {
			return idPesquisador;
		} else {
			return 0;
		}		
		
	}

	public int cadastraPesquisador(PessoaVO pessoa) {
		int retorno = 0;
		try {
			pessoaVO = pessoaDAO.insert(pessoa);
			if (pessoaVO.getIdPessoa() != 0) {
				retorno =  pessoaVO.getIdPessoa();				
			} else {
				retorno = 0;
			}
		} catch (SQLException e) {	
			retorno = 0;
			e.printStackTrace();
		}			
		return  retorno;
	}

}
