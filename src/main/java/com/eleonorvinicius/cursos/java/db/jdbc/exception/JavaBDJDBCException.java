package com.eleonorvinicius.cursos.java.db.jdbc.exception;

public class JavaBDJDBCException extends Exception {

	private static final long serialVersionUID = 1136136145886220431L;

	public JavaBDJDBCException(String message) {
		super(message);
	}

	public JavaBDJDBCException(Throwable cause) {
		super(cause);
		cause.printStackTrace();
	}

	public JavaBDJDBCException(String message, Throwable cause) {
		super(message, cause);
		cause.printStackTrace();
	}
}
