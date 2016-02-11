package br.com.siscad.bairro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siscad.conexao.CriarConexao;


@WebServlet("/cad_bairro")
public class Cad_BairroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cad_BairroServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b = request.getParameter("txt_nome");
		
		Connection con = CriarConexao.getConexao();
		BairroDao dao = new BairroDao(con);
		Bairro bai = new Bairro();
		bai.setNome(b);
		
		try {
			dao.salvar(bai);
		} catch (SQLException e) {
				e.printStackTrace();
		}
		System.out.println("bairro " + b);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad_bairro.jsp");
		request.setAttribute("msg", " Bairro " + b + " Salvo com Sucesso");
		dispatcher.forward(request, response);
	}

}
