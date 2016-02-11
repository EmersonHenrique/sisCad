package br.com.siscad.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;

import br.com.siscad.conexao.CriarConexao;


@WebServlet("/VisualisarRelatorio")
public class VisualisarRelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisualisarRelatorioServlet() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		try{
			String param = request.getParameter("relat");              
			System.out.println("Aqui" + param);
			
			if(param.equals("clientes")){
			param = "clientes02"+".jasper"; 
		
			Connection con = CriarConexao.getConexao();
			HashMap parametro = new HashMap();
			//parametro.put("id", 1);
			ServletContext sc = getServletContext();
			JasperPrint jp = JasperFillManager.fillReport(sc.getRealPath("/relatorio/"+param), parametro, con);
			JasperViewer jrv = new JasperViewer(jp,false);
			jrv.setVisible(true);
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/List_cliente2");
		    dispatcher.forward(request, response);
		    
			} else {
				
			int num = Integer.parseInt(param);
			param = "cliente"+".jasper";
			
		    Connection con = CriarConexao.getConexao();
			HashMap parametro = new HashMap();
			parametro.put("id", num);
			ServletContext sc = getServletContext();
			JasperPrint jp = JasperFillManager.fillReport(sc.getRealPath("/relatorio/"+param), parametro, con);
			JasperViewer jrv = new JasperViewer(jp,false);
			jrv.setVisible(true);
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/List_cliente2");
		    dispatcher.forward(request, response);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
		
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter out = response.getWriter();
		String relat = request.getParameter("relat");
		
		relat = "clientes"+".jasper";
		System.out.println("relatório " + relat);
		
		//criarJasper();

		try{
			Connection con = CriarConexao.getConexao();
			HashMap parametro = new HashMap();
			ServletContext sc = getServletContext();
			//String nomeArquivo = sc.getRealPath("/") + "clientes.pdf";
			//JasperPrint jp = JasperFillManager.fillReport(sc.getRealPath("/relatorio/clientes.jasper"), parametro, con);		
			JasperPrint jp = JasperFillManager.fillReport(sc.getRealPath("/relatorio/"+relat), parametro, con);
			//JasperExportManager.exportReportToPdfFile(jp,nomeArquivo);
			JasperViewer jrv = new JasperViewer(jp);
			jrv.setVisible(true);
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VisualisarRelatorio");
			dispatcher.forward(request, response);
			
			/*
			out.println("<html>");
			out.println("<head>");
			out.println("<tite>Servlet Visualizar</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Visualizar " + request.getContextPath());
			out.println("</body>");
			out.println("</html>");	
			*/
		/*
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
		}*/
	
		
	}

}
