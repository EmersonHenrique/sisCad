package br.com.siscad.cliente;

import java.sql.*;
import java.util.*;

import br.com.siscad.conexao.CriarConexao;
import br.com.siscad.endereco.Endereco;
import br.com.siscad.endereco.EnderecoDao;

public class ClienteDao {

	private Connection con;

	public ClienteDao(Connection con) {
		this.con = con;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void salvar(Cliente c) throws SQLException {

		String sql = "insert into cliente(cli_nome,cli_telefone,cli_cep,cli_bairro,cli_cidade,cli_numero)values(?,?,?,?,?,?)";

		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setInt(3, c.getCep());
			stmt.setInt(4, c.getBairro());
			stmt.setInt(5, c.getCidade());
			stmt.setInt(6, c.getNumero());

			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//con.close();
			System.out.println("conexao fechada");
		}

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void remover(Cliente c) {

		String sql = "delete from cliente where id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, c.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void atualizar(Cliente c) {
		String sql = "update cliente set cli_nome = ?, cli_telefone =?,cli_cep=?,cli_bairro=?,cli_cidade=?,cli_numero= ? where cli_id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setInt(3, c.getCep());
			stmt.setInt(4, c.getBairro());
			stmt.setInt(5, c.getCidade());
			stmt.setInt(6, c.getNumero());			
			stmt.setInt(7, c.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public List<Cliente> getList(int pagina) {
		if (pagina==1)
			pagina = 0;
		else
			pagina=--pagina;
		
		pagina = pagina * 10;
		//select * from cliente  ORDER BY cli_
		//String sql = "select * from cliente  LIMIT 10 offset "+pagina+";";
		String sql = "select * from cliente ORDER BY cli_id DESC  LIMIT 10 offset "+pagina+";";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Cliente> minhaLista = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();
				
				c.setId(rs.getInt("cli_id"));
				c.setNome(rs.getString("cli_nome"));
				c.setTelefone(rs.getString("cli_telefone"));
				c.setCep(rs.getInt("cli_cep"));
				c.setBairro(rs.getInt("cli_bairro"));
				c.setCidade(rs.getInt("cli_cidade"));
				c.setNumero(rs.getInt("cli_numero"));
											
				minhaLista.add(c);				
			//	Collections.reverse(minhaLista);				
			}

			stmt.close();
			rs.close();
			return minhaLista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
    public int contaRegistro(){
    	ResultSet rs = null;
    	PreparedStatement stmt = null;
    	String sql = "select count(*) AS contaRegistro from cliente";
    	try {
    	    stmt = con.prepareStatement(sql);    	
		    rs = stmt.executeQuery();
			rs.next();
			int registros = Integer.parseInt(rs.getString("contaRegistro"));			
			
			int resto = registros%10;	
			if(resto != 0)	
			return (registros / 10) + 1;
			else			
			return registros / 10;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
    	return 0;
    }
    
 //========================================================================================================================================
    
    
	public Cliente getListBuscaId(int cli_id) {		
		
		Cliente c = new Cliente();
	      String sql = "select * from cliente where cli_id=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setInt(1, cli_id);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   	     
	      
	      c.setNome(rs.getString("cli_nome"));
	      c.setTelefone(rs.getString("cli_telefone"));
		  c.setCep(rs.getInt("cli_cep"));
		  c.setBairro(rs.getInt("cli_bairro"));
		  c.setCidade(rs.getInt("cli_cidade"));
		  c.setNumero(rs.getInt("cli_numero"));
		  c.setId(rs.getInt("cli_id"));
	              
	      }catch(Exception e){
	       System.out.println("Error método ClienteDao " + e);
	      }
	      return c; 
	  } 

		
		

	//--------------------------------------------------------------------------------------------------------------------------------------------------
	public List<Cliente> getList() {

		try {
			String sql = "select * from cliente";

			PreparedStatement smt = con.prepareStatement(sql);
			ResultSet rs = smt.executeQuery();

			List<Cliente> minhaLista = new LinkedList<Cliente>();
			//TreeSet<Cliente> minhaLista = new TreeSet<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();

				c.setId(rs.getInt("cli_id"));
				c.setNome(rs.getString("cli_nome"));
				c.setTelefone(rs.getString("cli_telefone"));
				c.setCep(rs.getInt("cli_cep"));
				c.setBairro(rs.getInt("cli_bairro"));
				c.setCidade(rs.getInt("cli_cidade"));
				c.setNumero(rs.getInt("cli_numero"));
				
				minhaLista.add(c);
				Collections.reverse(minhaLista);
			}

			smt.close();
			rs.close();

			return minhaLista;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		}
	// -------------------------------------------------------------------------------------------------------------------------------------------------

	public List<Cliente> getList(String nome) {

		try {
			String sql = "select * from cliente where cli_nome like ?";

			PreparedStatement smt = con.prepareStatement(sql);

			smt.setString(1, nome);

			ResultSet rs = smt.executeQuery();

			List<Cliente> minhaLista = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();

				c.setId(rs.getInt("cli_id"));
				c.setNome(rs.getString("cli_nome"));
				c.setTelefone(rs.getString("cli_telefone"));
				c.setCep(rs.getInt("cli_cep"));
				c.setBairro(rs.getInt("cli_bairro"));
				c.setCidade(rs.getInt("cli_cidade"));
				c.setNumero(rs.getInt("cli_numero"));

				minhaLista.add(c);
			}

			smt.close();
			rs.close();

			return minhaLista;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------

	public Cliente consulta(int id){
	      
	      Cliente c = new Cliente();
	      String sql = "select * from cliente where id=?";
	      try{
	          
	PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
	      smt.setInt(1, id);
	ResultSet rs = smt.executeQuery();
	     
	      rs.next();   
	     
	      c.setId(rs.getInt("id"));
	      c.setNome(rs.getString("nome"));
	              
	      }catch(Exception e){
	       
	      }
	      return c; 
	  } 

}
