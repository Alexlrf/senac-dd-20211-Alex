package com.br.alex.view;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.br.alex.model.dao.PessoaDAO;
import com.br.alex.model.entity.PessoaVO;

public class Principal {
	
	static DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {

		
		// =======================  Inclui =============================================		
		
//	
//		PessoaVO pessoaVO =  new PessoaVO();
//		pessoaVO.setNome("Joana");
//		pessoaVO.setDataNascimento(LocalDate.parse("30/05/2008",dataFormatter));
//		pessoaVO.setCpf("999");
//		pessoaVO.setSexo("feminino");
//		pessoaVO.setCategoria(Constants.FASE_VOLUNTARIOS);
//		
//		PessoaDAO pessoaDAO = new PessoaDAO();		
//		try {
//			pessoaDAO.insert(pessoaVO);
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Erro no executável!");
//			e.printStackTrace();
//		}
		
		// ======================  Altera  ===============================================
//		
//		PessoaVO pessoaVO =  new PessoaVO();
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		pessoaVO.setIdPessoa(3);
//		pessoaVO.setNome("Maria Rosa");
//		pessoaVO.setDataNascimento(LocalDate.parse("12/12/2000",dataFormatter));
//		pessoaVO.setCpf("12345");
//		pessoaVO.setSexo("feminino");
//		pessoaVO.setCategoria(Constants.FASE_PESQUISADORES);
//		
//		pessoaDAO.update(pessoaVO);
		
		// ===================  Deleta  ============================================
		
//		PessoaDAO pessoaDAO = new PessoaDAO();
//				
//		pessoaDAO.delete(3);
		
		
		// ===================  Busca por ID  ============================================
		
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		PessoaVO pessoa;
//		
//		pessoa = pessoaDAO.finfById(2);
//		
//		System.out.println(pessoa.toString());
		
		
		// ==================== Busca Todos ===================================================
		
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		
//		List<PessoaVO >ListaPessoa = pessoaDAO.findAll();
//		
//		for (PessoaVO pessoaVO : ListaPessoa) {
//			System.out.println("\n"+pessoaVO.toString());
//			
//		}
		
		
//		===================================================================================================
//		===================================================================================================
//		===================================================================================================
//		===================================================================================================
		
//		VacinaDAO dao = new VacinaDAO();
//		VacinaVO vacinaVO = new VacinaVO();
//		
//		vacinaVO.setNomeVacina("Vacina444");
//		vacinaVO.setEstagioPesquisa("testes444");
//		vacinaVO.setResponsavelPesquisa("João444");
//		vacinaVO.setDataInicioPesquisa(LocalDate.parse("22/02/2012",dataFormatter));
//		vacinaVO.setFaseVacina("testes444");
//		vacinaVO.setPaisOrigem("Estônia444");
//		vacinaVO.setQuantidadeDoses(4);//		
//		dao.insert(vacinaVO);
		
		
		
//		vacinaVO.setIdVacina(3);
//		vacinaVO.setNomeVacina("Vacina999");
//		vacinaVO.setEstagioPesquisa("testes999");
//		vacinaVO.setResponsavelPesquisa("João999");
//		vacinaVO.setDataInicioPesquisa(LocalDate.parse("19/09/2019",dataFormatter));
//		vacinaVO.setFaseVacina("testes999");
//		vacinaVO.setPaisOrigem("Estônia999");
//		vacinaVO.setQuantidadeDoses(3);
//		dao.update(vacinaVO);
		
		
//		dao.delete(4);
		
		
		
//		vacinaVO =  dao.findById(4);		
//		System.out.println(vacinaVO.toString());
		
		
		
//		List<VacinaVO> lista = new ArrayList<>();
//		lista = dao.findAll();
//		
//		for (VacinaVO vacina : lista) {						
//			System.out.println("\n"+vacina.toString()); 
//		}
	
	}

}
