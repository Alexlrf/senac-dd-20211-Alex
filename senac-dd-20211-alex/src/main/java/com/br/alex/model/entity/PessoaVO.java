package com.br.alex.model.entity;

import java.time.LocalDate;

public class PessoaVO {
	
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cpf;
	private int reacao;
	
	public PessoaVO(String nome, LocalDate dataNascimento, String sexo, String cpf, int reacao) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.reacao = reacao;
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

	public int getReacao() {
		return reacao;
	}

	public void setReacao(int reacao) {
		this.reacao = reacao;
	}
		
}
