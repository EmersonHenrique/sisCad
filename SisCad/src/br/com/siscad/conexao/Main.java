package br.com.siscad.conexao;

import java.sql.Connection;
import java.util.*;

import br.com.siscad.cliente.Cliente;
import br.com.siscad.cliente.ClienteDao;



public class Main {
   public static void main(String[] args){
	   
	   teste_pesquisarNome("br");
	   
     }

private static void teste_pesquisarNome(String nome) {
	  List<Cliente> list =  new ArrayList<>();
	  Connection con = CriarConexao.getConexao();
	  ClienteDao dao = new ClienteDao(con);
	  list = dao.getList("%"+nome+"%");
	  
	  for (Cliente cli : list) {
		System.out.println("nome " + cli.getNome());
	}
	
}	
		
  }
   
  
   

