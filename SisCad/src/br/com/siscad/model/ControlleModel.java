package br.com.siscad.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/controlleModel")
public class ControlleModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControlleModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txt_name");
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad_cliente#pagina1");
		request.setAttribute("nome2",nome);
		dispatcher.forward(request, response);
	}

}
