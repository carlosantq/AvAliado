package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GerenciarConexao;
import dominio.Professor;
import dominio.TipoPessoa;

public class ProfessorDao implements IDAO<Professor> {

	@Override
	public List<Professor> buscarTodos() {
		List<Professor> resultado = new ArrayList<Professor>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Professor JOIN Pessoa USING(matricula)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setMatricula(rs.getInt("matricula"));
				professor.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoid")));
				professor.setNome(rs.getString("nome"));
				professor.setTelefone(rs.getInt("telefone"));
				professor.setEmail(rs.getString("email"));
				professor.setNotaDidatica(rs.getInt("notaDidatica"));
				professor.setNotaProvas(rs.getInt("notaProvas"));
				professor.setNotaPersonalidade(rs.getInt("notaPersonalidade"));
				resultado.add(professor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	@Override
	public Professor buscar(Professor elemento) {
		Professor resultado = new Professor();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Pessoa JOIN Professor USING(matricula) WHERE matricula='"+elemento.getMatricula()+"';";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoid")));
				resultado.setNome(rs.getString("nome"));
				resultado.setTelefone(rs.getInt("telefone"));
				resultado.setEmail(rs.getString("email"));
				resultado.setNotaDidatica(rs.getInt("notaDidatica"));
				resultado.setNotaProvas(rs.getInt("notaProvas"));
				resultado.setNotaPersonalidade(rs.getInt("notaPersonalidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public Professor buscar(int matricula) {
		Professor resultado = new Professor();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Pessoa JOIN Professor USING(matricula) WHERE matricula='"+matricula+"';";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatricula(rs.getInt("matricula"));
				resultado.setTipoid(TipoPessoa.fromInteger(rs.getInt("tipoid")));
				resultado.setNome(rs.getString("nome"));
				resultado.setTelefone(rs.getInt("telefone"));
				resultado.setEmail(rs.getString("email"));
				resultado.setNotaDidatica(rs.getInt("notaDidatica"));
				resultado.setNotaProvas(rs.getInt("notaProvas"));
				resultado.setNotaPersonalidade(rs.getInt("notaPersonalidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public Professor buscarNotas(int matricula){
		Professor resultado = new Professor();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT CAST(((SELECT COUNT(provas) FROM AvaliacaoAlunoProfessor WHERE matriculaProfessor='"+matricula+"' and "
				+ "provas=true)/notaProvas)*100 AS decimal(10, 2)) AS notaProvas, CAST(((SELECT COUNT(didatica) FROM AvaliacaoAlunoProfessor "
				+ "WHERE matriculaProfessor='"+matricula+"' and didatica=true)/notaDidatica)*100 AS decimal(10, 2)) AS notaDidatica, "
				+ "CAST(((SELECT COUNT(personalidade) FROM AvaliacaoAlunoProfessor WHERE matriculaProfessor='"+matricula+"' and "
				+ "personalidade=true)/notaPersonalidade)*100 AS decimal(10, 2)) AS notaPersonalidade FROM Professor WHERE matricula='"+matricula+"';";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				resultado.setMatricula(matricula);
				resultado.setNotaDidatica(rs.getInt("notaDidatica"));
				resultado.setNotaProvas(rs.getInt("notaProvas"));
				resultado.setNotaPersonalidade(rs.getInt("notaPersonalidade"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public void inserir(Professor novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Professor VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, novo.getMatricula());
			ps.setInt(2, novo.getTipoid().ordinal());
			ps.setString(3, novo.getNome());
			ps.setInt(4, novo.getTelefone());
			ps.setString(5, novo.getEmail());
			ps.setInt(6, novo.getNotaDidatica());
			ps.setInt(7, novo.getNotaProvas());
			ps.setInt(8, novo.getNotaPersonalidade());
			
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
	public void remover(Professor elemento) {
		// TODO Auto-generated method stub
		
	}

	

}
