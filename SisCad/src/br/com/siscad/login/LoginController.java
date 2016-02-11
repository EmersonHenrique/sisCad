package br.com.siscad.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.siscad.conexao.CriarConexao;
import br.com.siscad.exception.InvalidUserException;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			processRequest(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {		
		
		validarDadosRecebidos(request);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("cad_menu.jsp");
		dispatcher.forward(request, response);
		
	}


	private void validarDadosRecebidos(HttpServletRequest request) throws ServletException, SQLException {
		
		String nomeUsuario = request.getParameter("txtUsuario");
		String senhaUsuario = request.getParameter("txtSenha");
				
		      Connection con = CriarConexao.getConexao();
		      LoginDao dao = new LoginDao(con);
		   			 
			  if(dao.isAutentic(nomeUsuario,senhaUsuario)){
				  HttpSession session = request.getSession();
				  session.setAttribute("usuarioAutenticado", nomeUsuario);	
				}else{
				   throw new InvalidUserException("Nome de Usuário ou senha Inválida");
			   }
	}
}
