package com.br.alex.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TelaMenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPrincipal frame = new TelaMenuPrincipal();
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
	public TelaMenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 319);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 10, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTítulo = new JLabel("Menu Principal");
		lblTítulo.setForeground(new Color(25, 25, 112));
		lblTítulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTítulo.setBounds(27, 20, 377, 28);
		contentPane.add(lblTítulo);
		
		JPanel panelAplicacoes = new JPanel();
		panelAplicacoes.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		panelAplicacoes.setBackground(new Color(192, 192, 192));
		panelAplicacoes.setBounds(19, 201, 441, 59);
		contentPane.add(panelAplicacoes);
		panelAplicacoes.setLayout(null);
		
		JLabel lblAplicacao = new JLabel("Aplica\u00E7\u00F5es ");
		lblAplicacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAplicacao.setBounds(10, 1, 86, 14);
		panelAplicacoes.add(lblAplicacao);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.setBounds(8, 25, 102, 23);
		panelAplicacoes.add(btnNewButton_2);
		
		JButton btnConsultar_2 = new JButton("Consultar");
		btnConsultar_2.setBounds(115, 25, 102, 23);
		panelAplicacoes.add(btnConsultar_2);
		
		JButton btnNewButton_6_3 = new JButton("Cadastrar");
		btnNewButton_6_3.setBounds(223, 25, 101, 23);
		panelAplicacoes.add(btnNewButton_6_3);
		
		JButton btnNewButton_6_4 = new JButton("Cadastrar");
		btnNewButton_6_4.setBounds(331, 25, 100, 23);
		panelAplicacoes.add(btnNewButton_6_4);
		
		JPanel panelPessoas = new JPanel();
		panelPessoas.setLayout(null);
		panelPessoas.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		panelPessoas.setBackground(Color.LIGHT_GRAY);
		panelPessoas.setBounds(19, 130, 441, 59);
		contentPane.add(panelPessoas);
		
		JLabel lblPessoa = new JLabel("Pessoas");
		lblPessoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPessoa.setBounds(10, 1, 86, 14);
		panelPessoas.add(lblPessoa);
		
		JButton btnNewButton_2_1 = new JButton("Cadastrar");
		btnNewButton_2_1.setBounds(8, 25, 102, 23);
		panelPessoas.add(btnNewButton_2_1);
		
		JButton btnConsultar_2_1 = new JButton("Consultar");
		btnConsultar_2_1.setBounds(115, 25, 102, 23);
		panelPessoas.add(btnConsultar_2_1);
		
		JButton btnNewButton_6_3_1 = new JButton("Cadastrar");
		btnNewButton_6_3_1.setBounds(223, 25, 101, 23);
		panelPessoas.add(btnNewButton_6_3_1);
		
		JButton btnNewButton_6_4_1 = new JButton("Cadastrar");
		btnNewButton_6_4_1.setBounds(331, 25, 100, 23);
		panelPessoas.add(btnNewButton_6_4_1);
		
		JPanel panelVacinas = new JPanel();
		panelVacinas.setLayout(null);
		panelVacinas.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		panelVacinas.setBackground(Color.LIGHT_GRAY);
		panelVacinas.setBounds(19, 59, 441, 59);
		contentPane.add(panelVacinas);
		
		JLabel lblVacina = new JLabel("Vacinas");
		lblVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVacina.setBounds(10, 1, 86, 14);
		panelVacinas.add(lblVacina);
		
		JButton btnCadastraVacina = new JButton("Cadastrar");
		btnCadastraVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVacina telaVacina = new TelaVacina();
				telaVacina.setVisible(true);
				dispose();
			}
		});
		btnCadastraVacina.setBounds(8, 25, 102, 23);
		panelVacinas.add(btnCadastraVacina);
		
		JButton btnConsultaVacina = new JButton("Consultar");
		btnConsultaVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTabelaVacinas tabelaVacinas = new TelaTabelaVacinas();
				tabelaVacinas.setVisible(true);
				dispose();
			}
		});
		btnConsultaVacina.setBounds(115, 25, 102, 23);
		panelVacinas.add(btnConsultaVacina);
		
		JButton btnAlteraVacina = new JButton("Alterar");
		btnAlteraVacina.setBounds(223, 25, 101, 23);
		panelVacinas.add(btnAlteraVacina);
		
		JButton btnExcluiVacina = new JButton("Excluir");
		btnExcluiVacina.setBounds(331, 25, 100, 23);
		panelVacinas.add(btnExcluiVacina);
	}
}
