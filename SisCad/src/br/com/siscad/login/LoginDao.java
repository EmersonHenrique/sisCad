package br.com.siscad.login;

import java.sql.*;

import br.com.siscad.cidade.Cidade;

public class LoginDao {
   
	private Connection con;

	public LoginDao(Connection con) {
	  this.con = con;	
	}
	
	
	public boolean isExiste(String usuario) throws SQLException{    
		   
        PreparedStatement smt = null;
        try {
            smt = (PreparedStatement) con.prepareStatement("select * from login where "
  + " nome=?");
        } catch (SQLException ex) {
           System.out.println("Error No Método isAutentic Dao \n" + ex);
        }
        
        smt.setString(1, usuario);
       // smt.setString(2, senha);
        
        ResultSet rs = smt.executeQuery();        
             rs.first();               
       if(rs.getRow()>0){
           return true;
       }else {
           return false;
         }   
       }

	public boolean isAutentic(String usuario, String senha) throws SQLException{    
		   
        PreparedStatement smt = null;
        try {
            smt = (PreparedStatement) con.prepareStatement("select * from login where "
  + " nome=? and senha=?");
        } catch (SQLException ex) {
           System.out.println("Error No Método isAutentic Dao \n" + ex);
        }
        
        smt.setString(1, usuario);
        smt.setString(2, senha);
        
        ResultSet rs = smt.executeQuery();        
             rs.first();               
       if(rs.getRow()>0){
           return true;
       }else {
           return false;
       }   
    }
	
//------------------------------------------------------------------------------
    
    public Login consulta(String n) throws SQLException {       
  
        String sql = "select * from login where nome like ?";//query sql
        PreparedStatement smt;// criar varivel Preparadora
        try {
            smt = (PreparedStatement) con.prepareStatement(sql);//iniciar variável preparadora

            smt.setString(1, n);//recebe o parametro a ser buscado
            ResultSet rs = smt.executeQuery();//criar Result, pecorre a procura do parametro executado a query

            Login l = new Login();//instaciar o modelo 

            rs.next();//ir para proximo 
            l.setId(rs.getLong("id"));
            l.setNome(rs.getString("nome"));
           
            smt.close();//fecha a variavel preparadora
            rs.close();//fecha o rs
            return l;//devolver o resultado

        } catch (SQLException ex) {
            return null;
        } finally {
             con.close();
        }
    
    }
   //---------------------------------------------------------------------------------------------------------
    
    public void atualizar(Login l) {
		String sql = "update login set senha=?  where nome=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, l.getSenha());		
			stmt.setString(2, l.getNome());			
			
			stmt.execute();
			stmt.close();
			System.out.println("atualizado com sucesso");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}}
   //--------------------------------------------------------------------------------------------------------- 
}
