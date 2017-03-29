package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GerenciarConexao;
import dominio.Professor;

public class ProfessorDao {
	public List<Professor> buscarTodosProfessores(){
		
		System.out.println("Fui chamado!!");
		
		List<Professor> resultado = new ArrayList<Professor>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Professor JOIN Pessoa USING(matricula)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Professor professor = new Professor();
				professor.setMatricula(rs.getInt("matricula"));
				//Professor.setTipoid(rs.getCharacterStream("tipoid"));
				professor.setNome(rs.getString("nome"));
				professor.setTelefone(rs.getInt("telefone"));
				professor.setEmail(rs.getString("email"));
				professor.setDidaticaLike(rs.getInt("didatica_like"));
				professor.setDidaticaDislike(rs.getInt("didatica_dislike"));
				professor.setProvasLike(rs.getInt("provas_like"));
				professor.setProvasDislike(rs.getInt("provas_dislike"));
				professor.setPersonalidadeLike(rs.getInt("personalidade_like"));
				professor.setPersonalidadeDislike(rs.getInt("personalidade_dislike"));
				resultado.add(professor);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public void inserirProfessor (Professor professor){
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Professor VALUES (?, ?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, professor.getMatricula());
			//Professor.setTipoid(rs.getCharacterStream("tipoid"));
			ps.setString(2, professor.getNome());
			ps.setInt(3, professor.getTelefone());
			ps.setString(4, professor.getEmail());
			ps.setInt(5, professor.getDidaticaLike());
			ps.setInt(6, professor.getDidaticaDislike());
			ps.setInt(7, professor.getProvasLike());
			ps.setInt(8, professor.getProvasDislike());
			ps.setInt(9, professor.getPersonalidadeLike());
			ps.setInt(10, professor.getPersonalidadeDislike());
			ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
