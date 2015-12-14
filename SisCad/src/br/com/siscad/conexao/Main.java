package br.com.siscad.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import br.com.siscad.cliente.Cliente;
import br.com.siscad.cliente.ClienteDao;

public class Main {
   public static void main(String[] args) throws SQLException {
		int num = 13;
		Cliente cli = null;
	   List<Cliente> li =new ArrayList<Cliente>();
		Cliente c = new Cliente();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);
		
		c.setId(num);
		cli = dao.consulta(num);
		
	System.out.println(dao.consulta(num).getNome());
	System.out.println(dao.consulta(num).getId());
  }
   
  
   
}
