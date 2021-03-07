package com.br.alex.model.entity;

import java.time.LocalDate;

import com.br.alex.repository.FaseVacina;

public class VacinaVO {
	
	private String pesquisador;
	private String paisOrigem;
	private FaseVacina estagioPesquisa;
	private LocalDate inicioPesquisa;
	private String fase;
		
	public VacinaVO(String pesquisador, String paisOrigem, FaseVacina estagioPesquisa, LocalDate inicioPesquisa,
			String fase) {
		super();
		this.pesquisador = pesquisador;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.inicioPesquisa = inicioPesquisa;
		this.fase = fase;
	}	
		
	public VacinaVO() {
		super();		
	}

	public String getPesquisador() {
		return pesquisador;
	}
	public void setPesquisador(String pesquisador) {
		this.pesquisador = pesquisador;
	}
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public FaseVacina getEstagioPesquisa() {
		return estagioPesquisa;
	}
	public void setEstagioPesquisa(FaseVacina estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}
	public LocalDate getInicioPesquisa() {
		return inicioPesquisa;
	}
	public void setInicioPesquisa(LocalDate inicioPesquisa) {
		this.inicioPesquisa = inicioPesquisa;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}	

}
