package com.eleonorvinicius.cursos.java.db.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eleonorvinicius.cursos.java.db.jdbc.base.BaseDAO;
import com.eleonorvinicius.cursos.java.db.jdbc.entidade.Usuario;
import com.eleonorvinicius.cursos.java.db.jdbc.exception.JavaBDJDBCException;

public class UsuarioDAO extends BaseDAO implements IDAO {
	
	private static UsuarioDAO usuarioDAO;
		
	private UsuarioDAO() {}
	
	public static UsuarioDAO getInstance(){
		if (UsuarioDAO.usuarioDAO == null){
			UsuarioDAO.usuarioDAO = new UsuarioDAO();
		}
		return UsuarioDAO.usuarioDAO;
	}
	
	public void atualizar(Usuario usuario) throws JavaBDJDBCException{
		if (usuario == null){
			throw new JavaBDJDBCException("Usuario nulo.");
		}
		if (usuario.getId() == null){
			throw new JavaBDJDBCException("Usuario com id nulo.");
		}
		if (usuario.getEmail() == null){
			throw new JavaBDJDBCException("Usuario com email nulo.");
		}
		if (usuario.getSenha() == null){
			throw new JavaBDJDBCException("Usuario com senha nula.");
		}
		Connection connection = super.getConnection();
		String delete = "update usuario set email = ?, senha = ? where id = ?;";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(delete);
			prepareStatement.setString(1, usuario.getEmail());
			prepareStatement.setString(2, usuario.getSenha());
			prepareStatement.setLong(3, usuario.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			throw new JavaBDJDBCException(e);
		}
	}
	
	public int deletar() throws JavaBDJDBCException {
		Connection connection = super.getConnection();
		String delete = "delete from usuario;";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(delete);
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			throw new JavaBDJDBCException(e);
		}
	}

	public int deletar(Usuario usuario) throws JavaBDJDBCException{
		if (usuario == null){
			throw new JavaBDJDBCException("Usuario nulo.");
		}
		if (usuario.getId() == null){
			throw new JavaBDJDBCException("Usuario com id nulo.");
		}
		Connection connection = super.getConnection();
		String delete = "delete from usuario where id = ?;";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(delete);
			prepareStatement.setLong(1, usuario.getId());
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			throw new JavaBDJDBCException(e);
		}
	}
	
	public int inserir(Usuario usuario) throws JavaBDJDBCException{
		if (usuario == null){
			throw new JavaBDJDBCException("Usuario nulo.");
		}
		if (usuario.getEmail() == null){
			throw new JavaBDJDBCException("Usuario com email nulo.");
		}
		if (usuario.getSenha() == null){
			throw new JavaBDJDBCException("Usuario com senha nula.");
		}
		Connection connection = super.getConnection();
		String insert = "insert into usuario (email, senha) values (?, ?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(insert);
			prepareStatement.setString(1, usuario.getEmail());
			prepareStatement.setString(2, usuario.getSenha());
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			throw new JavaBDJDBCException(e);
		}
	}
	
	public List<Usuario> listar(Usuario usuario) throws JavaBDJDBCException {
		Connection connection = super.getConnection();
		StringBuilder select = new StringBuilder("select id, email, senha from usuario where 1=1");
		try {
			if (usuario != null){
				if (usuario.getId() != null){
					select.append(" and id = " + usuario.getId());
				}
				if (usuario.getEmail() != null){
					select.append(" and upper(email) like upper('%" + usuario.getEmail() + "%')");
				}
			}
			PreparedStatement prepareStatement = connection.prepareStatement(select.toString());
			ResultSet resultSet = prepareStatement.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String email = resultSet.getString("email");
				String senha = resultSet.getString("senha");
				usuarios.add(new Usuario(id, email, senha));
			}
			return usuarios;
		} catch (SQLException e) {
			throw new JavaBDJDBCException(e);
		}
	}
}