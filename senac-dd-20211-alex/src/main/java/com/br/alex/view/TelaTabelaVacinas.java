package com.br.alex.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.br.alex.controller.VacinaController;
import com.br.alex.model.entity.VacinaVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaTabelaVacinas extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private List<VacinaVO> vacinas;
	JButton btnExcluir;
	JButton btnEditar;
	private String[] nomeColunas = {"Nome", "Responsável", "Origem", "Doses", "Estágio", "Data", "Fase", "Status"};
	
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
		setBounds(100, 100, 715, 402);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 10, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblTitulo = new JLabel("Listagem de Vacinas");
		lblTitulo.setForeground(new Color(25, 25, 112));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(22, 23, 392, 26);
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
		btnExcluir.setBounds(246, 282, 202, 23);
		btnExcluir.setEnabled(false);
		contentPane.add(btnExcluir);
		
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow()-1;
				VacinaVO vacinaVO = vacinas.get(linhaSelecionada);				
				TelaVacina telaVacina = new TelaVacina();
				telaVacina.preencheTela(vacinaVO);
				telaVacina.setVisible(true);
				dispose();
				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBounds(470, 282, 202, 23);	
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
		table.setBounds(19, 60, 653, 160);
		contentPane.add(table);
		
		
		JButton btnBuscarTodos = new JButton("Buscar Lista completa");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vacinas = vacinaController.findAll();
				this.limparTabela();				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				for (VacinaVO vacina : vacinas) {
					Object[] novaLinha = new Object[8]; 
					
					novaLinha[0] = vacina.getNomeVacina();
					novaLinha[1] = vacina.getidPessoaResponsavel(); 
					novaLinha[2] = vacina.getPaisOrigem();
					novaLinha[3] = vacina.getQuantidadeDoses();
					novaLinha[4] = vacina.getEstagioPesquisa();
					novaLinha[5] = vacina.getDataInicioPesquisa();
					novaLinha[6] = vacina.getFaseVacina();
					novaLinha[7] = vacina.getSituacao();
					model.addRow(novaLinha);				
				}				
			}
			
			private void limparTabela() {				
				table.setModel(new DefaultTableModel(new Object[][] { nomeColunas, }, nomeColunas));				
				btnExcluir.setEnabled(false);
				btnEditar.setEnabled(false);				
			}			
		});
		btnBuscarTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscarTodos.setBounds(19, 231, 653, 29);
		contentPane.add(btnBuscarTodos);
	}
}
