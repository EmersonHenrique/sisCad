package br.com.siscad.cliente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siscad.conexao.CriarConexao;

/**
 * Servlet implementation class Cad_cliente
 */
@WebServlet("/Cad_cliente")
public class Cad_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Cad_cliente() {}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txt_nome");
		
		Cliente c = new Cliente();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);
		
		c.setNome(nome);
		try {
			dao.salvar(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad_cliente.jsp");
		request.setAttribute("msg", "Salvo com Sucesso");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
