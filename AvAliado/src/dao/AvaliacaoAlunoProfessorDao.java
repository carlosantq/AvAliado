package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.AvaliacaoAlunoProfessor;

public class AvaliacaoAlunoProfessorDao implements IDAO<AvaliacaoAlunoProfessor>{

	@Override
	public List<AvaliacaoAlunoProfessor> buscarTodos() {
		List<AvaliacaoAlunoProfessor> resultado = new ArrayList<AvaliacaoAlunoProfessor>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoAlunoProfessor";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoAlunoProfessor avaliacao = new AvaliacaoAlunoProfessor();
				avaliacao.setMatriculaAluno(rs.getInt("matriculaAluno"));
				avaliacao.setMatriculaProfessor(rs.getInt("matriculaProfessor"));
				avaliacao.setDidatica(rs.getBoolean("didatica"));
				avaliacao.setProvas(rs.getBoolean("provas"));
				avaliacao.setPersonalidade(rs.getBoolean("personalidade"));
				avaliacao.setData(rs.getDate("data"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public AvaliacaoAlunoProfessor buscar(AvaliacaoAlunoProfessor elemento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<AvaliacaoAlunoProfessor> buscarPorMatricula(int matricula){
		
		List<AvaliacaoAlunoProfessor> resultado = new ArrayList<AvaliacaoAlunoProfessor>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoAlunoProfessor WHERE matriculaProfessor='"+matricula+"' OR matriculaAluno='"+matricula+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoAlunoProfessor avaliacao = new AvaliacaoAlunoProfessor();
				avaliacao.setMatriculaAluno(rs.getInt("matriculaAluno"));
				avaliacao.setMatriculaProfessor(rs.getInt("matriculaProfessor"));
				avaliacao.setDidatica(rs.getBoolean("didatica"));
				avaliacao.setProvas(rs.getBoolean("provas"));
				avaliacao.setPersonalidade(rs.getBoolean("personalidade"));
				avaliacao.setData(rs.getDate("data"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public List<AvaliacaoAlunoProfessor> buscarRecentes(int matricula){
		List<AvaliacaoAlunoProfessor> resultado = new ArrayList<AvaliacaoAlunoProfessor>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoAlunoProfessor WHERE matriculaAluno='"+matricula+"' OR matriculaProfessor='"+matricula+"' ORDER BY data DESC LIMIT 3";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoAlunoProfessor avaliacao = new AvaliacaoAlunoProfessor();
				avaliacao.setMatriculaAluno(rs.getInt("matriculaAluno"));
				avaliacao.setMatriculaProfessor(rs.getInt("matriculaProfessor"));
				avaliacao.setDidatica(rs.getBoolean("didatica"));
				avaliacao.setProvas(rs.getBoolean("provas"));
				avaliacao.setPersonalidade(rs.getBoolean("personalidade"));
				avaliacao.setData(rs.getDate("data"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void inserir(AvaliacaoAlunoProfessor novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AvaliacaoAlunoProfessor elemento) {
		// TODO Auto-generated method stub
		
	}
}
