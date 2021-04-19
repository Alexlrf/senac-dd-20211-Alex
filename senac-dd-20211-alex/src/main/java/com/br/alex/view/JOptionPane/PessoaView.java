package com.br.alex.view.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.br.alex.controller.PessoaController;
import com.br.alex.model.entity.PessoaVO;
import com.br.alex.repository.Constants;

public class PessoaView {

	PessoaVO pessoa = new PessoaVO();
	PessoaController pessoaController = new PessoaController();
	static DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public int cadastraPessoa(PessoaVO pessoaVO) {
		pessoa.setNome(pessoaVO.getNome());		
		pessoa.setCpf(pessoaVO.getCpf()); 
		
		if (pessoa.getNome() == null) {
			pessoa.setNome(
					JOptionPane.showInputDialog(null, "Digite o nome", JOptionPane.QUESTION_MESSAGE));			
		}
		
		if(pessoa.getCpf() == null) {
			pessoa.setCpf(
					JOptionPane.showInputDialog(null, "Digite o CPF", JOptionPane.QUESTION_MESSAGE));
		}
		
		pessoa.setSexo(
				JOptionPane.showInputDialog(null, "Digite o sexo", JOptionPane.QUESTION_MESSAGE));

		String[] categorias = { "ESCOLHA UMA OPÇÃO", Constants.FASE_PESQUISADORES, Constants.FASE_VOLUNTARIOS,
				Constants.FASE_PUBLICO_GERAL };
		String opcaoEscolhida = (String) JOptionPane.showInputDialog(null, null, "CATEGORIA",
				JOptionPane.QUESTION_MESSAGE, null, categorias, categorias[0]);
		pessoa.setCategoria(opcaoEscolhida);
		
		LocalDate dataNascimento = (LocalDate.parse(JOptionPane.showInputDialog(null,
				"Digite a data de nascimento", JOptionPane.QUESTION_MESSAGE), dataFormatter));
		pessoa.setDataNascimento(dataNascimento);

		int retorno = pessoaController.cadastraPesquisador(pessoa);

		return retorno;
	}

}
