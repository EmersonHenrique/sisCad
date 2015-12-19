package br.com.siscad.conexao;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import br.com.siscad.cliente.Cliente;
import br.com.siscad.cliente.ClienteDao;

public class Main {
   public static void main(String[] args) throws SQLException, JRException {
		int num = 13;
		Cliente cli = null;
	   List<Cliente> list =new ArrayList<Cliente>();
		Cliente c = new Cliente();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);
		/*
		list = dao.getList();
		
		for (Cliente cliente : list) {
			System.out.print("\""+c.getNome()+"\"");
		}
		*/
		
		String [] nomes = {"Anelia Campos","Silvia Molegate","marilia pera","Jose","marilza","david miller","Pamela Gomes","Anna Carolina","Bruna Kolosvik","Silvia Shapme","Carolina Dias","Emiliano Souza","Ricardo Molina","Pietra Caminostron","Gina Clacker","Chico Pinheiro","Marcia","Cesar Tralli","Mineirinho","Madre Teresa","Rodrigo Nardele","Gil Rugay"};
		ClienteDao dao2 = new ClienteDao(con);
		for(int i=0; i<nomes.length; i++){
			Cliente c2 = new Cliente();
			
			
			c2.setNome(nomes[i]);
			
		    dao2.salvar(c);
			System.out.println(nomes[i]);
		}
		
  }
   
  
   
}
