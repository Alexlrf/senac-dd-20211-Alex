package com.br.alex.view.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.PanelPeer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.br.alex.controller.PessoaController;
import com.br.alex.controller.VacinaController;
import com.br.alex.model.entity.PessoaVO;
import com.br.alex.model.entity.VacinaVO;
import com.br.alex.repository.Constants;
import com.br.alex.repository.Utils;
import com.br.alex.view.JOptionPane.PessoaView;

public class TelaVacina extends JFrame {
	private static final long serialVersionUID = 1L;
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private JPanel contentPane;
	private JTextField textFieldNomeVacina;
	private JTextField textFieldPaisOrigem;
	private JTextField textFieldCodigoPesquisador;
	private JTextField textFieldDataInicioPesquisa;
	private JSpinner spinnerDoses;
	private JRadioButton btnRadioButtonAtiva;
	private JRadioButton btnRadioButtonInativa;
	private JComboBox comboBoxEstagio;
	private JComboBox comboBoxFase;
	private JLabel lblTitulo;
	private JLabel lblIdVacina;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private VacinaVO vacinaVO;
	private VacinaController vacinaController;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JPanel panelPrincipal;
	private JTextField textFieldIdVacina;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVacina frame = new TelaVacina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */	
	
	public TelaVacina() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.activeCaption);
		panelPrincipal.setBorder(new LineBorder(new Color(25, 25, 112), 10, true));
		panelPrincipal.setBounds(0, 0, 581, 343);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelCadastrar = new JPanel();
		panelCadastrar.setBorder(new LineBorder(new Color(25, 25, 112), 7));
		panelCadastrar.setBackground(new Color(192, 192, 192));
		panelCadastrar.setBounds(56, 53, 469, 211);
		panelPrincipal.add(panelCadastrar);
		panelCadastrar.setLayout(null);

		textFieldNomeVacina = new JTextField();
		textFieldNomeVacina.setBounds(22, 36, 212, 20);
		panelCadastrar.add(textFieldNomeVacina);
		textFieldNomeVacina.setColumns(10);

		JLabel lblNomeVacina = new JLabel("Nome da Vacina");
		lblNomeVacina.setBounds(22, 22, 184, 14);
		lblNomeVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCadastrar.add(lblNomeVacina);

		JLabel lblPaisOrigem = new JLabel("Pa\u00ED de Origem");
		lblPaisOrigem.setBounds(252, 22, 195, 14);
		lblPaisOrigem.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCadastrar.add(lblPaisOrigem);

		textFieldPaisOrigem = new JTextField();
		textFieldPaisOrigem.setBounds(252, 36, 195, 20);
		textFieldPaisOrigem.setColumns(10);
		panelCadastrar.add(textFieldPaisOrigem);

		JLabel lblCodigoPesquisador = new JLabel("C\u00F3digo do  Pesquisador");
		lblCodigoPesquisador.setBounds(252, 112, 195, 14);
		lblCodigoPesquisador.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCadastrar.add(lblCodigoPesquisador);

		textFieldCodigoPesquisador = new JTextField();
		textFieldCodigoPesquisador.setBounds(252, 126, 195, 20);
		textFieldCodigoPesquisador.setColumns(10);
		panelCadastrar.add(textFieldCodigoPesquisador);

		JLabel lblDataInicioPesquisa = new JLabel("Data do In\u00EDcio da Pesquisa");
		lblDataInicioPesquisa.setBounds(252, 67, 195, 14);
		lblDataInicioPesquisa.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCadastrar.add(lblDataInicioPesquisa);

		textFieldDataInicioPesquisa = new JTextField();
		textFieldDataInicioPesquisa.setBounds(252, 81, 195, 20);
		textFieldDataInicioPesquisa.setColumns(10);
		panelCadastrar.add(textFieldDataInicioPesquisa);

		comboBoxEstagio = new JComboBox();
		comboBoxEstagio.setBounds(22, 125, 164, 22);
		comboBoxEstagio.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxEstagio.setModel(new DefaultComboBoxModel(
				new String[] { "ESTÁGIO", Constants.ESTAGIO_INICIAL, Constants.ESTAGIO_TESTES, Constants.ESTAGIO_APLICACAOEMMASSA }));
		panelCadastrar.add(comboBoxEstagio);

		comboBoxFase = new JComboBox();
		comboBoxFase.setBounds(22, 165, 164, 22);
		comboBoxFase.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxFase.setModel(new DefaultComboBoxModel(
				new String[] { "FASE", Constants.FASE_PESQUISADORES, Constants.FASE_VOLUNTARIOS, Constants.FASE_PUBLICO_GERAL }));
		panelCadastrar.add(comboBoxFase);

		btnRadioButtonAtiva = new JRadioButton("Ativa");
		btnRadioButtonAtiva.setBounds(22, 91, 70, 23);
		buttonGroup.add(btnRadioButtonAtiva);
		btnRadioButtonAtiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRadioButtonAtiva.setBackground(new Color(192, 192, 192));
		panelCadastrar.add(btnRadioButtonAtiva);

		btnRadioButtonInativa = new JRadioButton("Inativa");
		btnRadioButtonInativa.setBounds(123, 91, 83, 23);
		buttonGroup.add(btnRadioButtonInativa);
		btnRadioButtonInativa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRadioButtonInativa.setBackground(new Color(192, 192, 192));
		panelCadastrar.add(btnRadioButtonInativa);

		JLabel lblNumeroDoses = new JLabel("N\u00FAmero de Doses");
		lblNumeroDoses.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroDoses.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDoses.setBounds(252, 169, 132, 14);
		panelCadastrar.add(lblNumeroDoses);

		spinnerDoses = new JSpinner();
		spinnerDoses.setFont(new Font("Tahoma", Font.BOLD, 11));
		spinnerDoses.setBounds(394, 166, 42, 20);
		panelCadastrar.add(spinnerDoses);
		
		textFieldIdVacina = new JTextField();
		textFieldIdVacina.setBounds(151, 64, 83, 20);
		textFieldIdVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCadastrar.add(textFieldIdVacina);		
		textFieldIdVacina.setColumns(10);
		
		lblIdVacina = new JLabel("C\u00F3digo da Vacina");
		lblIdVacina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdVacina.setBounds(22, 67, 119, 14);
		panelCadastrar.add(lblIdVacina);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VacinaVO vacina = new VacinaVO();
				vacinaController = new VacinaController();

				if (validaEntradaDados()) {

					vacina.setNomeVacina(textFieldNomeVacina.getText());
					vacina.setQuantidadeDoses(spinnerDoses.getComponentCount());
					vacina.setPaisOrigem(textFieldPaisOrigem.getText());
					vacina.setFaseVacina(comboBoxFase.getSelectedItem().toString());
					vacina.setEstagioPesquisa(comboBoxEstagio.getSelectedItem().toString());
					LocalDate dataPesquisa = LocalDate.parse(textFieldDataInicioPesquisa.getText(), dataFormatter);
					vacina.setDataInicioPesquisa(dataPesquisa);

					if (btnRadioButtonAtiva.isSelected()) {
						vacina.setSituacao(Constants.STATUS_VACINA_ATIVO);

					} else {
						vacina.setSituacao(Constants.STATUS_VACINA_INATIVO);
					}

					// DADOS DO PESQUISADOR
					int idPesquisador = trataDadosPesquisador();
					vacina.setidPessoaResponsavel(idPesquisador);

					String retorno = vacinaController.cadastraVacina(vacina);
					JOptionPane.showMessageDialog(null, retorno, "MENU VACINA", JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
		});

		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(400, 290, 125, 23);
		panelPrincipal.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(232, 290, 125, 23);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (validaEntradaDados()) {
					
					vacinaController = new VacinaController();
					vacinaVO = new VacinaVO();
					vacinaVO.setIdVacina(Integer.parseInt(textFieldIdVacina.getText()));
					vacinaVO.setNomeVacina(textFieldNomeVacina.getText());
					vacinaVO.setQuantidadeDoses(Integer.parseInt(spinnerDoses.getValue().toString()));
					vacinaVO.setPaisOrigem(textFieldPaisOrigem.getText());
					vacinaVO.setFaseVacina(comboBoxFase.getSelectedItem().toString());
					vacinaVO.setEstagioPesquisa(comboBoxEstagio.getSelectedItem().toString());
					LocalDate dataPesquisa = LocalDate.parse(textFieldDataInicioPesquisa.getText(), dataFormatter);
					vacinaVO.setDataInicioPesquisa(dataPesquisa);
					vacinaVO.setidPessoaResponsavel(Integer.parseInt(textFieldCodigoPesquisador.getText()));

					if (btnRadioButtonAtiva.isSelected()) {
						vacinaVO.setSituacao(Constants.STATUS_VACINA_ATIVO);

					} else {
						vacinaVO.setSituacao(Constants.STATUS_VACINA_INATIVO);
					}
					
					String retorno = vacinaController.alterarVacina(vacinaVO);
					JOptionPane.showMessageDialog(null, retorno, "MENU VACINA", JOptionPane.INFORMATION_MESSAGE, null);
				}				

			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualizar.setBounds(400, 290, 125, 23);
		btnAtualizar.setVisible(false);
		panelPrincipal.add(btnAtualizar);
		
		if (vacinaVO != null) {			
			panelPrincipal.add(btnAtualizar);
			panelPrincipal.add(lblIdVacina);
			panelPrincipal.add(textFieldIdVacina);
		} else {
			panelPrincipal.add(btnCadastrar);
			lblIdVacina.setVisible(false);
			textFieldIdVacina.setVisible(false);
		}
		
		panelPrincipal.add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal telaPrincipal = new TelaMenuPrincipal();
				telaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(58, 290, 125, 23);
		panelPrincipal.add(btnVoltar);

		lblTitulo = new JLabel("CADASTRO DE VACINAS");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setForeground(new Color(25, 25, 112));
		lblTitulo.setBounds(56, 19, 469, 32);
		panelPrincipal.add(lblTitulo);		

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

	public VacinaVO getVacinaVO() {
		return vacinaVO;
	}

	public void setVacinaVO(VacinaVO vacinaVO) {
		this.vacinaVO = vacinaVO;
	}

	public void preencheTela(VacinaVO vacina) {
				
		if (vacina.getIdVacina() != null && vacina.getIdVacina() > 0) {
			this.btnAtualizar.setVisible(true);
			this.btnCadastrar.setVisible(false);
			this.lblTitulo.setText("Alteração de Vacina");
			this.lblIdVacina.setVisible(true);
			this.textFieldIdVacina.setVisible(true);
			this.textFieldIdVacina.setEnabled(false);
		} else {
			this.btnAtualizar.setVisible(false);
			this.btnCadastrar.setVisible(true);
		}
		
		this.textFieldIdVacina.setText(String.valueOf(vacina.getIdVacina()));
		this.textFieldNomeVacina.setText(vacina.getNomeVacina());
		this.textFieldPaisOrigem.setText(vacina.getPaisOrigem());
		this.textFieldDataInicioPesquisa.setText(dataFormatter.format(vacina.getDataInicioPesquisa()));
		this.textFieldCodigoPesquisador.setText(String.valueOf(vacina.getidPessoaResponsavel()));
		this.spinnerDoses.setValue(vacina.getQuantidadeDoses());		

		if (vacina.getSituacao().equalsIgnoreCase(Constants.STATUS_VACINA_ATIVO)) {
			this.btnRadioButtonAtiva.setSelected(true);
	
		} else {
			this.btnRadioButtonInativa.setSelected(true);

		}		
		this.comboBoxEstagio.setSelectedItem(vacina.getEstagioPesquisa());
		this.comboBoxFase.setSelectedItem(vacina.getFaseVacina());			
	}
	
	public boolean validaEntradaDados() {
		int doses = Integer.parseInt(spinnerDoses.getValue().toString());
		final String titulo = "ATENÇÃO";
		
		if (!Utils.stringValida(textFieldNomeVacina.getText()) 
				|| !Utils.stringValida(textFieldPaisOrigem.getText())						 						
				|| comboBoxEstagio.getSelectedIndex() == 0 
				|| comboBoxFase.getSelectedIndex() == 0
				|| !btnRadioButtonAtiva.isSelected() 
				&& !btnRadioButtonInativa.isSelected()) {
			JOptionPane.showMessageDialog(null, "Favor verificar CAMPOS SEM PREENCHIMENTO ", titulo,
					JOptionPane.WARNING_MESSAGE, null);					
			
		}else if(textFieldDataInicioPesquisa.getText().isEmpty() 
				|| !Utils.dataValida(LocalDate.parse(textFieldDataInicioPesquisa.getText(), dataFormatter))) {
			JOptionPane.showMessageDialog(null, "Favor verificar a DATA informada", titulo,
					JOptionPane.WARNING_MESSAGE, null);					
			
		}else if(doses <= 0) {
			JOptionPane.showMessageDialog(null, "Favor verificar a QUANTIDADE DE DOSES informada", titulo,
					JOptionPane.WARNING_MESSAGE, null);					
		
		}else {			
			return true;
		}		
		return false;
	}
}


