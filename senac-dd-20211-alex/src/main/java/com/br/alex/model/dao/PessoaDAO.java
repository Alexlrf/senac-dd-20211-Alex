package com.br.alex.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.br.alex.model.entity.PessoaVO;
import com.br.alex.repository.Conexao;

public class PessoaDAO {

	public PessoaVO insert(PessoaVO pessoaVO) throws SQLException {
		String sql = "INSERT INTO pessoa (nome, dataNascimento, sexo, cpf, categoria) values (?, ?, ?, ?, ?);";
		Connection conn = Conexao.getConnection();
		PreparedStatement stmt = Conexao.getPreparedStatementWithPk(conn, sql);

		try {
			// stmt.setInt(1, pessoaVO.getVacinacoes());
			stmt.setString(1, pessoaVO.getNome());
			stmt.setDate(2, java.sql.Date.valueOf(pessoaVO.getDataNascimento()));
			stmt.setString(3, pessoaVO.getSexo());
			stmt.setString(4, pessoaVO.getCpf());
			stmt.setString(5, pessoaVO.getCategoria());

			stmt.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir cadastro!");
			e.printStackTrace();
		}
		return pessoaVO;

	}

}
