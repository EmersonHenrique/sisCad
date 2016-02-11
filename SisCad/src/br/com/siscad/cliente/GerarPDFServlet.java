package br.com.siscad.cliente;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import br.com.siscad.conexao.CriarConexao;


@WebServlet("/GerarPDF")
public class GerarPDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GerarPDFServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = CriarConexao.getConexao();
		
		String pathJasper = getServletContext().getRealPath("/");
		String path = getServletContext().getRealPath("/");
		
		Map parametros = new HashMap();
		try{
		   JasperPrint impresso = JasperFillManager.fillReport(pathJasper + "/relatorio/clientes.jasper", parametros, con);	
		   JasperExportManager.exportReportToPdfFile(impresso, path + "/clientes.pdf");
		   response.sendRedirect("clientes.pdf");
		}catch (Exception e) {
		   response.getWriter().println("Error ao gerar relatório " + e);
		}
		
		
		
	}

}
