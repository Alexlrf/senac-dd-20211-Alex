package com.br.alex.view.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.br.alex.controller.VacinaController;
import com.br.alex.model.entity.VacinaVO;
import com.br.alex.model.seletor.VacinaSeletor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.Frame;

public class TelaTabelaVacinas extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private List<VacinaVO> vacinas;
	JButton btnExcluir;
	JButton btnEditar;
	private String[] nomeColunas = {"C�d. Vacina", "Nome", "Respons�vel", "Origem", "Doses", "Est�gio", "Data", "Fase", "Status"};
	
	VacinaController vacinaController = new VacinaController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTabelaVacinas frame = new TelaTabelaVacinas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public TelaTabelaVacinas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 402);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 10, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Listagem de Vacinas");
		lblTitulo.setForeground(new Color(25, 25, 112));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(27, 23, 217, 26);
		contentPane.add(lblTitulo);
				
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				TelaMenuPrincipal menuPrincipal = new TelaMenuPrincipal();
				menuPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(19, 282, 202, 23);
		contentPane.add(btnVoltar);		
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
				VacinaVO vacinaVO = vacinas.get(linhaSelecionada);
				vacinaController.alterarStatusVacina(vacinaVO);
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBounds(340, 282, 202, 23);
		btnExcluir.setEnabled(false);
		contentPane.add(btnExcluir);		
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow()-1;
				
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja alterar Vacina?", "ALTERA��O DE VACINA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

				if(opcao == JOptionPane.YES_OPTION) {				
					VacinaVO vacinaVO = vacinas.get(linhaSelecionada);				
					TelaVacina telaVacina = new TelaVacina();
					telaVacina.preencheTela(vacinaVO);
					telaVacina.setVisible(true);
					dispose();
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBounds(654, 282, 202, 23);	
		btnEditar.setEnabled(false);
		contentPane.add(btnEditar);		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				int indiceSelecionado = table.getSelectedRow();
				
				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				} else {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		table.setBorder(new LineBorder(new Color(25, 25, 112), 3));
		table.setBounds(19, 60, 837, 160);
		contentPane.add(table);		
		
		JButton btnBuscarTodos = new JButton("Buscar Lista completa");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vacinas = vacinaController.findAll();
				limparTabela();				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				for (VacinaVO vacina : vacinas) {
					Object[] novaLinha = new Object[9]; 
					
					novaLinha[0] = " " + vacina.getIdVacina();
					novaLinha[1] = vacina.getNomeVacina();
					novaLinha[2] = vacina.getidPessoaResponsavel(); 
					novaLinha[3] = vacina.getPaisOrigem();
					novaLinha[4] = vacina.getQuantidadeDoses();
					novaLinha[5] = vacina.getEstagioPesquisa();
					novaLinha[6] = vacina.getDataInicioPesquisa();
					novaLinha[7] = vacina.getFaseVacina();
					novaLinha[8] = vacina.getSituacao();
					model.addRow(novaLinha);				
				}				
			}			
		
		});
		btnBuscarTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscarTodos.setBounds(19, 231, 837, 29);
		contentPane.add(btnBuscarTodos);
		
		JComboBox comboBoxSeletorStatus = new JComboBox();
		comboBoxSeletorStatus.setModel(new DefaultComboBoxModel(new String[] {"STATUS", "ATIVO", "INATIVO"}));
		comboBoxSeletorStatus.setBounds(606, 27, 151, 22);
		contentPane.add(comboBoxSeletorStatus);
		
		JFormattedTextField frmtdtxtfldNomeDaVacina = new JFormattedTextField();
		frmtdtxtfldNomeDaVacina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (frmtdtxtfldNomeDaVacina.getText().equalsIgnoreCase("Nome da Vacina")) {
					frmtdtxtfldNomeDaVacina.setText("");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (frmtdtxtfldNomeDaVacina.getText().isEmpty()) {
					frmtdtxtfldNomeDaVacina.setText("");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (frmtdtxtfldNomeDaVacina.getText().isEmpty()) {
					frmtdtxtfldNomeDaVacina.setText("Nome da Vacina");
				}
			}
		});
		frmtdtxtfldNomeDaVacina.setText("Nome da Vacina");
		frmtdtxtfldNomeDaVacina.setBounds(221, 28, 193, 20);
		contentPane.add(frmtdtxtfldNomeDaVacina);
		
		JFormattedTextField frmtdtxtfldPasDeOrigem = new JFormattedTextField();
		frmtdtxtfldPasDeOrigem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (frmtdtxtfldPasDeOrigem.getText().equalsIgnoreCase("País de Origem")) {
					frmtdtxtfldPasDeOrigem.setText("");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (frmtdtxtfldPasDeOrigem.getText().isEmpty()) {
					frmtdtxtfldPasDeOrigem.setText("");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (frmtdtxtfldPasDeOrigem.getText().isEmpty()) {
					frmtdtxtfldPasDeOrigem.setText("País de Origem");
				}
			}
		});
		frmtdtxtfldPasDeOrigem.setText("País de Origem");
		frmtdtxtfldPasDeOrigem.setBounds(424, 28, 172, 20);
		contentPane.add(frmtdtxtfldPasDeOrigem);
		
		JButton btnSeletorBuscar = new JButton("Buscar");
		btnSeletorBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VacinaSeletor vacinaSeletor = new VacinaSeletor();
				
				if (frmtdtxtfldNomeDaVacina.getText().equalsIgnoreCase("Nome da Vacina")) {
					vacinaSeletor.setNome("");
				}else {
					vacinaSeletor.setNome(frmtdtxtfldNomeDaVacina.getText().toString().trim());					
				}
				
				if (frmtdtxtfldPasDeOrigem.getText().equalsIgnoreCase("País de Origem")) {
					vacinaSeletor.setPaisOrigem("");
				}else {
					vacinaSeletor.setPaisOrigem(frmtdtxtfldPasDeOrigem.getText().toString().trim());					
				}
				
				if (comboBoxSeletorStatus.getSelectedIndex() > 0) {					
					vacinaSeletor.setSituacao(comboBoxSeletorStatus.getSelectedItem().toString());
				}
				limparTabela();
				List<VacinaVO> listaVacinas = vacinaController.listarComFiltros(vacinaSeletor);
				DefaultTableModel modeloTabela = (DefaultTableModel) table.getModel();
				
				for (VacinaVO vacina : listaVacinas) {
					Object[] novaLinha = new Object[9]; 
					
					novaLinha[0] = vacina.getIdVacina();
					novaLinha[1] = vacina.getNomeVacina();
					novaLinha[2] = vacina.getidPessoaResponsavel(); 
					novaLinha[3] = vacina.getPaisOrigem();
					novaLinha[4] = vacina.getQuantidadeDoses();
					novaLinha[5] = vacina.getEstagioPesquisa();
					novaLinha[6] = vacina.getDataInicioPesquisa();
					novaLinha[7] = vacina.getFaseVacina();
					novaLinha[8] = vacina.getSituacao();
					modeloTabela.addRow(novaLinha);				
				}
				
			}

		});
		btnSeletorBuscar.setBounds(767, 27, 89, 23);
		contentPane.add(btnSeletorBuscar);
	}
	
	
	protected void limparTabela() {				
		table.setModel(new DefaultTableModel(new Object[][] { nomeColunas, }, nomeColunas));				
		btnExcluir.setEnabled(false);
		btnEditar.setEnabled(false);				
	}
	
}
