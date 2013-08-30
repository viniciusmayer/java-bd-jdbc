package com.eleonorvinicius.cursos.java.db.jdbc.main;

import java.util.ArrayList;
import java.util.List;

import com.eleonorvinicius.cursos.java.db.jdbc.dao.UsuarioDAO;
import com.eleonorvinicius.cursos.java.db.jdbc.entidade.TipoConexaoEnum;
import com.eleonorvinicius.cursos.java.db.jdbc.entidade.Usuario;
import com.eleonorvinicius.cursos.java.db.jdbc.exception.JavaBDJDBCException;

public class Main {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		usuarioDAO.setTipoConexao(TipoConexaoEnum.POSTGRES);
		try {
			usuarioDAO.deletar();
		} catch (JavaBDJDBCException e) {
			System.err.println("=> ERRO: " + e.getMessage());
			return;
		}
		listar(usuarioDAO);
		inserir(usuarioDAO);
		listar(usuarioDAO);
		atualizar(usuarioDAO);
		listar(usuarioDAO);
	}
	
	private static void atualizar(UsuarioDAO usuarioDAO) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			usuarios = usuarioDAO.listar(new Usuario("primeiro@usuario"));
		} catch (JavaBDJDBCException e) {
			System.err.println("=> ERRO: " + e.getMessage());
			return;
		}
		if (usuarios.isEmpty()){
			System.out.println();
			System.out.println("Nenhum usuario encontrado.");
			return;
		}
		if (usuarios.size() > 1){
			System.out.println();
			System.out.println("Mais de um usuario encontrado.");
			return;
		}
		Usuario usuario = usuarios.get(0);
		usuario.setEmail("segundo@usuario");
		usuario.setSenha("senhaSegundoUsuario");
		try {
			usuarioDAO.atualizar(usuario);
			System.out.println();
			System.out.println("=> Usuario atualizado com sucesso");
		} catch (JavaBDJDBCException e) {
			System.err.println("=> ERRO: " + e.getMessage());
		}
	}

	private static void inserir(UsuarioDAO usuarioDAO) {
		System.out.println();
		System.out.println("=> Inserir usuario");
		try {
			int inserir = usuarioDAO.inserir(new Usuario("primeiro@usuario", "senhaPrimeiroUsuario"));
			System.out.println();
			System.out.println("=> "+inserir + " usuarios inseridos com sucesso");
		} catch (JavaBDJDBCException e) {
			System.err.println("=> ERRO: " + e.getMessage());
			return;
		}
	}

	private static void listar(UsuarioDAO usuarioDAO) {
		System.out.println();
		System.out.println("=> Listar usuarios");
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			usuarios = usuarioDAO.listar(null);
		} catch (JavaBDJDBCException e) {
			System.err.println("=> ERRO: " + e.getMessage());
			return;
		}
		if (usuarios.isEmpty()){
			System.out.println();
			System.out.println("Nenhum usuario encontrado.");
			return;
		}
		for (Usuario usuario : usuarios) {
			usuario.imprimir();
		}
	}
}