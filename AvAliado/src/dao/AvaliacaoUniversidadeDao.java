package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.AvaliacaoUniversidade;

public class AvaliacaoUniversidadeDao implements IDAO<AvaliacaoUniversidade>{

	@Override
	public List<AvaliacaoUniversidade> buscarTodos() {
		List<AvaliacaoUniversidade> resultado = new ArrayList<AvaliacaoUniversidade>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoUniversidade";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoUniversidade avaliacao = new AvaliacaoUniversidade();
				avaliacao.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				avaliacao.setUniversidadeId(rs.getInt("universidadeID"));
				avaliacao.setEstrutura(rs.getBoolean("estrutura"));
				avaliacao.setVidaCultural(rs.getBoolean("vidaCultural"));
				avaliacao.setAuxilios(rs.getBoolean("auxilios"));
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
	public AvaliacaoUniversidade buscar(AvaliacaoUniversidade elemento) {
		AvaliacaoUniversidade resultado = new AvaliacaoUniversidade();
		Connection con = GerenciarConexao.getConexao();
        String sql = "SELECT * FROM AvaliacaoUniversidade WHERE matriculaPessoa='"+elemento.getMatriculaPessoa()+"' AND universidadeID='"+elemento.getUniversidadeId()+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				resultado.setUniversidadeId(rs.getInt("universidadeID"));
				resultado.setEstrutura(rs.getBoolean("estrutura"));
				resultado.setVidaCultural(rs.getBoolean("vidaCultural"));
				resultado.setAuxilios(rs.getBoolean("auxilios"));
				resultado.setData(rs.getDate("data"));
				resultado.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
			}
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return resultado;
	}

	@Override
	public void inserir(AvaliacaoUniversidade novo) {
		Connection con = GerenciarConexao.getConexao();
        String sql = "INSERT INTO AvaliacaoUniversidade VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, novo.getMatriculaPessoa());
            ps.setInt(2, novo.getUniversidadeId());
            ps.setBoolean(3, novo.getEstrutura());
            ps.setBoolean(4, novo.getVidaCultural());
            ps.setBoolean(5, novo.getAuxilios());
            ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
            ps.setString(7, novo.getComentario());
            ps.executeUpdate();
            
            CallableStatement cs = con.prepareCall("{call atualizar_notas_universidade(?)}");
            cs.setInt(1, novo.getUniversidadeId());
            cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void atualizar(AvaliacaoUniversidade elemento) {
		Connection con = GerenciarConexao.getConexao();
        String sql = "UPDATE AvaliacaoUniversidade SET estrutura="+elemento.getEstrutura()+", vidaCultural="+elemento.getVidaCultural()+", auxilios="+elemento.getAuxilios()+", data='"+ new java.sql.Date(System.currentTimeMillis()) +"', comentario='"+elemento.getComentario()+"' WHERE matriculaPessoa="+elemento.getMatriculaPessoa()+" AND universidadeID="+elemento.getUniversidadeId();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            CallableStatement cs = con.prepareCall("{call atualizar_notas_universidade(?)}");
            cs.setInt(1, elemento.getUniversidadeId());
            cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void remover(AvaliacaoUniversidade elemento) {
		Connection con = GerenciarConexao.getConexao();
        String sql = "DELETE FROM AvaliacaoUniversidade WHERE matriculaPessoa="+elemento.getMatriculaPessoa()+" AND universidadeID="+elemento.getUniversidadeId();
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            CallableStatement cs = con.prepareCall("{call atualizar_notas_universidade(?)}");
            cs.setInt(1, elemento.getUniversidadeId());
            cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public List<AvaliacaoUniversidade> buscarPorId(int id){
		List<AvaliacaoUniversidade> resultado = new ArrayList<AvaliacaoUniversidade>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoUniversidade WHERE universidadeId='"+id+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoUniversidade avaliacao = new AvaliacaoUniversidade();
				avaliacao.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				avaliacao.setUniversidadeId(rs.getInt("universidadeID"));
				avaliacao.setEstrutura(rs.getBoolean("estrutura"));
				avaliacao.setVidaCultural(rs.getBoolean("vidaCultural"));
				avaliacao.setAuxilios(rs.getBoolean("auxilios"));
				avaliacao.setData(rs.getDate("data"));
				avaliacao.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public List<AvaliacaoUniversidade> buscarPorMatricula(int matricula){
		List<AvaliacaoUniversidade> resultado = new ArrayList<AvaliacaoUniversidade>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM AvaliacaoUniversidade WHERE matriculaPessoa='"+matricula+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AvaliacaoUniversidade avaliacao = new AvaliacaoUniversidade();
				avaliacao.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				avaliacao.setUniversidadeId(rs.getInt("universidadeID"));
				avaliacao.setEstrutura(rs.getBoolean("estrutura"));
				avaliacao.setVidaCultural(rs.getBoolean("vidaCultural"));
				avaliacao.setAuxilios(rs.getBoolean("auxilios"));
				avaliacao.setData(rs.getDate("data"));
				avaliacao.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
				resultado.add(avaliacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public AvaliacaoUniversidade buscarPorPessoaEUniversidade(int matricula, int universidadeId){
		AvaliacaoUniversidade resultado = new AvaliacaoUniversidade();
		Connection con = GerenciarConexao.getConexao();
        String sql = "SELECT * FROM AvaliacaoUniversidade WHERE matriculaPessoa='"+matricula+"' AND universidadeID='"+universidadeId+"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatriculaPessoa(rs.getInt("matriculaPessoa"));
				resultado.setUniversidadeId(rs.getInt("universidadeID"));
				resultado.setEstrutura(rs.getBoolean("estrutura"));
				resultado.setVidaCultural(rs.getBoolean("vidaCultural"));
				resultado.setAuxilios(rs.getBoolean("auxilios"));
				resultado.setData(rs.getDate("data"));
				resultado.setComentario((rs.getString("comentario") == null || rs.getString("comentario") == "") ? "Não há comentário para esta avaliação." : rs.getString("comentario"));
			}
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return resultado;
	}

}
