package br.com.siscad.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.siscad.cliente.Cliente;
import br.com.siscad.cliente.ClienteDao;

public class Main {
   public static void main(String[] args) throws SQLException {
		
	Cliente c =new Cliente();
	c.setNome("Marquinhos Goes");
	
	Connection con = CriarConexao.getConexao();
	
	ClienteDao dao=new ClienteDao(con);
	dao.salvar(c);
}
}
