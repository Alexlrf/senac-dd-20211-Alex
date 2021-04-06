package com.br.alex.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.br.alex.controller.PessoaController;
import com.br.alex.controller.VacinaController;
import com.br.alex.model.entity.PessoaVO;
import com.br.alex.model.entity.VacinaVO;
import com.br.alex.repository.Constants;

public class VacinaView {

	static DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {

		String[] itens = { "ESCOLHA UMA OPÇÃO", "Cadastrar vacina", "Listar todas vacinas", "Mudar status da vacina" };

		String opcaoEscolhida = (String) JOptionPane.showInputDialog(null, null, "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE, null, itens, itens[0]);

		if (opcaoEscolhida == itens[1]) {
			cadastrarVacina();

		} else if (opcaoEscolhida == itens[2]) {
			listarVacinas();

		} else if (opcaoEscolhida == itens[3]) {
			alteraStatus();

		} else {
			while ((opcaoEscolhida == itens[0])) {
				opcaoEscolhida = (String) JOptionPane.showInputDialog(null, null, "Menu Vacina",
						JOptionPane.QUESTION_MESSAGE, null, itens, itens[0]);
			}
		}
	}

	private static void cadastrarVacina() {
		VacinaVO vacina = new VacinaVO();
		VacinaController vacinaController = new VacinaController();

		vacina.setNomeVacina(JOptionPane.showInputDialog(null, "Digite o nome da vacina", "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE));
		vacina.setQuantidadeDoses(Integer.parseInt(JOptionPane.showInputDialog(null,
				"Digite a quantidade de doses da vacina", "MENU VACINA", JOptionPane.QUESTION_MESSAGE)));
		vacina.setPaisOrigem(JOptionPane.showInputDialog(null, "Digite o país de origem da vacina", "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE));

		// DADOS DO PESQUISADOR
		int idPesquisador = trataDadosPesquisador();
		vacina.setidPessoaResponsavel(idPesquisador);

		String[] fasesVacina = { "ESCOLHA A FASE DA VACINA", Constants.FASE_PESQUISADORES, Constants.FASE_VOLUNTARIOS,
				Constants.FASE_PUBLICO_GERAL };
		String faseEscolhida = (String) JOptionPane.showInputDialog(null, null, "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE, null, fasesVacina, fasesVacina[0]);
		vacina.setFaseVacina(faseEscolhida);

		String[] estagioVacina = { "ESCOLHA O ESTÁGIO DA VACINA", Constants.ESTAGIO_INICIAL, Constants.ESTAGIO_TESTES,
				Constants.ESTAGIO_APLICACAOEMMASSA };
		String estagioEscolhido = (String) JOptionPane.showInputDialog(null, null, "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE, null, estagioVacina, estagioVacina[0]);
		vacina.setEstagioPesquisa(estagioEscolhido);

		LocalDate data = LocalDate.parse(JOptionPane.showInputDialog(null,
				"Digite a data de início da pesquisa da vacina", "MENU VACINA", JOptionPane.QUESTION_MESSAGE),
				dataFormatter);
		vacina.setDataInicioPesquisa(data);

		String[] statusVacina = { "ESCOLHA O STATUS DA VACINA", Constants.STATUS_VACINA_ATIVO,
				Constants.STATUS_VACINA_INATIVO };
		String statusdaVacina = (String) JOptionPane.showInputDialog(null, null, "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE, null, statusVacina, statusVacina[0]);
		vacina.setSituacao(statusdaVacina);

		String retorno = vacinaController.cadastraVacina(vacina);

		JOptionPane.showMessageDialog(null, retorno, "MENU VACINA", JOptionPane.INFORMATION_MESSAGE, null);

	}

	private static void listarVacinas() {
		VacinaController vacinaController = new VacinaController();

		List<VacinaVO> mensagemRetorno = vacinaController.findAll();
		String resposta = "";

		for (VacinaVO vacinaVO : mensagemRetorno) {
			resposta += vacinaVO + "\n";
		}
		JOptionPane.showMessageDialog(null, resposta, "Vacinas", JOptionPane.INFORMATION_MESSAGE, null);

//		JDialog dialog = new JDialog();
//		dialog.setModal(true); 
//		dialog.setVisible(true);
//		dialog.setLocationRelativeTo(null);
//		//dialog.setBounds(50, 50, 550, 550);
//		dialog.setSize(500, 500);
//		JPanel panel = new JPanel();
//		panel.setSize(500, 500);		
//		dialog.add(resposta, panel);

	}

	private static void alteraStatus() {
		VacinaVO vacina = new VacinaVO();
		VacinaController vacinaController = new VacinaController();

		vacina.setNomeVacina(JOptionPane.showInputDialog(null, "Digite o NOME da vacina a ser alterada", "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE));
		vacina.setPaisOrigem(JOptionPane.showInputDialog(null, "Digite o PAÍS DE ORIGEM da vacina a ser alterada",
				"MENU VACINA", JOptionPane.QUESTION_MESSAGE));
		
		String[] statusVacina = { "ESCOLHA O STATUS DA VACINA", Constants.STATUS_VACINA_ATIVO,
				Constants.STATUS_VACINA_INATIVO };
		String statusdaVacina = (String) JOptionPane.showInputDialog(null, null, "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE, null, statusVacina, statusVacina[0]);
		vacina.setSituacao(statusdaVacina);
				
		int retorno = vacinaController.alterarStatusVacina(vacina);

		if (retorno != 0) {
			JOptionPane.showMessageDialog(null, "Alteração efetuada!", null, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Alteração NÃO realizada!", null, JOptionPane.ERROR_MESSAGE, null);
		}
	}

	private static int trataDadosPesquisador() {
		PessoaVO pessoaVO = new PessoaVO();
		PessoaController pessoaController = new PessoaController();

		pessoaVO.setNome(JOptionPane.showInputDialog(null, "Digite o nome do pesquisador", "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE));
		pessoaVO.setCpf(JOptionPane.showInputDialog(null, "Digite o cpf do pesquisador", "MENU VACINA",
				JOptionPane.QUESTION_MESSAGE));
		int idPesquisador = pessoaController.buscaPorNomeECpf(pessoaVO);

		if (idPesquisador != 0) {
			JOptionPane.showMessageDialog(null, "código ID do pesquisador: " + idPesquisador, null,
					JOptionPane.INFORMATION_MESSAGE);
			return idPesquisador;

		} else {
			JOptionPane.showMessageDialog(null, "Pesquisador ainda não cadastrado! Favor cadastrar!", "MENU VACINA",
					JOptionPane.WARNING_MESSAGE);
			PessoaView pessoaView = new PessoaView();
			int retorno = pessoaView.cadastraPessoa(pessoaVO);
			JOptionPane.showMessageDialog(null, "código ID do pesquisador: " + retorno, "MENU VACINA",
					JOptionPane.INFORMATION_MESSAGE);
			return retorno;
		}
	}
}
