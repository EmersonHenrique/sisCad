package br.com.siscad.cliente;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siscad.conexao.CriarConexao;


@WebServlet("/atu_Cliente")
public class Atu_ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
   
    public Atu_ClienteServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		Cliente li ;
		Cliente c = new Cliente();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);
		
		c.setId(num);
		li = dao.getListBuscaId(num);
		
		request.setAttribute("li", li);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/atu_cliente.jsp");
		dispatcher.forward(request, response);
				
	}

}
