package com.br.alex.model.entity;

import java.time.LocalDate;

public class AplicacaoVacinaVO {

	private Integer idAplicacaoVacina;
	private Integer idVacina;
	private LocalDate dataAplicacao;
	private Integer idPessoa;
	private Integer reacao;

	public AplicacaoVacinaVO(Integer idVacina, LocalDate dataAplicacao, Integer idPessoa, Integer reacao) {
		super();
		this.idVacina = idVacina;
		this.dataAplicacao = dataAplicacao;
		this.idPessoa = idPessoa;
		this.reacao = reacao;
	}

	public AplicacaoVacinaVO() {
		super();
	}

	public Integer getIdAplicacaoVacina() {
		return idAplicacaoVacina;
	}

	public void setIdAplicacaoVacina(Integer idAplicacaoVacina) {
		this.idAplicacaoVacina = idAplicacaoVacina;
	}

	public Integer getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(Integer idVacina) {
		this.idVacina = idVacina;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public Integer getidPessoa() {
		return idPessoa;
	}

	public void setidPessoa(Integer iPessoa) {
		this.idPessoa = iPessoa;
	}

	public Integer getReacao() {
		return reacao;
	}

	public void setReacao(Integer reacao) {
		this.reacao = reacao;
	}

	@Override
	public String toString() {
		return "AplicacaoVacinaVO [\nidAplicacaoVacina=" + idAplicacaoVacina + "\n, idVacina=" + idVacina
				+ "\n, dataAplicacao=" + dataAplicacao + "\n, idPessoa=" + idPessoa + "\n, reacao=" + reacao
				+ "\n]";
	}
	
	

}
