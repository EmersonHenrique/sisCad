package br.com.siscad.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.print.attribute.standard.Severity;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.usagetracker.UsageTrackerClient;

import br.com.siscad.conexao.CriarConexao;
import br.com.siscad.exception.InvalidUserException;

@WebServlet("/frmLogin")
public class FrmLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrmLoginServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = null;
		String usuario = request.getParameter("txtusuario");
		String senhaAtual = request.getParameter("txtsenhaAtual");
		String senhaNova = request.getParameter("txtSenhaNova");
		String confirmarSenhaNova = request.getParameter("txtConfirmarSenhaNova");
		
		System.out.println(" senha Nova " + senhaNova);
		System.out.println(" Confirmar SenhaNova " + confirmarSenhaNova);
		
		
		
		try {
			System.out.println(autenticar(usuario,senhaAtual));
			System.out.println(senhaNova.equals(confirmarSenhaNova));
			if(autenticar(usuario,senhaAtual) && senhaNova.equals(confirmarSenhaNova)){
				System.out.println("usuario existe");
				atualizarSenha(usuario,senhaNova);				
			}else if (autenticar(usuario,senhaAtual) == false){
				throw new InvalidUserException("senha ou usuario não existe");
			}else{
				throw new InvalidUserException("erro ao confirma a senha");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad_menu.jsp");
		request.setAttribute("msg", "Senha Atualizada Com Sucesso");
		dispatcher.forward(request, response);
		
	}


	private void atualizarSenha(String usuario, String senhaNova) {
		
		Connection con = CriarConexao.getConexao();
	     LoginDao dao = new LoginDao(con);
	     Login l = new Login();	
	     l.setNome(usuario);
	     l.setSenha(senhaNova);
	     
	     dao.atualizar(l);		
	}


	private boolean autenticar(String usuario, String senhaAtual) throws SQLException {
		
		Connection con = CriarConexao.getConexao();
		Login l = new Login();
		LoginDao dao = new LoginDao(con);
		
		l.setNome(usuario);
		l.setSenha(senhaAtual);
		if(dao.isAutentic(usuario,senhaAtual))		
		return true;
		else
		return false;	
	}


	private boolean usuarioExiste(String usuario) throws SQLException {
		Connection con = CriarConexao.getConexao();
		LoginDao dao = new LoginDao(con);
		if(dao.isExiste(usuario))
		return true;
		else
		//	throw new InvalidUserException("Nome de Usuário ou senha Inválida");
		return false;
		
	}

}
