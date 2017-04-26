package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.AvaliacaoDisciplina;

public class AvaliacaoDisciplinaDao implements IDAO<AvaliacaoDisciplina>{

	@Override
	public List<AvaliacaoDisciplina> buscarTodos() {
		List<AvaliacaoDisciplina> resultado = new ArrayList<AvaliacaoDisciplina>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoAlunoDisciplinaOferta";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoDisciplina avaliacao = new AvaliacaoDisciplina();
				avaliacao.setMatriculaAluno(rs.getInt("matriculaAluno"));
				avaliacao.setDisciplinaId(rs.getString("disciplinaID"));
				avaliacao.setProfessorId(rs.getInt("professorID"));
				avaliacao.setAno(rs.getInt("ano"));
				avaliacao.setSemestre(rs.getInt("semestre"));
				avaliacao.setRelevancia(rs.getBoolean("relevancia"));
				avaliacao.setDificuldade(rs.getBoolean("dificuldade"));
				avaliacao.setRecomendacao(rs.getBoolean("recomendacao"));
				avaliacao.setCobranca(rs.getBoolean("cobranca"));
				avaliacao.setData(rs.getDate("data"));
				avaliacao.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public AvaliacaoDisciplina buscar(AvaliacaoDisciplina elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(AvaliacaoDisciplina novo) {
		Connection con = GerenciarConexao.getConexao();
        String sql = "INSERT INTO AvaliacaoAlunoDisciplinaOferta VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, novo.getMatriculaAluno());
            ps.setString(2, novo.getDisciplinaId());
            ps.setInt(3, novo.getProfessorId());
            ps.setInt(4, novo.getAno());
            ps.setInt(5, novo.getSemestre());
            ps.setBoolean(6, novo.getRelevancia());
            ps.setBoolean(7, novo.getDificuldade());
            ps.setBoolean(8, novo.getRecomendacao());
            ps.setBoolean(9, novo.getCobranca());
            ps.setDate(10, new java.sql.Date(System.currentTimeMillis()));
            ps.setString(11, novo.getComentario());
            ps.executeUpdate();
            CallableStatement cs = con.prepareCall("{atualizar_notas_disciplina(?,?,?,?)}");
            cs.setString(1, novo.getDisciplinaId());
            cs.setInt(2, novo.getProfessorId());
            cs.setInt(3, novo.getAno());
            cs.setInt(4, novo.getSemestre());
            cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AvaliacaoDisciplina elemento) {
		// TODO Auto-generated method stub
		
	}
	
	public List<AvaliacaoDisciplina> buscarPorId(String id){
		List<AvaliacaoDisciplina> resultado = new ArrayList<AvaliacaoDisciplina>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoAlunoDisciplinaOferta WHERE disciplinaId='"+id+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoDisciplina avaliacao = new AvaliacaoDisciplina();
				avaliacao.setMatriculaAluno(rs.getInt("matriculaAluno"));
				avaliacao.setDisciplinaId(rs.getString("disciplinaID"));
				avaliacao.setProfessorId(rs.getInt("professorID"));
				avaliacao.setAno(rs.getInt("ano"));
				avaliacao.setSemestre(rs.getInt("semestre"));
				avaliacao.setRelevancia(rs.getBoolean("relevancia"));
				avaliacao.setDificuldade(rs.getBoolean("dificuldade"));
				avaliacao.setRecomendacao(rs.getBoolean("recomendacao"));
				avaliacao.setCobranca(rs.getBoolean("cobranca"));
				avaliacao.setData(rs.getDate("data"));
				avaliacao.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public List<AvaliacaoDisciplina> buscarPorMatricula(int matricula){
		List<AvaliacaoDisciplina> resultado = new ArrayList<AvaliacaoDisciplina>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoAlunoDisciplinaOferta WHERE matriculaAluno='"+matricula+"'" + "OR professorId='"+matricula+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoDisciplina avaliacao = new AvaliacaoDisciplina();
				avaliacao.setMatriculaAluno(rs.getInt("matriculaAluno"));
				avaliacao.setDisciplinaId(rs.getString("disciplinaID"));
				avaliacao.setProfessorId(rs.getInt("professorID"));
				avaliacao.setAno(rs.getInt("ano"));
				avaliacao.setSemestre(rs.getInt("semestre"));
				avaliacao.setRelevancia(rs.getBoolean("relevancia"));
				avaliacao.setDificuldade(rs.getBoolean("dificuldade"));
				avaliacao.setRecomendacao(rs.getBoolean("recomendacao"));
				avaliacao.setCobranca(rs.getBoolean("cobranca"));
				avaliacao.setData(rs.getDate("data"));
				avaliacao.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public AvaliacaoDisciplina buscarPorPessoaEDisciplina(int matricula, String disciplinaId){
		AvaliacaoDisciplina resultado = new AvaliacaoDisciplina();
		Connection con = GerenciarConexao.getConexao();
        String sql = "SELECT * FROM AvaliacaoAlunoDisciplinaOferta WHERE (matriculaAluno='"+matricula+"' OR professorId='"+matricula+"') AND disciplinaID='"+disciplinaId+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatriculaAluno(rs.getInt("matriculaAluno"));
				resultado.setDisciplinaId(rs.getString("disciplinaID"));
				resultado.setProfessorId(rs.getInt("professorID"));
				resultado.setAno(rs.getInt("ano"));
				resultado.setSemestre(rs.getInt("semestre"));
				resultado.setRelevancia(rs.getBoolean("relevancia"));
				resultado.setDificuldade(rs.getBoolean("dificuldade"));
				resultado.setRecomendacao(rs.getBoolean("recomendacao"));
				resultado.setCobranca(rs.getBoolean("cobranca"));
				resultado.setData(rs.getDate("data"));
				resultado.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
			}
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return resultado;
	}

}
