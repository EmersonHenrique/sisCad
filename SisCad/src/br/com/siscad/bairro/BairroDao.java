package br.com.siscad.bairro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BairroDao {
   
	private Connection con;

	public BairroDao(Connection con) {
		this.con = con;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void salvar(Bairro b) throws SQLException {

		String sql = "insert into bairro(bai_nome)values(?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, b.getNome());
			
			stmt.execute();
			stmt.close();			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
		    con.close();
			System.out.println("conexao fechada");
		}

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void remover(Bairro b) {

		String sql = "delete from bairro where bai_id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, b.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void atualizar(Bairro b) {
		String sql = "update bairro set bai_nome=?  where bai_id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, b.getNome());
			stmt.setInt(2, b.getId());		
						
			
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
    
	public Bairro getListBuscaId(int bai_id) {		
		
		  Bairro b = new Bairro();
	      String sql = "select * from bairro where bai_id=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setInt(1, bai_id);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   
	     
	      b.setNome(rs.getString("bai_nome"));
	     	              
	      }catch(Exception ex){
	       
	      }
	      return b; 
	  } 

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	
public Bairro getListBuscaString(String cid_nome) {		
		
	      Bairro b = new Bairro();
	      String sql = "select * from bairro where bai_nome=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setString(1, cid_nome);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   
	     b.setId(rs.getInt("bai_id"));
	              
	      }catch(Exception ex){
	       
	      }
	      return b; 
	  } 

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public List<Bairro> getList() {

		try {
			String sql = "select * from bairro";

			PreparedStatement smt = con.prepareStatement(sql);
			ResultSet rs = smt.executeQuery();

			List<Bairro> minhaLista = new ArrayList<Bairro>();
			while (rs.next()) {
				Bairro b = new Bairro();

				b.setNome(rs.getString("bai_nome"));
				b.setId(rs.getInt("bai_id"));

				minhaLista.add(b);
				
				Collections.reverse(minhaLista);
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
			
	
}
