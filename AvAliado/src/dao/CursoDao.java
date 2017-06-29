package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GerenciarConexao;

import dominio.Curso;

public class CursoDao implements IDAO<Curso> {

	@Override
	public List<Curso> buscarTodos() {
		List<Curso> resultado = new ArrayList<Curso>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Curso";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setNome(rs.getString("nome"));
				curso.setUniversidadeId(rs.getInt("universidadeID"));
				curso.setNotaDificuldade(rs.getInt("notaDificuldade"));
				curso.setNotaFlexibilidade(rs.getInt("notaFlexibilidade"));
				curso.setNotaMercadoDeTrabalho(rs.getInt("notaMercadoDeTrabalho"));
				resultado.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Curso buscar(Curso elemento) {
		Curso resultado = new Curso();
		
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Curso WHERE id="+elemento.getId();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setId(rs.getInt("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setUniversidadeId(rs.getInt("universidadeID"));
				resultado.setNotaDificuldade(rs.getInt("notaDificuldade"));
				resultado.setNotaFlexibilidade(rs.getInt("notaFlexibilidade"));
				resultado.setNotaMercadoDeTrabalho(rs.getInt("notaMercadoDeTrabalho"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public Curso buscar(int id) {
		Curso resultado = new Curso();
		
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Curso WHERE id="+id;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setId(rs.getInt("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setUniversidadeId(rs.getInt("universidadeID"));
				resultado.setNotaDificuldade(rs.getInt("notaDificuldade"));
				resultado.setNotaFlexibilidade(rs.getInt("notaFlexibilidade"));
				resultado.setNotaMercadoDeTrabalho(rs.getInt("notaMercadoDeTrabalho"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public void inserir(Curso novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Curso VALUES (?, ?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, novo.getId());
			ps.setString(2, novo.getNome());
			ps.setInt(3, novo.getUniversidadeId());
			ps.setInt(4, novo.getNotaDificuldade());
			ps.setInt(5, novo.getNotaFlexibilidade());
			ps.setInt(6, novo.getNotaMercadoDeTrabalho());
			
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
	public void remover(Curso elemento) {
		// TODO Auto-generated method stub
		
	}
	
	public Curso buscarNotas(int id){
		Curso resultado = new Curso();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT CAST(((SELECT COUNT(dificuldade) FROM AvaliacaoCurso WHERE cursoID='"+id+"' and "
				+ "dificuldade=true)/notaDificuldade)*100 AS decimal(10, 2)) AS notaDificuldade, CAST(((SELECT COUNT(flexibilidade) FROM AvaliacaoCurso "
				+ "WHERE cursoID='"+id+"' and flexibilidade=true)/notaFlexibilidade)*100 AS decimal(10, 2)) AS notaFlexibilidade, "
				+ "CAST(((SELECT COUNT(mercadoDeTrabalho) FROM AvaliacaoCurso WHERE cursoID='"+id+"' and "
				+ "mercadoDeTrabalho=true)/notaMercadoDeTrabalho)*100 AS decimal(10, 2)) AS notaMercadoDeTrabalho FROM Curso WHERE id='"+id+"';";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				resultado.setId(id);
				resultado.setNotaDificuldade(rs.getInt("notaDificuldade"));
				resultado.setNotaFlexibilidade(rs.getInt("notaFlexibilidade"));
				resultado.setNotaMercadoDeTrabalho(rs.getInt("notaMercadoDeTrabalho"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean buscarVinculo(int matricula, int cursoId){
		boolean returnInformation = false;
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM VinculoCurso WHERE pessoaID="+ matricula + " AND cursoID =" + cursoId;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				returnInformation = false;
			}else{
				returnInformation = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return returnInformation;
	}
	
	public String buscarNomeCurso(int matricula){
		String resultado = null;
		
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT nome FROM VinculoCurso JOIN Curso WHERE VinculoCurso.cursoID = Curso.id AND pessoaID="+matricula;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado = rs.getString("nome");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

}
