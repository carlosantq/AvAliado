package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Disciplina;

public class DisciplinaDao implements IDAO<Disciplina>{

	@Override
	public List<Disciplina> buscarTodos() {
		List<Disciplina> resultado = new ArrayList<Disciplina>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Disciplina JOIN DisciplinaOferta USING(id)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getString("id"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setCursoId(rs.getInt("cursoID"));
				disciplina.setProfessorId(rs.getInt("professorID"));
				disciplina.setAno(rs.getInt("ano"));
				disciplina.setSemestre(rs.getInt("semestre"));
				disciplina.setNotaRelevancia(rs.getInt("notaRelevancia"));
				disciplina.setNotaDificuldade(rs.getInt("notaDificuldade"));
				disciplina.setNotaRecomendacao(rs.getInt("notaRecomendacao"));
				disciplina.setNotaCobranca(rs.getInt("notaCobranca"));
				resultado.add(disciplina);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Disciplina buscar(Disciplina elemento) {
		Disciplina resultado = new Disciplina();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Disciplina JOIN DisciplinaOferta USING(id) WHERE id='"+elemento.getId()+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setId(rs.getString("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setCursoId(rs.getInt("cursoID"));
				resultado.setProfessorId(rs.getInt("professorID"));
				resultado.setAno(rs.getInt("ano"));
				resultado.setSemestre(rs.getInt("semestre"));
				resultado.setNotaRelevancia(rs.getInt("notaRelevancia"));
				resultado.setNotaDificuldade(rs.getInt("notaDificuldade"));
				resultado.setNotaRecomendacao(rs.getInt("notaRecomendacao"));
				resultado.setNotaCobranca(rs.getInt("notaCobranca"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public Disciplina buscar(String id) {
		Disciplina resultado = new Disciplina();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Disciplina JOIN DisciplinaOferta USING(id) WHERE id='"+id+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setId(rs.getString("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setCursoId(rs.getInt("cursoID"));
				resultado.setProfessorId(rs.getInt("professorID"));
				resultado.setAno(rs.getInt("ano"));
				resultado.setSemestre(rs.getInt("semestre"));
				resultado.setNotaRelevancia(rs.getInt("notaRelevancia"));
				resultado.setNotaDificuldade(rs.getInt("notaDificuldade"));
				resultado.setNotaRecomendacao(rs.getInt("notaRecomendacao"));
				resultado.setNotaCobranca(rs.getInt("notaCobranca"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void inserir(Disciplina novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Disciplina VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, novo.getId());
			ps.setString(2, novo.getNome());
			ps.setInt(3, novo.getCursoId());
			ps.setInt(4, novo.getProfessorId());
			ps.setInt(5, novo.getAno());
			ps.setInt(6, novo.getSemestre());
			ps.setInt(7, novo.getNotaRelevancia());
			ps.setInt(8, novo.getNotaDificuldade());
			ps.setInt(9, novo.getNotaRecomendacao());
			ps.setInt(10, novo.getNotaCobranca());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Disciplina elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Disciplina elemento) {
		// TODO Auto-generated method stub	
	}
	
	public Disciplina buscarNotas(String id){
		Disciplina resultado = new Disciplina();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT CAST(((SELECT COUNT(relevancia) FROM AvaliacaoAlunoDisciplinaOferta WHERE disciplinaID='"+id+"' and "
				+ "relevancia=true)/notaRelevancia)*100 AS decimal(10, 2)) AS notaRelevancia, CAST(((SELECT COUNT(dificuldade) FROM AvaliacaoAlunoDisciplinaOferta "
				+ "WHERE disciplinaID='"+id+"' and dificuldade=true)/notaDificuldade)*100 AS decimal(10, 2)) AS notaDificuldade, "
				+ "CAST(((SELECT COUNT(recomendacao) FROM AvaliacaoAlunoDisciplinaOferta WHERE disciplinaID='"+id+"' and "
				+ "recomendacao=true)/notaRecomendacao)*100 AS decimal(10, 2)) AS notaRecomendacao, "
				+ "CAST(((SELECT COUNT(cobranca) FROM AvaliacaoAlunoDisciplinaOferta WHERE disciplinaID='"+id+"' and "
				+ "cobranca=true)/notaCobranca)*100 AS decimal(10, 2)) AS notaCobranca FROM DisciplinaOferta WHERE id='"+id+"';";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				resultado.setId(id);
				resultado.setNotaRelevancia(rs.getInt("notaRelevancia"));
				resultado.setNotaDificuldade(rs.getInt("notaDificuldade"));
				resultado.setNotaRecomendacao(rs.getInt("notaRecomendacao"));
				resultado.setNotaCobranca(rs.getInt("notaCobranca"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean buscarVinculo(int matriculaAluno, int idProfessor){
		boolean returnInformation = false;
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM VinculoAlunoDisciplinaOferta WHERE alunoID="+ matriculaAluno + " AND professorID =" + idProfessor;
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
	
	public boolean buscarVinculo1(int matriculaAluno, String disciplinaId){
		boolean returnInformation = false;
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM VinculoAlunoDisciplinaOferta WHERE alunoID="+ matriculaAluno + " AND disciplinaId ='" + disciplinaId+"'";
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
	
	public boolean buscarVinculo2(int matriculaAluno, int idProfessor, int ano, int semestre, String disciplinaId){
		boolean returnInformation = false;
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM VinculoAlunoDisciplinaOferta WHERE alunoID="+ matriculaAluno + " AND professorID =" + idProfessor + " AND ano ="+ano+" AND semestre="+semestre+"AND disciplinaID='"+disciplinaId+"'";
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

}
