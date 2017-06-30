package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GerenciarConexao;
import dominio.TipoPessoa;
import dominio.Usuario;

public class UsuarioDao implements IDAO<Usuario>{

	@Override
	public List<Usuario> buscarTodos() {
		List<Usuario> resultado = new ArrayList<Usuario>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Usuario";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setMatricula(rs.getInt("matricula"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoId")));
				resultado.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Usuario buscar(Usuario elemento) {
		Usuario resultado = new Usuario();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Usuario WHERE matricula='"+elemento.getMatricula()+"';";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setSenha(rs.getString("senha"));
				resultado.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public Usuario buscar(int matricula) {
		Usuario resultado = new Usuario();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Usuario WHERE matricula='"+matricula+"';";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setSenha(rs.getString("senha"));
				resultado.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void inserir(Usuario novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Usuario VALUES (?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, novo.getMatricula());
			ps.setString(2, novo.getSenha());
			ps.setInt(3, novo.getTipoid().ordinal());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Usuario elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Usuario elemento) {
		// TODO Auto-generated method stub
		
	}

}
