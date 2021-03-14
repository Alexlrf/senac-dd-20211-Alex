package com.br.alex.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.br.alex.model.dao.PessoaDAO;
import com.br.alex.model.entity.PessoaVO;
import com.br.alex.repository.Constants;

public class Principal {
	
	static DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {

		PessoaVO pessoaVO =  new PessoaVO();
		pessoaVO.setNome("Maria");
		pessoaVO.setDataNascimento(LocalDate.parse("22/10/2019",dataFormatter));
		pessoaVO.setCpf("444");
		pessoaVO.setSexo("feminino");
		pessoaVO.setCategoria(Constants.FASE_PUBLICO_GERAL);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		
		try {
			pessoaDAO.insert(pessoaVO);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no executável!");
			e.printStackTrace();
		}
	
	}

}
