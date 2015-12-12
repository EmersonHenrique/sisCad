package br.com.siscad.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import br.com.siscad.cliente.Cliente;
import br.com.siscad.cliente.ClienteDao;

public class Main {
   public static void main(String[] args) throws SQLException {
		
	Cliente c =new Cliente();
	Connection con = CriarConexao.getConexao();
	ClienteDao dao=new ClienteDao(con);
	/*
	List<Cliente> list = new ArrayList<>();
	list = (List<Cliente>) dao.getList("m%");
	
	for (Cliente c1 : list) {
		System.out.println(c1.getId() + " : " + c1.getNome());		
	}	*/
	
	int i = dao.contaRegistro();
	
	System.out.println("i = " + i);
	
	
	
	System.out.println(19%10);
	
  }
   
  
   
}
