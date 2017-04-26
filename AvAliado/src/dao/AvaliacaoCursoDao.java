package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.AvaliacaoCurso;

public class AvaliacaoCursoDao implements IDAO<AvaliacaoCurso>{

	@Override
	public List<AvaliacaoCurso> buscarTodos() {
		List<AvaliacaoCurso> resultado = new ArrayList<AvaliacaoCurso>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoCurso";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoCurso avaliacao = new AvaliacaoCurso();
				avaliacao.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				avaliacao.setCursoId(rs.getInt("cursoID"));
				avaliacao.setDificuldade(rs.getBoolean("dificuldade"));
				avaliacao.setFlexibilidade(rs.getBoolean("flexibilidade"));
				avaliacao.setMercadoDeTrabalho(rs.getBoolean("mercadoDeTrabalho"));
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
	public AvaliacaoCurso buscar(AvaliacaoCurso elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(AvaliacaoCurso novo) {
		Connection con = GerenciarConexao.getConexao();
        String sql = "INSERT INTO AvaliacaoCurso VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, novo.getMatriculaPessoa());
            ps.setInt(2, novo.getCursoId());
            ps.setBoolean(3, novo.getDificuldade());
            ps.setBoolean(4, novo.getFlexibilidade());
            ps.setBoolean(5, novo.getMercadoDeTrabalho());
            ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
            ps.setString(7, novo.getComentario());
            ps.executeUpdate();
            
            CallableStatement cs = con.prepareCall("{call atualizar_notas_curso(?)}");
            cs.setInt(1, novo.getCursoId());
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
	public void remover(AvaliacaoCurso elemento) {
		// TODO Auto-generated method stub
		
	}
	
	public List<AvaliacaoCurso> buscarPorId(int id){
		List<AvaliacaoCurso> resultado = new ArrayList<AvaliacaoCurso>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoCurso WHERE cursoId='"+id+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoCurso avaliacao = new AvaliacaoCurso();
				avaliacao.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				avaliacao.setCursoId(rs.getInt("cursoID"));
				avaliacao.setDificuldade(rs.getBoolean("dificuldade"));
				avaliacao.setFlexibilidade(rs.getBoolean("flexibilidade"));
				avaliacao.setMercadoDeTrabalho(rs.getBoolean("mercadoDeTrabalho"));
				avaliacao.setData(rs.getDate("data"));
				avaliacao.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public List<AvaliacaoCurso> buscarPorMatricula(int matricula){
		List<AvaliacaoCurso> resultado = new ArrayList<AvaliacaoCurso>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoCurso WHERE matriculaPessoa='"+matricula+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoCurso avaliacao = new AvaliacaoCurso();
				avaliacao.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				avaliacao.setCursoId(rs.getInt("cursoID"));
				avaliacao.setDificuldade(rs.getBoolean("dificuldade"));
				avaliacao.setFlexibilidade(rs.getBoolean("flexibilidade"));
				avaliacao.setMercadoDeTrabalho(rs.getBoolean("mercadoDeTrabalho"));
				avaliacao.setData(rs.getDate("data"));
				avaliacao.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public AvaliacaoCurso buscarPorPessoaECurso(int matricula, int cursoId){
		AvaliacaoCurso resultado = new AvaliacaoCurso();
		Connection con = GerenciarConexao.getConexao();
        String sql = "SELECT * FROM AvaliacaoCurso WHERE matriculaPessoa='"+matricula+"' AND cursoID='"+cursoId+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				resultado.setCursoId(rs.getInt("cursoID"));
				resultado.setDificuldade(rs.getBoolean("dificuldade"));
				resultado.setFlexibilidade(rs.getBoolean("flexibilidade"));
				resultado.setMercadoDeTrabalho(rs.getBoolean("mercadoDeTrabalho"));
				resultado.setData(rs.getDate("data"));
				resultado.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
			}
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return resultado;
	}

}
