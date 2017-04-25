package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Disciplina;
import dominio.Professor;
import dominio.TipoPessoa;

public class DisciplinaDao implements IDAO<Disciplina>{

	@Override
	public List<Disciplina> buscarTodos() {
		List<Disciplina> resultado = new ArrayList<Disciplina>();
		
		Disciplina d1 = new Disciplina();
		d1.setId(123);
		d1.setNome("ITP");
		d1.setNotaDificuldade(100);
		d1.setNotaRecomendacao(100);
		d1.setNotaRelevancia(100);
		resultado.add(d1);
		
		Disciplina d2 = new Disciplina();
		d2.setId(234);
		d2.setNome("FMC II");
		d2.setNotaDificuldade(23);
		d2.setNotaRecomendacao(14);
		d2.setNotaRelevancia(80);
		resultado.add(d2);
		
		Disciplina d3 = new Disciplina();
		d3.setId(345);
		d3.setNome("Testes S2");
		d3.setNotaDificuldade(30);
		d3.setNotaRecomendacao(10);
		d3.setNotaRelevancia(1);
		resultado.add(d3);

		return resultado;
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
