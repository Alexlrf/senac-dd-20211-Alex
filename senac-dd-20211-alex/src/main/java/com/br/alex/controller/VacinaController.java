package com.br.alex.controller;

import java.util.List;

import com.br.alex.model.bo.VacinaBO;
import com.br.alex.model.entity.VacinaVO;

public class VacinaController {
	
	VacinaBO vacinaBO = new VacinaBO();

	public List<VacinaVO> findAll() {		
		return vacinaBO.findAll();
	}

	public int alterarStatusVacina(VacinaVO vacina) {		
		return vacinaBO.alterarStatusVacina(vacina);
	}

	public String cadastraVacina(VacinaVO vacina) {		
		return vacinaBO.cadastraVacina(vacina);
	}

	public String alterarVacina(VacinaVO vacina) {		
		return vacinaBO.alterarVacina(vacina);
	}


}
