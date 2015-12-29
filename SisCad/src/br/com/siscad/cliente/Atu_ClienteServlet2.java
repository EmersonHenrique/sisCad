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


@WebServlet("/atu_ClienteServlet2")
public class Atu_ClienteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Atu_ClienteServlet2() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("txt_nome");
		String tel = request.getParameter("txt_tel");
		int end = Integer.parseInt(request.getParameter("endereco"));
		int bai = Integer.parseInt(request.getParameter("bairro"));
		int cid = Integer.parseInt(request.getParameter("cidade"));
		int numero = Integer.parseInt(request.getParameter("txt_num"));
		
		
        Cliente c = new Cliente();
        Connection con = CriarConexao.getConexao();
        ClienteDao dao = new ClienteDao(con);
        
        c.setId(id);
        
        c.setNome(nome);
        c.setTelefone(tel);
        c.setEndereco(end);
        c.setBairro(bai);
        c.setCidade(cid);
        c.setNumero(numero);
        
        
        dao.atualizar(c);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/List_cliente2");
        request.setAttribute("msg", nome + " Atualizado com Sucesso");
        dispatcher.forward(request, response);
        
			
	}

}
