package com.br.alex.model.entity;

import java.time.LocalDate;
import java.util.List;

public class PessoaVO {

	private int idPessoa;
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cpf;
	private String categoria;
	private List<AplicacaoVacinaVO> vacinacoes;

	public PessoaVO(String nome, LocalDate dataNascimento, String sexo, String cpf, String categoria,
			List<AplicacaoVacinaVO> vacinacoes) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.categoria = categoria;
		this.vacinacoes = vacinacoes;
	}

	public PessoaVO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<AplicacaoVacinaVO> getVacinacoes() {
		return vacinacoes;
	}

	public void setVacinacoes(List<AplicacaoVacinaVO> vacinacoes) {
		this.vacinacoes = vacinacoes;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		return "PessoaVO [\nidPessoa= " + idPessoa + "\n, nome= " + nome + "\n, dataNascimento= " + dataNascimento
				+ "\n, sexo= " + sexo + "\n, cpf= " + cpf + "\n, categoria= " + categoria + "\n, vacinacoes= "
				+ vacinacoes + "\n]";
	}
}
