package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dominio.Disciplina;

public class DisciplinaDao implements IDAO<Disciplina>{

	@Override
	public List<Disciplina> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disciplina buscar(Disciplina elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Disciplina novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Disciplina elemento) {
		// TODO Auto-generated method stub
		
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

}
