package br.com.siscad.login;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.siscad.conexao.CriarConexao;

class Main {
   public static void main(String[] args) throws SQLException {
	
	 //  Connection con = CriarConexao.getConexao();
	 //  LoginDao dao = new LoginDao(con);
	  // Login l = new Login();	  
	   
	  // System.out.println(dao.isAutentic("user1","123"));
	//   System.out.println("usuario:" + dao.consulta("user1").getNome());	
	   Main m = new Main();
	 //  System.out.println(m.autenticar("user1","123"));
	 //  System.out.println("autenticar02 =  " + m.autenticar02("user11"));
	   m.atualizar("user1","123");
   }
   
   
   
private void atualizar(String nome, String senha) {
	
         Connection con = CriarConexao.getConexao();
	     LoginDao dao = new LoginDao(con);
	     Login l = new Login();	
	     l.setNome(nome);
	     l.setSenha(senha);
	     
	     dao.atualizar(l);
	     
	    
	
}



public boolean  autenticar(String usuario, String senha) throws SQLException{
	   
	   Connection con = CriarConexao.getConexao();
	   LoginDao dao = new LoginDao(con);
	   //Login l = new Login();
		 
		  if(dao.isAutentic(usuario, senha)){
			  return true; 
		   }else{
			   return false;
		   }
	  }
   /*
   public boolean  autenticar02(String usuario) throws SQLException{
	   
	   Connection con = CriarConexao.getConexao();
	   LoginDao dao = new LoginDao(con);
	   
		  if(dao.isAutentic(usuario)){
			  return true; 
		   }else{
			   return false;
		   }
	  }*/
}
