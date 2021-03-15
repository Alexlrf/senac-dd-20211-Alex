package com.br.alex.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.alex.model.dao.PessoaDAO;
import com.br.alex.model.entity.PessoaVO;
import com.br.alex.repository.Constants;

public class Principal {
	
	static DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {

		
		// =======================  Inclui =============================================		
		
	
//		PessoaVO pessoaVO =  new PessoaVO();
//		pessoaVO.setNome("Bruna");
//		pessoaVO.setDataNascimento(LocalDate.parse("11/11/2000",dataFormatter));
//		pessoaVO.setCpf("456");
//		pessoaVO.setSexo("feminino");
//		pessoaVO.setCategoria(Constants.FASE_PUBLICO_GERAL);
//		
//		PessoaDAO pessoaDAO = new PessoaDAO();		
//		try {
//			pessoaDAO.insert(pessoaVO);
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Erro no executável!");
//			e.printStackTrace();
//		}
		
		// ======================  Altera  ===============================================
		
//		PessoaVO pessoaVO =  new PessoaVO();
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		pessoaVO.setIdPessoa(1);
//		pessoaVO.setNome("Maria Rosa");
//		pessoaVO.setDataNascimento(LocalDate.parse("12/12/2000",dataFormatter));
//		pessoaVO.setCpf("12345");
//		pessoaVO.setSexo("feminino");
//		pessoaVO.setCategoria(Constants.FASE_PUBLICO_GERAL);
//		
//		pessoaDAO.update(pessoaVO);
		
		// ===================  Busca por ID  ============================================
		
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		PessoaVO pessoa;
//		
//		pessoaDAO.delete(1);
//		
//		pessoa = pessoaDAO.finfById(2);
//		
//		System.out.println(pessoa.toString());
		
		
		// ==================== Busca Todos ===================================================
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		PessoaVO pessoa;

		List<PessoaVO >ListaPessoa = pessoaDAO.findAll();
		
		for (PessoaVO pessoaVO : ListaPessoa) {
			System.out.println(pessoaVO.toString());
			
		}		
	
	}

}
