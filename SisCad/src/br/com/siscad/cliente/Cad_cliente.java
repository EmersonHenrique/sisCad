package br.com.siscad.cliente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siscad.bairro.BairroDao;
import br.com.siscad.cidade.CidadeDao;
import br.com.siscad.conexao.CriarConexao;
import br.com.siscad.endereco.Endereco;
import br.com.siscad.endereco.EnderecoDao;


@WebServlet("/Cad_cliente")
public class Cad_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Cad_cliente() {}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txt_nome");
		String tel = request.getParameter("txt_tel");
		String cep = request.getParameter("endereco");
		int numero = Integer.parseInt(request.getParameter("txt_num"));
		String bai = request.getParameter("bairro");
		String cid = request.getParameter("cidade");
		
		Cliente c = new Cliente();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);
			
	//--------------------endere�o-------------------------			
		Connection con_e = CriarConexao.getConexao();
		EnderecoDao dao_e = new EnderecoDao(con_e);		
		int en = dao_e.getListBuscaString(cep).getId();
	//---------------------bairro---------------------------	
		Connection con_b = CriarConexao.getConexao();
		BairroDao dao_b = new BairroDao(con_b);
		int ba = dao_b.getListBuscaString(bai).getId();
	//---------------------cidade---------------------------
		Connection con_c = CriarConexao.getConexao();
		CidadeDao dao_c = new CidadeDao(con_c);
		int ci = dao_c.getListBuscaString(cid).getId();
   //-----------------------------------------------------		
		
		c.setNome(nome);
		c.setTelefone(tel);
		c.setCep(en);
		c.setNumero(numero);
		c.setBairro(ba);
		c.setCidade(ci);
		
		try {
			dao.salvar(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/List_cliente2");
		request.setAttribute("msg", "Cliente " + nome + " Salvo com Sucesso");
		dispatcher.forward(request, response);
	}
}
