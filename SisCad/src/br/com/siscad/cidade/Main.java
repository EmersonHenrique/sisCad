package br.com.siscad.cidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.siscad.conexao.CriarConexao;

public class Main {
	

	Connection con = CriarConexao.getConexao();
	Cidade c = new Cidade();
	CidadeDao dao = new CidadeDao(con);
	
	List<Cidade> list = new ArrayList<Cidade>();
	
   public static void main(String[] args) {
	Main m = new Main();
	
//	m.teste_buscarPorString("Sao Paulo");
//	m.teste_lista();
	//m.teste_buscaPorId(4);
	//m.teste_atualizar(4);
	m.teste_salvar();
	//m.tete_remover();
}


private void teste_buscarPorString(String s) {
	System.out.println(dao.getListBuscaString(s).getId());
}


private void teste_lista() {
  list = dao.getList();
  for (Cidade c2 : list) {
	System.out.print("\""+c2.getNome()+"\"");
	System.out.print(",");
}
}

private void teste_buscaPorId(int i) {
	System.out.println(dao.getListBuscaId(i).getNome());	
}

private void teste_atualizar(int i) {
	c.setId(i);
	c.setNome("Sao Paulo");
	dao.atualizar(c);
}

private void tete_remover() {
	c.setId(1);
	dao.remover(c);	
}

private void teste_salvar() {
	 String []cidade = {"Minas Gerais","Espirito Santo","Sao Paulo","Araujo","Rio de Janeiro"};
	 
	 for (int i = 0; i < cidade.length; i++) {
		c.setNome(cidade[i]);
		try {
			dao.salvar(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}
