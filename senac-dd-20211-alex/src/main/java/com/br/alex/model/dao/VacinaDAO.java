package com.br.alex.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.br.alex.model.entity.VacinaVO;
import com.br.alex.model.seletor.VacinaSeletor;
import com.br.alex.repository.BaseDAO;
import com.br.alex.repository.Conexao;

public class VacinaDAO implements BaseDAO<VacinaVO> {

	@Override
	public VacinaVO insert(VacinaVO vacinaVO) {

		String sql = "INSERT INTO vacina(nome_vacina, id_pessoa_responsavel, pais_origem, "
				+ "quantidade_doses, estagio_pesquisa, inicio_pesquisa, fase_vacina, situacao)" + " values(?, ?, ?, ?, ?, ?, ?, ?);";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatementWithPk(conn, sql);) {

			stmt.setString(1, vacinaVO.getNomeVacina());
			stmt.setInt(2, vacinaVO.getidPessoaResponsavel());
			stmt.setString(3, vacinaVO.getPaisOrigem());
			stmt.setInt(4, vacinaVO.getQuantidadeDoses());
			stmt.setString(5, vacinaVO.getEstagioPesquisa());
			stmt.setDate(6, java.sql.Date.valueOf(vacinaVO.getDataInicioPesquisa()));
			stmt.setString(7, vacinaVO.getFaseVacina());
			stmt.setString(8, vacinaVO.getSituacao());
			stmt.executeUpdate();

			ResultSet returnId = stmt.getGeneratedKeys();
			if (returnId.next()) {
				vacinaVO.setIdVacina(returnId.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir cadastro!\n" + e.getMessage());
		}
		return vacinaVO;
	}

	@Override
	public boolean update(VacinaVO vacinaVO) {

		boolean updated = false;
		String sql = "UPDATE vacina SET nome_vacina = ?, id_pessoa_responsavel = ?, pais_origem = ?, quantidade_doses = ?"
				+ ", estagio_pesquisa = ?, inicio_pesquisa = ?, fase_vacina = ?, situacao = ?  WHERE id_vacina = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
			stmt.setString(1, vacinaVO.getNomeVacina());
			stmt.setInt(2, vacinaVO.getidPessoaResponsavel());
			stmt.setString(3, vacinaVO.getPaisOrigem());
			stmt.setInt(4, vacinaVO.getQuantidadeDoses());
			stmt.setString(5, vacinaVO.getEstagioPesquisa());
			stmt.setDate(6, java.sql.Date.valueOf(vacinaVO.getDataInicioPesquisa()));
			stmt.setString(7, vacinaVO.getFaseVacina());
			stmt.setString(8, vacinaVO.getSituacao());
			stmt.setInt(9, vacinaVO.getIdVacina());
			stmt.executeUpdate();

			updated = true;			

		} catch (SQLException e) {
			System.out.println("Erro ao tentar alterar!\n" + e.getMessage());
			updated = false;
		}
		return updated;
	}

	@Override
	public boolean delete(Integer idVacina) {

		boolean deleted = false;
		String sql = "DELETE FROM vacina WHERE id_vacina = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
			stmt.setInt(1, idVacina);
			stmt.executeUpdate();

			deleted = true;			

		} catch (SQLException e) {
			System.out.println("Erro ao tentar excluir!\n" + e.getMessage());
			deleted = false;
		}
		return deleted;
	}

	@Override
	public VacinaVO findById(Integer idVacina) {

		String sql = "SELECT * FROM vacina WHERE id_vacina = ?";
		VacinaVO vacina = new VacinaVO();

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
			stmt.setInt(1, idVacina);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				vacina = this.completeResultset(rs);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao realizar consulta por ID!\n" + e.getMessage());
		}
		return vacina;
	}

	@Override
	public List<VacinaVO> findAll() {

		String sql = "SELECT * FROM vacina;";
		List<VacinaVO> vacinas = new ArrayList<>();
		VacinaVO vacinaVO = new VacinaVO();

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				vacinaVO = this.completeResultset(rs);
				vacinas.add(vacinaVO);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao realizar consulta geral!\n" + e.getMessage());
		}
		return vacinas;
	}

	@Override
	public VacinaVO completeResultset(ResultSet rs) throws SQLException {

		VacinaVO vacinaVO = new VacinaVO();

		vacinaVO.setIdVacina(rs.getInt("id_vacina"));
		vacinaVO.setNomeVacina(rs.getString("nome_vacina"));
		vacinaVO.setidPessoaResponsavel(rs.getInt("id_pessoa_responsavel"));
		vacinaVO.setPaisOrigem(rs.getString("pais_origem"));
		vacinaVO.setDataInicioPesquisa(LocalDate.parse(rs.getString("inicio_pesquisa")));
		vacinaVO.setEstagioPesquisa(rs.getString("estagio_pesquisa"));
		vacinaVO.setQuantidadeDoses(rs.getInt("quantidade_doses"));
		vacinaVO.setFaseVacina(rs.getString("fase_vacina"));
		vacinaVO.setSituacao(rs.getString("situacao"));

		return vacinaVO;
	}

	public boolean deletaVacinaPorPaisENome(VacinaVO vacina) {
		boolean deleted = false;

		String sql = "DELETE FROM vacina WHERE nome_vacina = ? AND pais_origem = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
			stmt.setString(1, vacina.getNomeVacina());
			stmt.setString(2, vacina.getPaisOrigem());
			stmt.executeUpdate();

			deleted = true;

		} catch (SQLException e) {			
			System.out.println("N�o excluiu "+e.getMessage());
			deleted = false;
		}
		return deleted;
	}

	public VacinaVO buscaPorPaisENomeVacina(VacinaVO vacina) {

		String sql = "SELECT * FROM vacina WHERE nome_vacina = ? AND pais_origem = ? ;";
		VacinaVO vacinaVO = new VacinaVO();

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {

			stmt.setString(1, vacina.getNomeVacina());
			stmt.setString(2, vacina.getPaisOrigem());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				vacinaVO = this.completeResultset(rs);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar vacina por pa�s e nome " + e.getMessage());
		}
		return vacinaVO;
	}

	public int alterarStatusVacina(VacinaVO vacina) {
		int resultado = 0;
		String sql = "UPDATE vacina set situacao = ? WHERE nome_vacina = ? AND pais_origem = ?;";
		
		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)){
			stmt.setString(1, vacina.getSituacao());
			stmt.setString(2, vacina.getNomeVacina());
			stmt.setString(3, vacina.getPaisOrigem());						
			resultado = stmt.executeUpdate();
			
		} catch (SQLException e) {
			resultado = 0;
			System.out.println("Erro ao alterar status da vacina " + e.getMessage());
		} 		
		return resultado;
	}

	public boolean updateVacinaDTO(VacinaVO vacina) {
				
			boolean updated = false;
			String sql = "UPDATE vacina SET id_pessoa_responsavel = ?, quantidade_doses = ?"
					+ ", estagio_pesquisa = ?, inicio_pesquisa = ?, fase_vacina = ?, situacao = ?  WHERE id_vacina = ?;";

			try (Connection conn = Conexao.getConnection();
					PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
				stmt.setInt(1, vacina.getidPessoaResponsavel());
				stmt.setInt(2, vacina.getQuantidadeDoses());
				stmt.setString(3, vacina.getEstagioPesquisa());
				stmt.setDate(4, java.sql.Date.valueOf(vacina.getDataInicioPesquisa()));
				stmt.setString(5, vacina.getFaseVacina());
				stmt.setString(6, vacina.getSituacao());
				stmt.setInt(7, vacina.getIdVacina());
				stmt.executeUpdate();

				updated = true;			

			} catch (SQLException e) {
				System.out.println("Erro ao tentar alterar!\n" + e.getMessage());
				updated = false;
			}
			return updated;			
	}

	public List<VacinaVO> listarComFiltros(VacinaSeletor vacinaSeletor) {
		String sql = " SELECT * FROM VACINA p";

		if (vacinaSeletor.temFiltro()) {
			sql = criarFiltros(vacinaSeletor, sql);
		}

		if (vacinaSeletor.temPaginacao()) {
			sql += " LIMIT " + vacinaSeletor.getLimite() + " OFFSET " + vacinaSeletor.getOffset();
		}
		Connection conexao = Conexao.getConnection();
		PreparedStatement prepStmt = Conexao.getPreparedStatement(conexao, sql);
		List<VacinaVO> vacinas = new ArrayList<>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				VacinaVO p = completeResultset(result);
				vacinas.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar vacinas com filtros.\nCausa: " + e.getMessage());
		}
		return vacinas;

	}

	/**
	 * Cria os filtros de consulta (cláusulas WHERE/AND) de acordo com o que foi
	 * preeenchido no seletor.
	 * 
	 * ATENÇÃO: a ordem de criação dos filtros e posterior preenchimentos é
	 * relevante, logo este método é intimamente ligado ao método
	 * preencherParametrosConsulta
	 * 
	 * @param seletor o seletor de produtos
	 * @param jpql    a consulta que será preenchida
	 */
	private String criarFiltros(VacinaSeletor seletor, String sql) {

		// Tem pelo menos UM filtro
		sql += " WHERE ";
		boolean primeiro = true;

		if (seletor.getidVacina() > 0) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "p.id_vacina = " + seletor.getidVacina();
			primeiro = false;
		}

		if ((seletor.getNome() != null) && (seletor.getNome().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "p.nome_vacina LIKE '%" + seletor.getNome() + "%'";
			primeiro = false;
		}

		if ((seletor.getPaisOrigem() != null) && (seletor.getPaisOrigem().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "p.pais_origem = '" + seletor.getPaisOrigem() + "'";
			primeiro = false;
		}

		if ((seletor.getSituacao() != null) && (seletor.getSituacao().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "p.situacao = '" + seletor.getSituacao() + "'";
			primeiro = false;
		}

//		if ((seletor.getDataInicioCadastro() != null) && (seletor.getDataFimCadastro() != null)) {
//			// Regra composta, olha as 3 opções de preenchimento do período
//
//			// Todo o período preenchido (início E fim)
//			if (!primeiro) {
//				sql += " AND ";
//			}
//			sql += "p.dataCadastro BETWEEN" + seletor.getDataInicioCadastro() + " AND " + seletor.getDataFimCadastro();
//			primeiro = false;
//		} else if (seletor.getDataInicioCadastro() != null) {
//			// só o início
//			if (!primeiro) {
//				sql += " AND ";
//			}
//			sql += "p.dataCadastro >= " + seletor.getDataInicioCadastro();
//			primeiro = false;
//		} else if (seletor.getDataFimCadastro() != null) {
//			// só o fim
//			if (!primeiro) {
//				sql += " AND ";
//			}
//			sql += "p.dataCadastro <= " + seletor.getDataFimCadastro();
//			primeiro = false;
//		}

		return sql;
	}

}
