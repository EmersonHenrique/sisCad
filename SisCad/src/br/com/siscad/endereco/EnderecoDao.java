package br.com.siscad.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnderecoDao {
	private Connection con;

	public EnderecoDao(Connection con) {
		this.con = con;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void salvar(Endereco e) throws SQLException {

		String sql = "insert into endereco(end_logradouro,end_cep)values(?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getLogradouro());
			stmt.setString(2, e.getCep());

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
	public void remover(Endereco e) {

		String sql = "delete from endereco where end_id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, e.getId());
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
	public void atualizar(Endereco e) {
		String sql = "update endereco set end_logradouro=?,end_cep=?  where end_id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, e.getLogradouro());
			stmt.setString(2, e.getCep());		
			stmt.setInt(3, e.getId());			
			
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
	public List<Endereco> getList(int pagina) {
		if (pagina==1)
			pagina = 0;
		else
			pagina=--pagina;
		
		pagina = pagina * 10;
		
		String sql = "select * from Endereco  LIMIT 10 offset "+pagina+";";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Endereco> minhaLista = new ArrayList<Endereco>();
			while (rs.next()) {
				Endereco e = new Endereco();
				e.setId(rs.getInt("end_id"));
				e.setLogradouro(rs.getString("end_logradouro"));
				e.setCep(rs.getString("end_cep"));
				
				minhaLista.add(e);
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
    	String sql = "select count(*) AS contaRegistro from endereco";
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
    
    //-----------------------------------------------------------------------------------------------------------------------------------
    
	public Endereco getListBuscaId(int end_id) {		
		
		Endereco e = new Endereco();
	      String sql = "select * from endereco where end_id=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setInt(1, end_id);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   
	     
	      e.setLogradouro(rs.getString("end_logradouro"));
	      e.setCep(rs.getString("end_cep"));
	              
	      }catch(Exception ex){
	       
	      }
	      return e; 
	  } 

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	
public Endereco getListBuscaString(String end_logradouro) {		
		
		Endereco e = new Endereco();
	      String sql = "select * from endereco where end_logradouro=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setString(1, end_logradouro);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   
	      e.setCep(rs.getString("end_cep"));
	      e.setId(rs.getInt("end_id"));
	              
	      }catch(Exception ex){
	       
	      }
	      return e; 
	  } 

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	public List<Endereco> getList() {

		try {
			String sql = "select * from endereco";

			PreparedStatement smt = con.prepareStatement(sql);
			ResultSet rs = smt.executeQuery();

			List<Endereco> minhaLista = new ArrayList<Endereco>();
			while (rs.next()) {
				Endereco e = new Endereco();

				e.setId(rs.getInt("end_id"));
				e.setLogradouro(rs.getString("end_logradouro"));	
				e.setCep(rs.getString("end_cep"));

				minhaLista.add(e);
				
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
		
		public Endereco buscarCep(String cep) {		
			
			Endereco e = new Endereco();
		      String sql = "select * from endereco where end_cep=?";
		      try{
		          
		PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
		      smt.setString(1, cep);
		ResultSet rs = smt.executeQuery();
		     
		      rs.next();   
		      e.setLogradouro(rs.getString("end_logradouro"));
		      e.setId(rs.getInt("end_id"));
		              
		      }catch(Exception ex){
		       
		      }
		      return e; 
		  } 

		
	
	   }
	// -------------------------------------------------------------------------------------------------------------------------------------------------

	

	

	
