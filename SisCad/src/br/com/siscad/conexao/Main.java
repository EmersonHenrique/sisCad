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
	   List<Cliente> li =new ArrayList<Cliente>();
		Cliente c = new Cliente();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);
		
		/*
		HashMap parametro = new HashMap(); 
	    JasperReport pathjrxml = JasperCompileManager.compileReport("C:/Users/maria/git/br.com.siscad.git/SisCad/src/br/com/siscad/relatorio/clientes.jasper");
	    JasperPrint jp = JasperFillManager.fillReport(pathjrxml, parametro, con);
	    JasperExportManager.exportReportToPdfFile("C:/Users/maria/git/br.com.siscad.git/SisCad/src/br/com/siscad/relatorio/clientes.pdf");
		
		JasperViewer jrv = new JasperViewer(jp);
		jrv.setVisible(true);
		*/
		
		try{
	          
	          
	           
	          HashMap parametros = new HashMap();
	          JasperPrint jp = JasperFillManager.fillReport("C:/Users/maria/git/br.com.siscad.git/SisCad/src/br/com/siscad/relatorio/clientes.jasper", parametros,con);
	        //  JasperPrint jp = JasperFillManager.fillReport("./relatorio/clientes.jasper", parametros,con);
	          
	          
	         // JasperExportManager.exportReportToPdfFile(jp,"C:/Users/maria/git/br.com.siscad.git/SisCad/src/br/com/siscad/relatorio/clientes.pdf");
	       	                 
	        //  String path = "/src/br/com/siscad/relatorio/clientes.pdf";
	                        String path = "C:/Users/maria/git/br.com.siscad.git/SisCad/src/br/com/siscad/relatorio/clientes.pdf";
	      	          
	       // File pdf = new File(path);
	                       JasperViewer jrVew = new JasperViewer(jp,false);
	        //Desktop.getDesktop().open(pdf);
	          
	          jrVew.setVisible(true);          
	                        
	          
	       }catch(Exception e){
	           e.printStackTrace();
	       
	    }         
		
  }
   
  
   
}
