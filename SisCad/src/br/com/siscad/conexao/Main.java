package br.com.siscad.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import br.com.siscad.bairro.BairroDao;
import br.com.siscad.cidade.CidadeDao;
import br.com.siscad.cliente.Cliente;
import br.com.siscad.cliente.ClienteDao;
import br.com.siscad.endereco.EnderecoDao;



public class Main {
	
	
	   
	
   public static void main(String[] args) throws SQLException{
	   	   
	//   teste_pesquisarNome("br");
	   
	   lista();
	//   inserir();
	   
     }

private static void inserir() throws SQLException {
	
	Connection con = CriarConexao.getConexao();		 
	ClienteDao dao = new ClienteDao(con);
	
	Cliente c = new Cliente();
	
String [] nomes = {"Fabiano Costa","Samara","Rodrigo Nardele","Emiliano Souza","Monaliza Xaim","Bento Ruivo","Bruna Kolosvik","Cesar Tralli","david miller","Emiliano Souza","Fabiano"
+"Costa","Pedro Geromel","Joaquim Phoenix","Cassia","Vil","Evil Dias","Ma Angela","Neyma JR","Rogerio Lima","Robert Xavier","Simone Campos","Steve Macmanan","Carlos"
+"Henrique","Dominique"};

String [] tel = {"00000","53343","33333333","000000000","99999999","99999999","99999999","99999999","99999999","99999999","99999999","99999999","11111111111","4444444","4444444","77777"
+"7","323","23223","99999999","33333333","33333333","4444444","33333333","33333333"};

String [] cep = {"Nova Lima","Gi Vicente","Nova Lima","Nova Lima","Gi Vicente","California","Gi Vicente","Nova Lima","Gi Vicente","California","Nova Lima","Nova Lima","Gi"
+"Vicente","Nova Lima","Nova Lima","Nova Lima","Nova Lima","Gi Vicente","Peixoto Gomide","Nova Lima","Nova Lima","Nova Lima","Nova Lima","Nova Lima"};	
	
String [] bairro = {"Agnes","Agnes","Paris","Campo Limpo","Agnes","Campo Limpo","Campo Limpo","Paris","Campo Limpo","Agnes","Paris","Paris","Campo"+
"Limpo","Paris","Paris","Paris","Paris","Campo Limpo","Paris","Aeroporto","Aeroporto","Paris","Campo Limpo","Campo Limpo"};

String [] cidade = {"Sao Paulo","Minas Gerais","Minas Gerais","Espirito Santo","Sao Paulo","Sao Paulo","Espirito Santo","Minas Gerais","Espirito Santo","Espirito Santo","Minas"+
"Gerais","Minas Gerais","Espirito Santo","Minas Gerais","Minas Gerais","Espirito Santo","Minas Gerais","Espirito Santo","Minas Gerais","Minas Gerais","Minas"+ 
"Gerais","Araujo","Rio de Janeiro","Minas Gerais"};

//int [] numero = {1,2,3,4,5,6,7,8,9,10};

  for (int i = 0; i < nomes.length; i++) {
		c.setNome(nomes[i]);
		c.setTelefone(tel[i]);
		
		Connection con2 = CriarConexao.getConexao();
		EnderecoDao dao2 = new EnderecoDao(con2);
		c.setCep(dao2.getListBuscaString(cep[i]).getId());
		
		Connection con3 = CriarConexao.getConexao();
		BairroDao dao3 = new BairroDao(con3);
		c.setBairro(dao3.getListBuscaString(bairro[i]).getId());
		
		Connection con4 = CriarConexao.getConexao();
		CidadeDao dao4 = new CidadeDao(con4);
		
		c.setCidade(dao4.getListBuscaString(cidade[i]).getId());
		
		c.setNumero(i);
		
		dao.salvar(c);
	}
	
	/*
	for (Cliente c : list) {
		System.out.print("\""+c.getTelefone()+"\"");
		System.out.print(",");
	}*/
	/*
	Connection con2 = CriarConexao.getConexao();
	EnderecoDao dao2 = new EnderecoDao(con2);
	for (Cliente c : list) {
		System.out.print("\""+dao2.getListBuscaId(c.getEndereco()).getLogradouro()+"\"");
		System.out.print(",");
	}*/
	/*
	Connection con3 = CriarConexao.getConexao();
	BairroDao dao3 = new BairroDao(con3);
	for (Cliente c : list) {
		System.out.print("\""+dao3.getListBuscaId(c.getBairro()).getNome()+"\"");
		System.out.print(",");
	}*/
	/*
	Connection con4 = CriarConexao.getConexao();
	CidadeDao dao4 = new CidadeDao(con4);
	for (Cliente c : list) {
		System.out.print("\""+dao4.getListBuscaId(c.getCidade()).getNome()+"\"");
		System.out.print(",");
	}
	*/
	
}

private static void lista() {
	List<Cliente> list =  new LinkedList<Cliente>();
	Connection con = CriarConexao.getConexao();		 
	ClienteDao dao = new ClienteDao(con);
	list = dao.getList();
	
	for (Cliente c : list) {
		System.out.println(c.getNome());
	}
	
	/*
	for (Cliente c : list) {
		System.out.print("\""+c.getTelefone()+"\"");
		System.out.print(",");
	}*/
	/*
	Connection con2 = CriarConexao.getConexao();
	EnderecoDao dao2 = new EnderecoDao(con2);
	for (Cliente c : list) {
		System.out.print("\""+dao2.getListBuscaId(c.getEndereco()).getLogradouro()+"\"");
		System.out.print(",");
	}*/
	/*
	Connection con3 = CriarConexao.getConexao();
	BairroDao dao3 = new BairroDao(con3);
	for (Cliente c : list) {
		System.out.print("\""+dao3.getListBuscaId(c.getBairro()).getNome()+"\"");
		System.out.print(",");
	}*/
	/*
	Connection con4 = CriarConexao.getConexao();
	CidadeDao dao4 = new CidadeDao(con4);
	for (Cliente c : list) {
		System.out.print("\""+dao4.getListBuscaId(c.getCidade()).getNome()+"\"");
		System.out.print(",");
	}*/
	
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
   
  
   

