package com.br.alex.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.alex.model.dao.AplicacaoVacinaDAO;
import com.br.alex.model.dao.PessoaDAO;
import com.br.alex.model.dao.VacinaDAO;
import com.br.alex.model.entity.AplicacaoVacinaVO;
import com.br.alex.model.entity.PessoaVO;
import com.br.alex.model.entity.VacinaVO;
import com.br.alex.repository.Constants;

public class Principal {
	
	static DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {

		
		// =======================  Inclui =============================================		
		
	
//		PessoaVO pessoaVO =  new PessoaVO();
//		pessoaVO.setNome("Roberval");
//		pessoaVO.setDataNascimento(LocalDate.parse("30/05/2008",dataFormatter));
//		pessoaVO.setCpf("777");
//		pessoaVO.setSexo("masculino");
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
//		pessoa = pessoaDAO.findById(3);
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
//		vacinaVO.setNomeVacina("Vacina000");
//		vacinaVO.setEstagioPesquisa("testes000");
//		vacinaVO.setResponsavelPesquisa("João000");
//		vacinaVO.setDataInicioPesquisa(LocalDate.parse("22/02/2012",dataFormatter));
//		vacinaVO.setFaseVacina("testes000");
//		vacinaVO.setPaisOrigem("Estônia000");
//		vacinaVO.setQuantidadeDoses(1);//		
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
		
		
//		AplicacaoVacinaVO aplicacaoVacinaVO = new AplicacaoVacinaVO();
//		AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();
//		
//		aplicacaoVacinaVO.setIdVacina(2);
//		aplicacaoVacinaVO.setidPessoa(2);
//		aplicacaoVacinaVO.setReacao(Constants.REACAO_OTIMA);
//		aplicacaoVacinaVO.setDataAplicacao(LocalDate.parse("22/02/2012",dataFormatter));
//		aplicacaoVacinaDAO.insert(aplicacaoVacinaVO);
		
		
//		AplicacaoVacinaVO aplicacaoVacinaVO = new AplicacaoVacinaVO();
//		AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();
//		
//		aplicacaoVacinaVO.setIdVacina(1);
//		aplicacaoVacinaVO.setidPessoa(1);
//		aplicacaoVacinaVO.setReacao(Constants.REACAO_PESSIMA);
//		aplicacaoVacinaVO.setDataAplicacao(LocalDate.parse("22/02/2019",dataFormatter));
//		aplicacaoVacinaVO.setIdAplicacaoVacina(2);
//		
//		aplicacaoVacinaDAO.update(aplicacaoVacinaVO);
		
		
		
//		AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();		
//		aplicacaoVacinaDAO.delete(3);
		
		
//		AplicacaoVacinaVO aplicacaoVacinaVO = new AplicacaoVacinaVO();
//		AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();
		
		
//		System.out.println(aplicacaoVacinaDAO.findById(2).toString());
		
//		List<AplicacaoVacinaVO> lista = new ArrayList<>();
//		lista = aplicacaoVacinaDAO.findAll();
//		for (AplicacaoVacinaVO aplicacao : lista) {
//			
//			System.out.println("\n"+aplicacao.toString());
		
		
		
		
//		VacinaDAO dao = new VacinaDAO();
//		VacinaVO vo = new VacinaVO();
//		
//		vo.setNomeVacina("Vacina444");
//		vo.setPaisOrigem("Estônia444");	
//		
//		int retorno = dao.findIdForPaisAndNomeVacina(vo);
//		
//		System.out.println(retorno);
			
		}
	
		
		
	
	}


