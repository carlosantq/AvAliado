package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Aluno;
import dominio.TipoPessoa;

public class AlunoDao implements IDAO<Aluno>{

	@Override
	public List<Aluno> buscarTodos() {
		List<Aluno> resultado = new ArrayList<Aluno>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Pessoa JOIN Aluno USING(matricula)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoid")));
				aluno.setNome(rs.getString("nome"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setPeriodo(rs.getInt("periodo"));
				resultado.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public Aluno buscar(int matricula) {
		Aluno resultado = new Aluno();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Pessoa JOIN Aluno USING(matricula) WHERE matricula='"+matricula+"';";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoid")));
				resultado.setNome(rs.getString("nome"));
				resultado.setTelefone(rs.getString("telefone"));
				resultado.setEmail(rs.getString("email"));
				resultado.setPeriodo(rs.getInt("periodo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Aluno buscar(Aluno elemento) {
		Aluno resultado = new Aluno();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Aluno JOIN Pessoa WHERE Aluno.matricula='"+elemento.getMatricula()+"' AND Aluno.matricula=Pessoa.matricula;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoid")));
				resultado.setNome(rs.getString("nome"));
				resultado.setTelefone(rs.getString("telefone"));
				resultado.setEmail(rs.getString("email"));
				resultado.setPeriodo(rs.getInt("periodo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void inserir(Aluno novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Aluno VALUES (?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, novo.getMatricula());
			ps.setInt(2, novo.getTipoid().ordinal());
			ps.setString(3, novo.getNome());
			ps.setString(4, novo.getTelefone());
			ps.setString(5, novo.getEmail());
			ps.setInt(6, novo.getPeriodo());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Aluno elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Aluno elemento) {
		// TODO Auto-generated method stub
		
	}

}
