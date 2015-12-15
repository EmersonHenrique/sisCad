package br.com.siscad.cliente;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siscad.conexao.CriarConexao;



@WebServlet("/List_cliente2")
public class List_ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public List_ClienteServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numPagina = null;
		numPagina = request.getParameter("numPagina");
		if(numPagina==null)
				numPagina="1";
		
		List<Cliente> list = new ArrayList<>();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);		
						
		list = dao.getList(Integer.parseInt(numPagina));
		
		Connection con2 = CriarConexao.getConexao();
		ClienteDao dao2 = new ClienteDao(con2);
		int totalRegistros = dao2.contaRegistro();
				
		request.setAttribute("list", list);
		request.setAttribute("totalRegistros", totalRegistros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_cliente.jsp");
		dispatcher.forward(request, response);
	}

}
