package com.br.alex.controller;

import java.util.List;

import com.br.alex.model.bo.VacinaBO;
import com.br.alex.model.entity.VacinaVO;

public class VacinaController {
	
	VacinaBO vacinaBO = new VacinaBO();

	public List<VacinaVO> findAll() {		
		return vacinaBO.findAll();
	}

	public boolean deletaVacinaPorPaisENome(VacinaVO vacina) {		
		return vacinaBO.deletaVacinaPorPaisENome(vacina);
	}

	public String cadastraVacina(VacinaVO vacina) {		
		return vacinaBO.cadastraVacina(vacina);
	}


}
