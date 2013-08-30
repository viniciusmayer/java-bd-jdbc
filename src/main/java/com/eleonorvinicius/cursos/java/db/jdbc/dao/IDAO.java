package com.eleonorvinicius.cursos.java.db.jdbc.dao;

import java.util.List;

import com.eleonorvinicius.cursos.java.db.jdbc.entidade.Usuario;
import com.eleonorvinicius.cursos.java.db.jdbc.exception.JavaBDJDBCException;

public interface IDAO {

	public void atualizar(Usuario usuario) throws JavaBDJDBCException;

	public int deletar() throws JavaBDJDBCException;
	
	public int deletar(Usuario usuario) throws JavaBDJDBCException;

	public int inserir(Usuario usuario) throws JavaBDJDBCException;

	public List<Usuario> listar(Usuario usuario) throws JavaBDJDBCException;

}