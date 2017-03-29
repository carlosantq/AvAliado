package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GerenciarConexao;
import dominio.Professor;

public class ProfessorDao implements IDAO<Professor> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> buscarTodos() {
		//System.out.println("Fui chamado!!");

		List<Professor> resultado = new ArrayList<Professor>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Professor JOIN Pessoa USING(matricula)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setMatricula(rs.getInt("matricula"));
				// Professor.setTipoid(rs.getCharacterStream("tipoid"));
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("hiding")
	@Override
	public void inserir(Professor novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Professor VALUES (?, ?)";
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, novo.getMatricula());
			// Professor.setTipoid(rs.getCharacterStream("tipoid"));
			ps.setString(2, novo.getNome());
			ps.setInt(3, novo.getTelefone());
			ps.setString(4, novo.getEmail());
			ps.setInt(5, novo.getDidaticaLike());
			ps.setInt(6, novo.getDidaticaDislike());
			ps.setInt(7, novo.getProvasLike());
			ps.setInt(8, novo.getProvasDislike());
			ps.setInt(9, novo.getPersonalidadeLike());
			ps.setInt(10, novo.getPersonalidadeDislike());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Professor buscar(Professor elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
