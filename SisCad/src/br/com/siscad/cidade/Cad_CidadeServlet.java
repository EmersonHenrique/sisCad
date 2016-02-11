package br.com.siscad.cidade;

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

@WebServlet("/cad_cidade")
public class Cad_CidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Cad_CidadeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c = request.getParameter("txt_nome");
		
		Connection con = CriarConexao.getConexao();
		CidadeDao dao = new CidadeDao(con);
		Cidade cid = new Cidade();
		
		cid.setNome(c);
		
		try {
			dao.salvar(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad_cidade.jsp");
		request.setAttribute("msg", "Cidade " + c + " Salvo com Sucesso");
		dispatcher.forward(request, response);
	}

}
