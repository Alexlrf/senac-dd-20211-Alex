package com.br.alex.model.bo;

import java.util.List;

import com.br.alex.model.dao.VacinaDAO;
import com.br.alex.model.entity.VacinaVO;

public class VacinaBO {
	
	VacinaDAO vacinaDAO = new VacinaDAO();

	public List<VacinaVO> findAll() {		
		return vacinaDAO.findAll();
	}

	public int alterarStatusVacina(VacinaVO vacina) {		
		return vacinaDAO.alterarStatusVacina(vacina);
	}

	public String cadastraVacina(VacinaVO vacina) {
		String resultado = "";
		VacinaVO vacinaVO = new VacinaVO();
		VacinaDAO buscaVacinaDAO = new VacinaDAO();
				
		vacinaVO = buscaVacinaDAO.buscaPorPaisENomeVacina(vacina);
		
		if(vacinaVO.getNomeVacina() == null && vacinaVO.getIdVacina() == null) {			
			VacinaVO vacinaInsert = vacinaDAO.insert(vacina);
			
			if (vacinaInsert.getPaisOrigem() == null && vacinaInsert.getIdVacina()==null) {				
				resultado = "Vacina cadastrada com sucesso!";
			} 
			
		} else if (vacinaVO.getNomeVacina().toUpperCase().equals(vacina.getNomeVacina().toUpperCase())
				&& vacinaVO.getPaisOrigem().toUpperCase().equals(vacina.getPaisOrigem().toUpperCase())) {
			resultado = "Vacina j� cadastrada neste pa�s!";
			
		}  
		return resultado;
	}


}
