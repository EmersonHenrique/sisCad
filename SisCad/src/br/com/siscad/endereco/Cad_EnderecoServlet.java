package br.com.siscad.endereco;

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


@WebServlet("/cad_endereco")
public class Cad_EnderecoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cad_EnderecoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rua = request.getParameter("txt_nome");
		String cep = request.getParameter("txt_cep");
		
		Connection con = CriarConexao.getConexao();
		EnderecoDao dao = new EnderecoDao(con);
		Endereco end = new Endereco();
		
		end.setLogradouro(rua);
		end.setCep(cep);
		
		try {
			dao.salvar(end);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad_endereco.jsp");
		request.setAttribute("msg", "Rua " + rua + " Salvo com Sucesso");
		dispatcher.forward(request, response);
	}

}
