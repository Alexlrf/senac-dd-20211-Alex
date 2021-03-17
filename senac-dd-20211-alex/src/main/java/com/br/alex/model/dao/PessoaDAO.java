package com.br.alex.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.br.alex.model.entity.PessoaVO;
import com.br.alex.repository.Conexao;

public class PessoaDAO {

	public PessoaVO insert(PessoaVO pessoaVO) throws SQLException {

		String sql = "INSERT INTO pessoa (nome, dataNascimento, sexo, cpf, categoria) values (?, ?, ?, ?, ?);";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatementWithPk(conn, sql);) {
			// stmt.setInt(1, pessoaVO.getVacinacoes());
			stmt.setString(1, pessoaVO.getNome());
			stmt.setDate(2, java.sql.Date.valueOf(pessoaVO.getDataNascimento()));
			stmt.setString(3, pessoaVO.getSexo());
			stmt.setString(4, pessoaVO.getCpf());
			stmt.setString(5, pessoaVO.getCategoria());
			stmt.executeUpdate();

			ResultSet returnId = stmt.getGeneratedKeys();
			if (returnId.next()) {
				pessoaVO.setIdPessoa(returnId.getInt(1));
			}

			JOptionPane.showMessageDialog(null, "Inclusão efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir cadastro!\n" + e.getMessage());

		}
		return pessoaVO;
	}

	public boolean update(PessoaVO pessoaVO) {

		boolean updated = false;
		String sql = "UPDATE pessoa SET nome = ?, dataNascimento = ?, sexo = ?, cpf = ?, categoria = ? WHERE id_pessoa = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatementWithPk(conn, sql);) {
			// stmt.setInt(1, pessoaVO.getVacinacoes());
			stmt.setString(1, pessoaVO.getNome());
			stmt.setDate(2, java.sql.Date.valueOf(pessoaVO.getDataNascimento()));
			stmt.setString(3, pessoaVO.getSexo());
			stmt.setString(4, pessoaVO.getCpf());
			stmt.setString(5, pessoaVO.getCategoria());
			stmt.setInt(6, pessoaVO.getIdPessoa());
			stmt.executeUpdate();

			updated = true;
			JOptionPane.showMessageDialog(null, "Alteração efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar alterar!\n" + e.getMessage());
			updated = false;
		}
		return updated;
	}

	public boolean delete(Integer idPessoa) {

		boolean deleted = false;
		String sql = "DELETE FROM pessoa WHERE id_pessoa = ?;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql);) {
			stmt.setInt(1, idPessoa);
			stmt.executeUpdate();

			deleted = true;
			JOptionPane.showMessageDialog(null, "Exclusão efetuada!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!\n" + e.getMessage());
			deleted = false;
		}
		return deleted;
	}

	public PessoaVO finfById(Integer idPessoa) {

		PessoaVO pessoa = null;
		String sql = "SELECT * FROM pessoa WHERE id_pessoa = ?; ";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql);) {
			stmt.setInt(1, idPessoa);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				pessoa = this.completeResultset(rs);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta por ID!\n" + e.getMessage());
		}
		return pessoa;
	}

	public List<PessoaVO> findAll() {

		List<PessoaVO> lista = new ArrayList<>();
		String sql = "SELECT * FROM pessoa;";
		PessoaVO pessoaVO = new PessoaVO();

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				pessoaVO = this.completeResultset(rs);
				lista.add(pessoaVO);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta geral!\n" + e.getMessage());
		}
		return lista;
	}

	private PessoaVO completeResultset(ResultSet rs) throws SQLException {

		PessoaVO pessoa = new PessoaVO();
		pessoa.setIdPessoa(rs.getInt("id_pessoa"));
		pessoa.setNome(rs.getString("nome"));
		pessoa.setCpf(rs.getString("cpf"));
		pessoa.setSexo(rs.getString("sexo"));
		pessoa.setDataNascimento(LocalDate.parse(rs.getString("dataNascimento")));
		// pessoa.setVacinacoes(rs.getArray(""));
		pessoa.setCategoria(rs.getString("categoria"));

		return pessoa;
	}

}
