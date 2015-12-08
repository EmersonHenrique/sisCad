package br.com.siscad.cliente;

import java.sql.*;

public class ClienteDao {
	
	private Connection con; 
	
	public ClienteDao(Connection con){
		this.con = con;
	}

	public void salvar(Cliente c) throws SQLException {
		
		String sql = "insert into cliente(nome)values(?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
				con.close();
				System.out.println("conexao fechada");
				System.out.println("conexao fechada");
			
		}
		
	}
    
}
