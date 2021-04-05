package com.br.alex.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.alex.controller.PessoaController;
import com.br.alex.controller.VacinaController;
import com.br.alex.model.entity.PessoaVO;
import com.br.alex.model.entity.VacinaVO;
import com.br.alex.repository.Constants;

public class VacinaView {

	static DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		PessoaVO pessoaVO = new PessoaVO();
		VacinaVO vacina = new VacinaVO();
		VacinaController vacinaController = new VacinaController();
		PessoaController pessoaController = new PessoaController();

		String[] itens = { "ESCOLHA UMA OPÇÃO", "Cadastrar vacina", "Listar todas vacinas", "Excluir vacina" };

		String opcaoEscolhida = (String) JOptionPane.showInputDialog(null, null, "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE, null, itens, itens[0]);

		if (opcaoEscolhida == itens[1]) {

			vacina.setNomeVacina(JOptionPane.showInputDialog(null, "Digite o nome da vacina", "MENU VACINA",
					JOptionPane.QUESTION_MESSAGE));
			vacina.setQuantidadeDoses(Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite a quantidade de doses da vacina", "MENU VACINA", JOptionPane.QUESTION_MESSAGE)));
			vacina.setPaisOrigem(JOptionPane.showInputDialog(null, "Digite o país de origem da vacina", "MENU VACINA",
					JOptionPane.QUESTION_MESSAGE));

			// Dados do pesquisador

			pessoaVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do pesquisador", "MENU VACINA",
					JOptionPane.QUESTION_MESSAGE));
			pessoaVO.setCpf(JOptionPane.showInputDialog(null, "Digite o cpf do pesquisador", "MENU VACINA",
					JOptionPane.QUESTION_MESSAGE));
			int idPesquisador = pessoaController.buscaPorNomeECpf(pessoaVO);

			if (idPesquisador != 0) {
				JOptionPane.showMessageDialog(null, "código ID do pesquisador: " + idPesquisador, null,
						JOptionPane.INFORMATION_MESSAGE);
				vacina.setidPessoaResponsavel(idPesquisador);

			} else {
				JOptionPane.showMessageDialog(null, "Pesquisador ainda não cadastrado! Favor cadastrar!", "MENU VACINA",
						JOptionPane.WARNING_MESSAGE);
				PessoaView pessoaView = new PessoaView();
				int retorno = pessoaView.cadastraPessoa(pessoaVO);
				JOptionPane.showMessageDialog(null, "código ID do pesquisador: " + retorno, "MENU VACINA",
						JOptionPane.INFORMATION_MESSAGE);
				vacina.setidPessoaResponsavel(retorno);

			}

			String[] fasesVacina = { "ESCOLHA A FASE DA VACINA", Constants.FASE_PESQUISADORES, Constants.FASE_VOLUNTARIOS,
					Constants.FASE_PUBLICO_GERAL };
			String faseEscolhida = (String) JOptionPane.showInputDialog(null, null, "MENU VACINA",
					JOptionPane.QUESTION_MESSAGE, null, fasesVacina, fasesVacina[0]);
			vacina.setFaseVacina(faseEscolhida);

			String[] estagioVacina = { "ESCOLHA O ESTÁGIO DA VACINA", Constants.ESTAGIO_INICIAL, Constants.ESTAGIO_TESTES,
					Constants.ESTAGIO_APLICACAOEMMASSA};
			String estagioEscolhido = (String) JOptionPane.showInputDialog(null, null, "MENU VACINA",
					JOptionPane.QUESTION_MESSAGE, null, estagioVacina, estagioVacina[0]);
			vacina.setEstagioPesquisa(estagioEscolhido);
			
			LocalDate data = LocalDate.parse(JOptionPane.showInputDialog(null,
					"Digite a data de início da pesquisa da vacina", "MENU VACINA", JOptionPane.QUESTION_MESSAGE),
					dataFormatter);
			vacina.setDataInicioPesquisa(data);

			String retorno = vacinaController.cadastraVacina(vacina);

			JOptionPane.showMessageDialog(null, retorno, "MENU VACINA", JOptionPane.INFORMATION_MESSAGE, null);

		} else if (opcaoEscolhida == itens[2]) {
			List<VacinaVO> mensagemRetorno = vacinaController.findAll();
			String resposta = "";

			for (VacinaVO vacinaVO : mensagemRetorno) {
				resposta += vacinaVO + "\n";
			}
			JOptionPane.showMessageDialog(null, resposta, "Vacinas", JOptionPane.INFORMATION_MESSAGE, null);

		} else if (opcaoEscolhida == itens[3]) {
			vacina.setNomeVacina(JOptionPane.showInputDialog("Digite o NOME da vacina a ser deletada"));
			vacina.setPaisOrigem(JOptionPane.showInputDialog("Digite o PAÍS DE ORIGEM da vacina a ser deletada"));
			boolean retorno = vacinaController.deletaVacinaPorPaisENome(vacina);

			if (retorno) {
				JOptionPane.showMessageDialog(null, "Exclusão efetuada!", null, JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Exclusão NÃO realizada!", null, JOptionPane.ERROR_MESSAGE, null);
			}

		} else {
			while ((opcaoEscolhida == itens[0])) {
				opcaoEscolhida = (String) JOptionPane.showInputDialog(null, null, "Menu Vacina",
						JOptionPane.QUESTION_MESSAGE, null, itens, itens[0]);
			}
		}
	}
}
