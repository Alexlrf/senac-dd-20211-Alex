package com.br.alex.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.alex.model.entity.AplicacaoVacinaVO;
import com.br.alex.repository.BaseDAO;
import com.br.alex.repository.Conexao;

public class AplicacaoVacinaDAO implements BaseDAO<AplicacaoVacinaVO> {

	@Override
	public AplicacaoVacinaVO insert(AplicacaoVacinaVO aplicacaoVacinaVO) {

		String sql = "INSERT INTO aplicacao_vacina(id_vacina, id_pessoa, reacao, data_aplicacao) values(?, ?, ?, ?);";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatementWithPk(conn, sql);) {

			stmt.setInt(1, aplicacaoVacinaVO.getIdVacina());
			stmt.setInt(2, aplicacaoVacinaVO.getidPessoa());
			stmt.setInt(3, aplicacaoVacinaVO.getReacao());
			stmt.setDate(4, java.sql.Date.valueOf(aplicacaoVacinaVO.getDataAplicacao()));

			stmt.executeUpdate();

			ResultSet returnId = stmt.getGeneratedKeys();

			if (returnId.next()) {
				aplicacaoVacinaVO.setIdAplicacaoVacina(returnId.getInt(1));

			}
			JOptionPane.showMessageDialog(null, "Inclus�o efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir cadastro!\n" + e.getMessage());
		}
		return aplicacaoVacinaVO;
	}

	@Override
	public boolean update(AplicacaoVacinaVO aplicacaoVacinaVO) {

		boolean updated = false;
		String sql = "UPDATE aplicacao_vacina SET id_vacina = ?, id_pessoa = ?, reacao = ?, data_aplicacao = ?"
				+ " WHERE id_aplicacao_vacina = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
			stmt.setInt(1, aplicacaoVacinaVO.getIdVacina());
			stmt.setInt(2, aplicacaoVacinaVO.getidPessoa());
			stmt.setInt(3, aplicacaoVacinaVO.getReacao());
			stmt.setDate(4, java.sql.Date.valueOf(aplicacaoVacinaVO.getDataAplicacao()));
			stmt.setInt(5, aplicacaoVacinaVO.getIdAplicacaoVacina());
			stmt.executeUpdate();

			updated = true;
			JOptionPane.showMessageDialog(null, "Altera��o efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar alterar!\n" + e.getMessage());
			updated = false;
		}
		return updated;

	}

	@Override
	public boolean delete(Integer idAplicacaoVacina) {

		boolean deleted = false;
		String sql = "DELETE FROM aplicacao_vacina WHERE id_aplicacao_vacina = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {
			stmt.setInt(1, idAplicacaoVacina);
			stmt.executeUpdate();

			deleted = true;
			JOptionPane.showMessageDialog(null, "Exclus�o efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!\n" + e.getMessage());
			deleted = false;
		}
		return deleted;
	}

	@Override
	public AplicacaoVacinaVO findById(Integer idaplicacaoVacinaVO) {

		AplicacaoVacinaVO aplicacao = new AplicacaoVacinaVO();

		String sql = "SELECT * FROM aplicacao_vacina WHERE id_aplicacao_vacina = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {

			stmt.setInt(1, idaplicacaoVacinaVO);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				aplicacao = this.completeResultset(rs);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta por ID!\n" + e.getMessage());
		}
		return aplicacao;

	}

	@Override
	public List<AplicacaoVacinaVO> findAll() {

		String sql = "SELECT * FROM aplicacao_vacina;";
		List<AplicacaoVacinaVO> aplicacoes = new ArrayList<>();
		AplicacaoVacinaVO aplicacaoVacina = new AplicacaoVacinaVO();

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				aplicacaoVacina = this.completeResultset(rs);
				aplicacoes.add(aplicacaoVacina);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta geral!\n" + e.getMessage());
		}
		return aplicacoes;

	}

	@Override
	public AplicacaoVacinaVO completeResultset(ResultSet rs) throws SQLException {

		AplicacaoVacinaVO aplicacaoVacinaVO = new AplicacaoVacinaVO();
		aplicacaoVacinaVO.setIdAplicacaoVacina(rs.getInt("id_aplicacao_vacina"));
		aplicacaoVacinaVO.setIdVacina(rs.getInt("id_vacina"));
		aplicacaoVacinaVO.setidPessoa(rs.getInt("id_pessoa"));
		aplicacaoVacinaVO.setReacao(rs.getInt("reacao"));
		aplicacaoVacinaVO.setDataAplicacao(LocalDate.parse(rs.getString("data_aplicacao")));

		return aplicacaoVacinaVO;
	}

	public List<AplicacaoVacinaVO> findByPessoa(Integer idPessoa) {

		List<AplicacaoVacinaVO> aplicacoes = new ArrayList<>();
		AplicacaoVacinaVO aplicacaoVacina = new AplicacaoVacinaVO();
		String sql = "SELECT * FROM aplicacao_vacina WHERE id_pessoa = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql)) {

			stmt.setInt(1, idPessoa);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				aplicacaoVacina = this.completeResultset(rs);
				aplicacoes.add(aplicacaoVacina);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta por pessoa!\n" + e.getMessage());
		}

		return aplicacoes;

	}

}
