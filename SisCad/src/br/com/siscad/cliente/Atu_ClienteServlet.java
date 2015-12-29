package br.com.siscad.cliente;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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


@WebServlet("/atu_Cliente")
public class Atu_ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
   
    public Atu_ClienteServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
						
		//---------------------------------		
		Cliente li;
		Cliente c = new Cliente();
		Connection con = CriarConexao.getConexao();
		ClienteDao dao = new ClienteDao(con);
		
		c.setId(num);
		li = dao.getListBuscaId(num);		
				
		//-------------endereco-------------
		Connection con_e = null;
		EnderecoDao dao_e = null;
		List<Endereco> list1 = new ArrayList<Endereco>();
		
		con_e = CriarConexao.getConexao();
		dao_e = new EnderecoDao(con_e);
		list1 = dao_e.getList();		
		
		//------------bairro---------------- 		
		Connection con_bai = null;
		BairroDao dao_bai = null;
		List<Bairro> list2 = new ArrayList<Bairro>();
		
		con_bai = CriarConexao.getConexao();
		dao_bai = new BairroDao(con_bai);
		list2 = dao_bai.getList();
		
		//---------cidade------------------
		Connection con_cid = null;
		CidadeDao dao_cid = null;
		List<Cidade> list3 = new ArrayList<Cidade>();
		
		con_cid = CriarConexao.getConexao();
		dao_cid = new CidadeDao(con_cid);
		list3 = dao_cid.getList();
						
		request.setAttribute("li", li);
		request.setAttribute("end", list1);	
		request.setAttribute("bai", list2);
		request.setAttribute("cid", list3);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/atu_cliente.jsp");
		dispatcher.forward(request, response);
				
	}

}
