package br.com.siscad.cliente;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siscad.bairro.Bairro;
import br.com.siscad.bairro.BairroDao;
import br.com.siscad.cidade.Cidade;
import br.com.siscad.cidade.CidadeDao;
import br.com.siscad.conexao.CriarConexao;
import br.com.siscad.endereco.Endereco;
import br.com.siscad.endereco.EnderecoDao;

/**
 * Servlet implementation class Cliente_ComboServlet
 */
@WebServlet("/cad_cliente")
public class Cliente_ComboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cliente_ComboServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnderecoDao dao = null;
		BairroDao dao1 = null;
		CidadeDao dao2 = null;
		
		List<Endereco> list = new ArrayList<Endereco>();
	    List<Bairro>   list2 = new ArrayList<Bairro>();
		List<Cidade>   list3 = new ArrayList<Cidade>();
		
		Connection con = null;
		Connection con1 = null;
		Connection con2 = null;
		
		con = CriarConexao.getConexao();
		dao = new EnderecoDao(con);
		list = dao.getList();
		
		con1 = CriarConexao.getConexao();
		dao1 = new BairroDao(con1);
		list2 = dao1.getList();
		
		con2 = CriarConexao.getConexao();
		dao2 = new CidadeDao(con2);
		list3 = dao2.getList();
		
		request.setAttribute("end", list);
		request.setAttribute("bai", list2);
		request.setAttribute("cid", list3);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad_cliente.jsp");
		dispatcher.forward(request, response);
	}

}
