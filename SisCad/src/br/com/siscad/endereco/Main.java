package br.com.siscad.endereco;

import java.sql.*;
import java.util.*;

import br.com.siscad.conexao.CriarConexao;

class Main {
	
	Endereco e = new Endereco();

	Connection con = CriarConexao.getConexao();
	EnderecoDao dao = new EnderecoDao(con);	
	List<Endereco> list = new ArrayList<Endereco>();
	
  public static void main(String[] args) throws SQLException {
	
	  Main m = new Main();
	  
	// m.teste_buscarCep("05761341");
	 // m.teste_buscaPorString("Gi Vicente");
	//  m.teste_buscaPorId(77);	  
	 m.inserir();
	// m.teste_remover();
	  // m.teste_atualizar();
	//m.teste_listar();
	    	
  }

private void teste_buscarCep(String s) {
 System.out.println(dao.buscarCep(s).getLogradouro());
 System.out.println(dao.buscarCep(s).getId());
}

private void teste_buscaPorString(String s) {
	int i = 0;
	i = dao.getListBuscaString(s).getId();
	System.out.println(i);
	
}

private void teste_buscaPorId(int id) {
	System.out.println(dao.getListBuscaId(id).getLogradouro());	
}

private void teste_listar() {
	
   list = dao.getList();
   for (Endereco end : list) {
	  
	System.out.print("\""+end.getLogradouro()+"\"");
	//System.out.print(",");
	//System.out.print("\""+end.getCep()+"\"");
	System.out.print(",");
}
}


private void teste_atualizar() {
	
	e.setLogradouro("Flor de Lins");
	e.setCep("07860291");
	e.setId(1);
	
	dao.atualizar(e);
}

private void teste_remover() {
	e.setId(2);
	dao.remover(e);
}

private void inserir() throws SQLException {
	String [] logradouro = {"Nova Lima","Gi Vicente","California","Babilonia","Peixoto Gomide"}; 	
	//String[] cep = {"05761340","05761341","05761350"};
	
	 for (int i = 0; i < logradouro.length; i++) {
		e.setLogradouro(logradouro[i]);
		//e.setCep(cep[i]);
		dao.salvar(e);
	}
	
  }
}
