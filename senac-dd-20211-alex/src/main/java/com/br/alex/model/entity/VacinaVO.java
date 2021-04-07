package com.br.alex.model.entity;

import java.time.LocalDate;

public class VacinaVO {

	private Integer idVacina;
	private String nomeVacina;
	private int idPessoaResponsavel;	
	private String paisOrigem;
	private int quantidadeDoses;
	private String estagioPesquisa;
	private LocalDate dataInicioPesquisa;
	private String faseVacina;
	private String situacao;

	
	public VacinaVO(String nomeVacina, int idPessoaResponsavel, String paisOrigem, int quantidadeDoses,
			String estagioPesquisa, LocalDate dataInicioPesquisa, String faseVacina, String situacao) {
		super();
		this.nomeVacina = nomeVacina;
		this.idPessoaResponsavel = idPessoaResponsavel;
		this.paisOrigem = paisOrigem;
		this.quantidadeDoses = quantidadeDoses;
		this.estagioPesquisa = estagioPesquisa;
		this.dataInicioPesquisa = dataInicioPesquisa;
		this.faseVacina = faseVacina;
		this.situacao = situacao;
	}
	
	public VacinaVO() {
 
	}

	public Integer getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(Integer idVacina) {
		this.idVacina = idVacina;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public int getidPessoaResponsavel() {
		return idPessoaResponsavel;
	}

	public void setidPessoaResponsavel(int idPessoaResponsavel) {
		this.idPessoaResponsavel = idPessoaResponsavel;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public int getQuantidadeDoses() {
		return quantidadeDoses;
	}

	public void setQuantidadeDoses(int quantidadeDoses) {
		this.quantidadeDoses = quantidadeDoses;
	}

	public String getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(String estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public LocalDate getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}

	public void setDataInicioPesquisa(LocalDate dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}

	public String getFaseVacina() {
		return faseVacina;
	}

	public void setFaseVacina(String faseVacina) {
		this.faseVacina = faseVacina;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
