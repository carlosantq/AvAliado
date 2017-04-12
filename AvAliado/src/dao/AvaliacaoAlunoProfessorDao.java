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
	
	public AvaliacaoAlunoProfessor buscarPorAlunoEProfessor(int matriculaProfessor, int matriculaAluno){
		
		AvaliacaoAlunoProfessor resultado = new AvaliacaoAlunoProfessor();
		Connection con = GerenciarConexao.getConexao();
        String sql = "SELECT * FROM AvaliacaoAlunoProfessor WHERE matriculaProfessor='"+matriculaProfessor+"' AND matriculaAluno='"+matriculaAluno+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultado.setMatriculaAluno(rs.getInt("matriculaAluno"));
                resultado.setMatriculaProfessor(rs.getInt("matriculaProfessor"));
                resultado.setDidatica(rs.getBoolean("didatica"));
                resultado.setProvas(rs.getBoolean("provas"));
                resultado.setPersonalidade(rs.getBoolean("personalidade"));
                resultado.setData(rs.getDate("data"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return resultado;
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
		Connection con = GerenciarConexao.getConexao();
        String sql = "INSERT INTO AvaliacaoAlunoProfessor VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, novo.getMatriculaAluno());
            ps.setInt(2, novo.getMatriculaProfessor());
            ps.setBoolean(3, novo.getDidatica());
            ps.setBoolean(4, novo.getProvas());
            ps.setBoolean(5, novo.getPersonalidade());
            ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
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
	public void remover(AvaliacaoAlunoProfessor elemento) {
		// TODO Auto-generated method stub
		
	}
}
