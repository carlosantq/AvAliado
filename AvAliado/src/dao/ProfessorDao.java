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
				// Professor.setTipoid(rs.getCharacterStream("tipoid"));
				professor.setNome(rs.getString("nome"));
				professor.setTelefone(rs.getInt("telefone"));
				professor.setEmail(rs.getString("email"));
				professor.setSenha(rs.getString("senha"));
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
				// resultado.setTipoid(rs.getCharacterStream("tipoid"));
				resultado.setNome(rs.getString("nome"));
				resultado.setTelefone(rs.getInt("telefone"));
				resultado.setEmail(rs.getString("email"));
				resultado.setSenha(rs.getString("senha"));
				resultado.setNotaDidatica(rs.getInt("notaDidatica"));
				resultado.setNotaProvas(rs.getInt("notaProvas"));
				resultado.setNotaPersonalidade(rs.getInt("notaPersonalidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

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
			ps.setString(5, novo.getSenha());
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
