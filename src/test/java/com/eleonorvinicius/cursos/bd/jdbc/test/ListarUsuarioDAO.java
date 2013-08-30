package com.eleonorvinicius.cursos.bd.jdbc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eleonorvinicius.cursos.java.db.jdbc.dao.UsuarioDAO;
import com.eleonorvinicius.cursos.java.db.jdbc.entidade.TipoConexaoEnum;
import com.eleonorvinicius.cursos.java.db.jdbc.entidade.Usuario;
import com.eleonorvinicius.cursos.java.db.jdbc.exception.JavaBDJDBCException;

public class ListarUsuarioDAO {

	private UsuarioDAO usuarioDAO = null;
	
	@Before
	public void setUp() throws Exception {
		this.usuarioDAO = UsuarioDAO.getInstance();
		this.usuarioDAO.setTipoConexao(TipoConexaoEnum.POSTGRES_TEST);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListarVazio() throws JavaBDJDBCException {
		List<Usuario> usuarios = this.usuarioDAO.listar(null);
		Assert.assertEquals(new ArrayList<Usuario>(), usuarios);
	}
}