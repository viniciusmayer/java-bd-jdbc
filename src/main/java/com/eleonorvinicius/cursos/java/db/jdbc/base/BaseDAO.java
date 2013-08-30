package com.eleonorvinicius.cursos.java.db.jdbc.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.eleonorvinicius.cursos.java.db.jdbc.entidade.TipoConexaoEnum;
import com.eleonorvinicius.cursos.java.db.jdbc.exception.JavaBDJDBCException;

public abstract class BaseDAO {

	/*
	 * FIXME isso nao tah legal
	 */
	private TipoConexaoEnum tipoConexao;
	
	protected Connection getConnection() throws JavaBDJDBCException {
		if (this.tipoConexao == null){
			throw new JavaBDJDBCException("Tipo de conexao nao informado");
		}
		try {
			return DriverManager.getConnection(tipoConexao.getUrl(), tipoConexao.getUsuario(), tipoConexao.getSenha());
		} catch (SQLException e) {
			throw new JavaBDJDBCException(e);
		}
	}
	
	protected void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setTipoConexao(TipoConexaoEnum tipoConexao) {
		this.tipoConexao = tipoConexao;
	}
}