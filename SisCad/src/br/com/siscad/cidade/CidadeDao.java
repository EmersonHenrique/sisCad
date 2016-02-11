package br.com.siscad.cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CidadeDao {
	
	private Connection con;

	public CidadeDao(Connection con) {
		this.con = con;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void salvar(Cidade c) throws SQLException {

		String sql = "insert into cidade(cid_nome)values(?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			
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
	public void remover(Cidade c) {

		String sql = "delete from cidade where cid_id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, c.getId());
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
	public void atualizar(Cidade c) {
		String sql = "update cidade set cid_nome=?  where cid_id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getId());		
						
			
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
    
	public Cidade getListBuscaId(int cid_id) {		
		
		  Cidade c = new Cidade();
	      String sql = "select * from cidade where cid_id=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setInt(1, cid_id);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   
	     
	      c.setNome(rs.getString("cid_nome"));
	     	              
	      }catch(Exception ex){
	       
	      }
	      return c; 
	  } 

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	
public Cidade getListBuscaString(String cid_nome) {		
		
	      Cidade c = new Cidade();
	      String sql = "select * from cidade where cid_nome=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setString(1, cid_nome);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   
	     c.setId(rs.getInt("cid_id"));
	              
	      }catch(Exception ex){
	       
	      }
	      return c; 
	  } 

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public List<Cidade> getList() {

		try {
			String sql = "select * from cidade";

			PreparedStatement smt = con.prepareStatement(sql);
			ResultSet rs = smt.executeQuery();

			List<Cidade> minhaLista = new ArrayList<Cidade>();
			while (rs.next()) {
				Cidade c = new Cidade();

				c.setNome(rs.getString("cid_nome"));
				c.setId(rs.getInt("cid_id"));

				minhaLista.add(c);
				
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
	
