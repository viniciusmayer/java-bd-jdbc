package com.eleonorvinicius.cursos.java.db.jdbc.entidade;

public enum TipoConexaoEnum {

	POSTGRES("jdbc:postgresql://localhost:5432/eleonorvinicius", "eleonorvinicius", "viniciusmayer"),
	POSTGRES_TEST("jdbc:postgresql://localhost:5432/eleonorvinicius_test", "eleonorvinicius", "viniciusmayer");

	private TipoConexaoEnum(String url, String usuario, String senha) {
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
	}

	private String url;
	private String usuario;
	private String senha;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}