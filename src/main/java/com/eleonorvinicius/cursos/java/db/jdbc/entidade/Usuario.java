package com.eleonorvinicius.cursos.java.db.jdbc.entidade;

public class Usuario {

	private Long id;
	private String email;
	private String senha;

	public Usuario() {
	}
	
	public Usuario(String email) {
		this.email = email;
	}
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuario(Long id, String email, String senha) {
		this.id = id;
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void imprimir() {
		System.out.println();
		System.out.println("Usuario.id: " + this.id);
		System.out.println("Usuario.email: " + this.email);
		System.out.println("Usuario.senha: " + this.senha);
	}
}