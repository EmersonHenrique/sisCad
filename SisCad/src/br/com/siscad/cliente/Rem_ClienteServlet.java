package br.com.siscad.cliente;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siscad.conexao.CriarConexao;


@WebServlet(description = "rem_cliente", urlPatterns = { "/rem_cliente" })
public class Rem_ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rem_ClienteServlet() {
        super();
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int num = Integer.parseInt(request.getParameter("num"));
		
		Cliente c = new Cliente();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);
		
		c.setId(num);
		dao.remover(c);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/List_cliente2");
		request.setAttribute("msg", "Excluido o Id " + num + " com Sucesso. ");
		dispatcher.forward(request, response);
	
	}

	
}
