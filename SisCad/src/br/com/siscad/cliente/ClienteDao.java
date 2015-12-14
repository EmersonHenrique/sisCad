package br.com.siscad.cliente;

import java.sql.*;
import java.util.*;

public class ClienteDao {

	private Connection con;

	public ClienteDao(Connection con) {
		this.con = con;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void salvar(Cliente c) throws SQLException {

		String sql = "insert into cliente(nome)values(?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());

			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			System.out.println("conexao fechada");
		}

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void remover(Cliente c) {

		String sql = "delete from cliente where id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, c.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void atualizar(Cliente c) {
		String sql = "update cliente set nome = ? where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public List<Cliente> getList(int pagina) {
		if (pagina==1)
			pagina = 0;
		else
			pagina=--pagina;
		
		pagina = pagina * 10;
		
		String sql = "select * from cliente  LIMIT 10 offset "+pagina+";";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Cliente> minhaLista = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));

				minhaLista.add(c);
			}

			stmt.close();
			rs.close();
			return minhaLista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
    public int contaRegistro(){
    	ResultSet rs = null;
    	PreparedStatement stmt = null;
    	String sql = "select count(*) AS contaRegistro from cliente";
    	try {
    	    stmt = con.prepareStatement(sql);    	
		    rs = stmt.executeQuery();
			rs.next();
			int registros = Integer.parseInt(rs.getString("contaRegistro"));			
			
			int resto = registros%10;	
			if(resto != 0)	
			return (registros / 10) + 1;
			else			
			return registros / 10;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
    	return 0;
    }
	public List<Cliente> getListBuscaId(int id) {

		String sql = "select * from cliente where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			List<Cliente> minhaLista = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));

				minhaLista.add(c);
			}

			stmt.close();
			rs.close();
			return minhaLista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------

	public List<Cliente> getList(String nome) {

		try {
			String sql = "select * from cliente where nome like ?";

			PreparedStatement smt = con.prepareStatement(sql);

			smt.setString(1, nome);

			ResultSet rs = smt.executeQuery();

			List<Cliente> minhaLista = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();

				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));

				minhaLista.add(c);
			}

			smt.close();
			rs.close();

			return minhaLista;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------

	public Cliente consulta(int id){
	      
	      Cliente c = new Cliente();
	      String sql = "select * from cliente where id=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setInt(1, id);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   
	     
	      c.setId(rs.getInt("id"));
	      c.setNome(rs.getString("nome"));
	              
	      }catch(Exception e){
	       
	      }
	      return c; 
	  } 

}
