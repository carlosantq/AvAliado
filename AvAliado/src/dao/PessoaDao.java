package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GerenciarConexao;
import dominio.Pessoa;

public class PessoaDao implements IDAO<Pessoa>{

	@Override
	public List<Pessoa> buscarTodos() {
		List<Pessoa> resultado = new ArrayList<Pessoa>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Pessoa";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setMatricula(rs.getInt("matricula"));
				// pessoa.setTipoid(rs.getCharacterStream("tipoid"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setTelefone(rs.getInt("telefone"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				resultado.add(pessoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	@Override
	public Pessoa buscar(Pessoa elemento) {
		Pessoa resultado = new Pessoa();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Pessoa WHERE matricula='"+elemento.getMatricula()+"';";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatricula(rs.getInt("matricula"));
				// resultado.setTipoid(rs.getCharacterStream("tipoid"));
				resultado.setNome(rs.getString("nome"));
				resultado.setTelefone(rs.getInt("telefone"));
				resultado.setEmail(rs.getString("email"));
				resultado.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void inserir(Pessoa novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Pessoa VALUES (?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, novo.getMatricula());
			//tipoid faltando
			ps.setString(2, novo.getNome());
			ps.setInt(3, novo.getTelefone());
			ps.setString(4, novo.getEmail());
			ps.setString(5, novo.getSenha());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Pessoa elemento) {
		// TODO Auto-generated method stub
		
	}
	
//	public Pessoa logar(Pessoa elemento) {
//		Pessoa resultado = new Pessoa();
//		Connection con = GerenciarConexao.getConexao();
//		String sql = "SELECT matricula, senha FROM Pessoa WHERE matricula='"+elemento.getMatricula()+"' AND senha='"+elemento.getSenha()+"';";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				resultado.setMatricula(rs.getInt("matricula"));
//				// resultado.setTipoid(rs.getCharacterStream("tipoid"));
//				resultado.setNome(rs.getString("nome"));
//				resultado.setTelefone(rs.getInt("telefone"));
//				resultado.setEmail(rs.getString("email"));
//				resultado.setSenha(rs.getString("senha"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return resultado;
//	}

}
