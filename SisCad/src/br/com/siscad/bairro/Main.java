package br.com.siscad.bairro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import br.com.siscad.cidade.Cidade;
import br.com.siscad.conexao.CriarConexao;

public class Main {
	
	Connection con = CriarConexao.getConexao();
	Bairro b = new Bairro();
	BairroDao dao = new BairroDao(con);
	List<Bairro> list = new ArrayList<>();
	
   public static void main(String[] args) throws SQLException {
	
	Main m = new Main();
	m.inserir();
	//m.teste_salvar();
	//m.teste_lista();
	   
   } 

private void inserir() throws SQLException {
	String [] bairro = {"Paris","Campo Limpo","Agnes","Aeroporto"};
	
	for (int i = 0; i < bairro.length; i++) {
		b.setNome(bairro[i]);
		dao.salvar(b);
	}
	
}

private void teste_salvar() {
	String [] bairro = {"Paris","Campo Limpo","Agnes"};
	for (int i = 0; i < bairro.length; i++) {
	  b.setNome(bairro[i]);
	  try {
		dao.salvar(b);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
}

private void teste_lista() {
   	
		list = dao.getList();
		  for (Bairro b2 : list) {
			System.out.print("\""+b2.getNome()+"\"");
			System.out.print(",");
		
	}
  }
}
