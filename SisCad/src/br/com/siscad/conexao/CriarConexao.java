package br.com.siscad.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
	
	public static Connection getConexao(){
		Connection con = null;
		try {
		String url="jdbc:mysql://localhost/sisCadDb"; 
		String usuario = "root";
		String senha = "123";
		
		
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro de SQL. Erro: " + e.getMessage());
		}
		return con;
	}
}
