package com.br.alex.view.telas;

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
		setBounds(100, 100, 652, 324);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(25, 25, 112));
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(25, 25, 112), 10, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Menu Principal");
		lblTitulo.setForeground(new Color(25, 25, 112));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(27, 20, 377, 28);
		contentPane.add(lblTitulo);
		
		JPanel panelVacinas = new JPanel();
		panelVacinas.setLayout(null);
		panelVacinas.setBorder(new LineBorder(new Color(25, 25, 112), 2));
		panelVacinas.setBackground(Color.LIGHT_GRAY);
		panelVacinas.setBounds(18, 119, 596, 113);
		contentPane.add(panelVacinas);
		
		JButton btnCadastraVacina = new JButton("Cadastrar");
		btnCadastraVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVacina telaVacina = new TelaVacina();
				telaVacina.setVisible(true);
				dispose();
			}
		});
		btnCadastraVacina.setBounds(30, 25, 232, 77);
		panelVacinas.add(btnCadastraVacina);
		
		JButton btnConsultaVacina = new JButton("CONSULTAR   -   ALTERAR");
		btnConsultaVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTabelaVacinas tabelaVacinas = new TelaTabelaVacinas();
				tabelaVacinas.setVisible(true);
				dispose();
			}
		});
		btnConsultaVacina.setBounds(328, 25, 232, 77);
		panelVacinas.add(btnConsultaVacina);
		
		JLabel lblVacina = new JLabel("VACINAS");
		lblVacina.setForeground(new Color(25, 25, 112));
		lblVacina.setBackground(SystemColor.activeCaption);
		lblVacina.setBounds(27, 94, 120, 21);
		contentPane.add(lblVacina);
		lblVacina.setFont(new Font("Tahoma", Font.BOLD, 13));
	}
}
