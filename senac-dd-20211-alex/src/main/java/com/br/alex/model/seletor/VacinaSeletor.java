package com.br.alex.model.seletor;

import java.time.LocalDate;

public class VacinaSeletor {
	
	//Atributos que servirão de filtros
		private int idVacina;
		private String nomeVacina;
		private String paisOrigem;
		private String situacao;
		
		//Filtragem de datas por período (início, fim)
		private LocalDate dataInicioCadastro;
		private LocalDate dataFimCadastro;

		//Atributos para possível paginação dos resultados (intervalo)
		private int limite;
		private int pagina;
		
		public VacinaSeletor() {
			//Default: traz os resultados sem limite e sem página
			this.limite = 0;
			this.pagina = -1;
		}
		
		/**
		 * Verifica se este seletor tem algum campo preenchido
		 *
		 * @return verdadeiro se existe algum campo de filtro preenchido
		 */
		public boolean temFiltro() {
			
			boolean temFiltro = false;
			
			if (this.idVacina > 0) {
				temFiltro = true;
			}
			if ((this.nomeVacina != null) && (this.nomeVacina.trim().length() > 0)) {
				temFiltro = true;
			}
			if ((this.paisOrigem != null) && (this.paisOrigem.trim().length() > 0)) {
				temFiltro = true;
			}
			if ((this.situacao != null) && (this.situacao.trim().length() > 0)) {
				temFiltro = true;
			}
			if (this.dataInicioCadastro != null) {
				temFiltro = true;
			}
			if (this.dataFimCadastro != null) {
				temFiltro = true;
			}
			return temFiltro;
		}
		
		/**
		 * Verifica se os campos de paginacao estao preenchidos
		 *
		 * @return verdadeiro se os campos limite e pagina estao preenchidos
		 */
		public boolean temPaginacao() {
			return ((this.limite > 0) && (this.pagina > -1));
		}

		/**
		 * Calcula deslocamento (offset) a partir da pagina e do limite
		 *
		 * @return offset
		 */
		public int getOffset() {
			return (this.limite * (this.pagina - 1));
		}

		//Getters e setters
		public int getidVacina() {
			return idVacina;
		}

		public void setidVacina(int idVacina) {
			this.idVacina = idVacina;
		}

		public String getNome() {
			return nomeVacina;
		}

		public void setNome(String nomeVacina) {
			this.nomeVacina = nomeVacina;
		}

		public String getPaisOrigem() {
			return paisOrigem;
		}

		public void setPaisOrigem(String paisOrigem) {
			this.paisOrigem = paisOrigem;
		}

		public String getSituacao() {
			return situacao;
		}

		public void setSituacao(String situacao) {
			this.situacao = situacao;
		}

		public LocalDate getDataInicioCadastro() {
			return dataInicioCadastro;
		}

		public void setDataInicioCadastro(LocalDate dataInicioCadastro) {
			this.dataInicioCadastro = dataInicioCadastro;
		}

		public LocalDate getDataFimCadastro() {
			return dataFimCadastro;
		}

		public void setDataFimCadastro(LocalDate dataFimCadastro) {
			this.dataFimCadastro = dataFimCadastro;
		}

		public int getLimite() {
			return limite;
		}

		public void setLimite(int limite) {
			this.limite = limite;
		}

		public int getPagina() {
			return pagina;
		}

		public void setPagina(int pagina) {
			this.pagina = pagina;
		}
		
}
