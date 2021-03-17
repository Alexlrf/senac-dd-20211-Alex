package com.br.alex.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.alex.model.entity.VacinaVO;
import com.br.alex.repository.Conexao;

public class VacinaDAO {

	public VacinaVO insert(VacinaVO vacinaVO) {

		String sql = "INSERT INTO vacina(nome_vacina, responsavel_pesquisa, pais_origem, "
				+ "quantidade_doses, estagio_pesquisa, inicio_pesquisa, fase_vacina)" + " values(?, ?, ?, ?, ?, ?, ?);";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatementWithPk(conn, sql);) {

			stmt.setString(1, vacinaVO.getNomeVacina());
			stmt.setString(2, vacinaVO.getResponsavelPesquisa());
			stmt.setString(3, vacinaVO.getPaisOrigem());
			stmt.setInt(4, vacinaVO.getQuantidadeDoses());
			stmt.setString(5, vacinaVO.getEstagioPesquisa());
			stmt.setDate(6, java.sql.Date.valueOf(vacinaVO.getDataInicioPesquisa()));
			stmt.setString(7, vacinaVO.getFaseVacina());
			stmt.executeUpdate();

			ResultSet returnId = stmt.getGeneratedKeys();
			if (returnId.next()) {
				vacinaVO.setIdVacina(returnId.getInt(1));

			}

			JOptionPane.showMessageDialog(null, "Inclusão efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir cadastro!\n" + e.getMessage());
		}
		return vacinaVO;
	}

	public boolean update(VacinaVO vacinaVO) {

		boolean updated = false;
		String sql = "UPDATE vacina SET nome_vacina = ?, responsavel_pesquisa = ?, pais_origem = ?, quantidade_doses = ?"
				+ ", estagio_pesquisa = ?, inicio_pesquisa = ?, fase_vacina = ? WHERE id_vacina = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
			stmt.setString(1, vacinaVO.getNomeVacina());
			stmt.setString(2, vacinaVO.getResponsavelPesquisa());
			stmt.setString(3, vacinaVO.getPaisOrigem());
			stmt.setInt(4, vacinaVO.getQuantidadeDoses());
			stmt.setString(5, vacinaVO.getEstagioPesquisa());
			stmt.setDate(6, java.sql.Date.valueOf(vacinaVO.getDataInicioPesquisa()));
			stmt.setString(7, vacinaVO.getFaseVacina());
			stmt.setInt(8, vacinaVO.getIdVacina());
			stmt.executeUpdate();

			updated = true;
			JOptionPane.showMessageDialog(null, "Alteração efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar alterar!\n" + e.getMessage());
			updated = false;
		}
		return updated;

	}

	public boolean delete(Integer idVacina) {

		boolean deleted = false;
		String sql = "DELETE FROM vacina WHERE id_vacina = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
			stmt.setInt(1, idVacina);
			stmt.executeUpdate();

			deleted = true;
			JOptionPane.showMessageDialog(null, "Exclusão efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!\n" + e.getMessage());
			deleted = false;
		}
		return deleted;
	}

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
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta por ID!\n" + e.getMessage());
		}
		return vacina;
	}

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
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta geral!\n" + e.getMessage());
		}

		return vacinas;

	}

	private VacinaVO completeResultset(ResultSet rs) throws SQLException {

		VacinaVO vacinaVO = new VacinaVO();

		vacinaVO.setIdVacina(rs.getInt("id_vacina"));
		vacinaVO.setNomeVacina(rs.getString("nome_vacina"));
		vacinaVO.setResponsavelPesquisa(rs.getString("responsavel_pesquisa"));
		vacinaVO.setPaisOrigem(rs.getString("pais_origem"));
		vacinaVO.setDataInicioPesquisa(LocalDate.parse(rs.getString("inicio_pesquisa")));
		vacinaVO.setEstagioPesquisa(rs.getString("estagio_pesquisa"));
		vacinaVO.setQuantidadeDoses(rs.getInt("quantidade_doses"));
		vacinaVO.setFaseVacina(rs.getString("fase_vacina"));

		return vacinaVO;
	}

}
