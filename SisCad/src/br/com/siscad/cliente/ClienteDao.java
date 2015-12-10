package br.com.siscad.cliente;

import java.sql.*;
import java.util.*;

public class ClienteDao {

	private Connection con;

	public ClienteDao(Connection con) {
		this.con = con;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	public void salvar(Cliente c) throws SQLException {

		String sql = "insert into cliente(nome)values(?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());

			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
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
		String sql = "update cliente set nome = ? where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getId());
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
	public List<Cliente> getList() {

		String sql = "select * from cliente";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Cliente> minhaLista = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));

				minhaLista.add(c);
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

	public List<Cliente> getList(int id) {

		String sql = "select * from cliente where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			List<Cliente> minhaLista = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));

				minhaLista.add(c);
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

	// -------------------------------------------------------------------------------------------------------------------------------------------------

	public List<Cliente> getList(String nome) {

		try {
			String sql = "select * from cliente where nome like ?";

			PreparedStatement smt = con.prepareStatement(sql);

			smt.setString(1, nome);

			ResultSet rs = smt.executeQuery();

			List<Cliente> minhaLista = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente c = new Cliente();

				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));

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
}
