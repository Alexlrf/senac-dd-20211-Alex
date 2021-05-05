package com.br.alex.model.bo;

import java.util.List;

import com.br.alex.model.dao.VacinaDAO;
import com.br.alex.model.entity.VacinaVO;
import com.br.alex.model.seletor.VacinaSeletor;

public class VacinaBO {
	
	VacinaDAO vacinaDAO = new VacinaDAO();
	VacinaVO vacinaVO = new VacinaVO();

	public List<VacinaVO> findAll() {		
		return vacinaDAO.findAll();
	}

	public int alterarStatusVacina(VacinaVO vacina) {		
		return vacinaDAO.alterarStatusVacina(vacina);
	}
	
	public String cadastraVacina(VacinaVO vacina) {
		String resultado = "";		
				
		boolean retorno = this.validaVacinaPorNomeEPais(vacina);
		
		if(retorno) {			
			VacinaVO vacinaInsert = vacinaDAO.insert(vacina);			
			if (vacinaInsert.getPaisOrigem() == null && vacinaInsert.getIdVacina()==null) {				
				resultado = "Vacina cadastrada com sucesso!";
			} 
			
		} else {
			resultado = "Vacina j� cadastrada neste pa�s!";
			
		}  
		return resultado;
	}
	
	public String alterarVacina(VacinaVO vacina) {
		boolean retorno = this.validaVacinaPorNomeEPais(vacina);
		String mensagem = "Erro ao atualizar!";
		
		if (retorno) {
			boolean resultado = vacinaDAO.update(vacina);
			if(resultado) {
				mensagem =  "Altera��o efetuada com sucesso!";
			}else {
				mensagem =  "Altera��o n�o efetuada!";
			}
			
		}else {			
			boolean resposta = vacinaDAO.updateVacinaDTO(vacina);
			
			if (resposta) {
				mensagem = "Altera��o efetuada com sucesso!";			
				
			} else {
				mensagem = "Erro ao atualizar dados!";
			}
		}
		return mensagem;
	}

	private boolean validaVacinaPorNomeEPais(VacinaVO vacina) {
		boolean retorno = false;
		vacinaVO = vacinaDAO.buscaPorPaisENomeVacina(vacina);
		
		if (vacinaVO.getNomeVacina() == null && vacinaVO.getIdVacina() == null) {			
			retorno = true;
			
		} else if (vacinaVO.getNomeVacina().toUpperCase().equals(vacina.getNomeVacina().toUpperCase())
				&& vacinaVO.getPaisOrigem().toUpperCase().equals(vacina.getPaisOrigem().toUpperCase())){
			System.out.println("Nome de Vacina "+vacina.getNomeVacina()+" j� existe no pa�s "+vacina.getPaisOrigem()+"!");
		}
		
		return retorno;
	}

	public List<VacinaVO> listarComFiltros(VacinaSeletor vacinaSeletor) {
		return vacinaDAO.listarComFiltros(vacinaSeletor);
	}





}
