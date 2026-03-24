package com.crud.biblioteca.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {
	private static final String URL	=	
			"jdbc:postgresql://localhost:5432/Biblioteca";
		private static final String USUARIO = "postgres";
		private static final String SENHA = "postgres";
	
	public Conexao() {
		super();
	}

	public static Connection getConnection()
			throws SQLException {
		return DriverManager.getConnection
				(URL, USUARIO, SENHA);
	}
}
