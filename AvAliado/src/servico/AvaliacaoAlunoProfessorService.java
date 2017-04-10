package servico;

import java.util.List;

import javax.inject.Inject;

import dao.AvaliacaoAlunoProfessorDao;
import dominio.AvaliacaoAlunoProfessor;

public class AvaliacaoAlunoProfessorService implements IServico<AvaliacaoAlunoProfessor>{
	
	@Inject
	private AvaliacaoAlunoProfessorDao avaliacaoAPDao;
	
	public AvaliacaoAlunoProfessorService(){
		avaliacaoAPDao = new AvaliacaoAlunoProfessorDao();
	}

	@Override
	public List<AvaliacaoAlunoProfessor> buscarTodos() {
		return avaliacaoAPDao.buscarTodos();
	}

	@Override
	public AvaliacaoAlunoProfessor buscar(AvaliacaoAlunoProfessor elemento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<AvaliacaoAlunoProfessor> buscarPorMatricula(int matricula) {
		return avaliacaoAPDao.buscarPorMatricula(matricula);
	}
	
	public List<AvaliacaoAlunoProfessor> buscarRecentes(int matricula) {
		return avaliacaoAPDao.buscarRecentes(matricula);
	}
		
	@Override
	public void inserir(AvaliacaoAlunoProfessor novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(AvaliacaoAlunoProfessor elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AvaliacaoAlunoProfessor elemento) {
		// TODO Auto-generated method stub
	}
}

