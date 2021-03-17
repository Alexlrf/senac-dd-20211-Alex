package com.br.alex.model.entity;

import java.time.LocalDate;

public class AplicacaoVacinaVO {

	private Integer idAplicacaoVacina;
	private VacinaVO vacina;
	private LocalDate dataAplicacao;
	private PessoaVO pessoaVacinada;
	private String reacao;

	public AplicacaoVacinaVO(VacinaVO vacina, LocalDate dataAplicacao, PessoaVO pessoaVacinada, String reacao) {
		super();
		this.vacina = vacina;
		this.dataAplicacao = dataAplicacao;
		this.pessoaVacinada = pessoaVacinada;
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

	public VacinaVO getVacina() {
		return vacina;
	}

	public void setVacina(VacinaVO vacina) {
		this.vacina = vacina;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public PessoaVO getPessoaVacinada() {
		return pessoaVacinada;
	}

	public void setPessoaVacinada(PessoaVO pessoaVacinada) {
		this.pessoaVacinada = pessoaVacinada;
	}

	public String getReacao() {
		return reacao;
	}

	public void setReacao(String reacao) {
		this.reacao = reacao;
	}

}
