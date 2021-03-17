package com.br.alex.model.entity;

import java.time.LocalDate;

public class VacinaVO {

	private Integer idVacina;
	private String nomeVacina;
	private String responsavelPesquisa;
	private String paisOrigem;
	private int quantidadeDoses;
	private String estagioPesquisa;
	private LocalDate dataInicioPesquisa;
	private String faseVacina;

	public VacinaVO(String nomeVacina, String responsavelPesquisa, String paisOrigem, int quantidadeDoses,
			String estagioPesquisa, LocalDate dataInicioPesquisa, String faseVacina) {
		super();
		this.nomeVacina = nomeVacina;
		this.responsavelPesquisa = responsavelPesquisa;
		this.paisOrigem = paisOrigem;
		this.quantidadeDoses = quantidadeDoses;
		this.estagioPesquisa = estagioPesquisa;
		this.dataInicioPesquisa = dataInicioPesquisa;
		this.faseVacina = faseVacina;
	}
	
	public VacinaVO() {
		super();
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

	public String getResponsavelPesquisa() {
		return responsavelPesquisa;
	}

	public void setResponsavelPesquisa(String responsavelPesquisa) {
		this.responsavelPesquisa = responsavelPesquisa;
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
	
	@Override
	public String toString() {
		return "VacinaVO [\nidVacina=" + idVacina + "\n, nomeVacina=" + nomeVacina + "\n, responsavelPesquisa="
				+ responsavelPesquisa + "\n, paisOrigem=" + paisOrigem + "\n, quantidadeDoses=" + quantidadeDoses
				+ "\n, estagioPesquisa=" + estagioPesquisa + "\n, dataInicioPesquisa=" + dataInicioPesquisa
				+ "\n, faseVacina=" + faseVacina + "\n]";
	}


}
