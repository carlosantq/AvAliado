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
		return avaliacaoAPDao.buscar(elemento);
	}
	
	public AvaliacaoAlunoProfessor buscarPorAlunoEProfessor(int matriculaProfessor, int matriculaAluno){
		return avaliacaoAPDao.buscarPorAlunoEProfessor(matriculaProfessor, matriculaAluno);
	}
	
	public List<AvaliacaoAlunoProfessor> buscarPorMatricula(int matricula) {
		return avaliacaoAPDao.buscarPorMatricula(matricula);
	}
	
	public List<AvaliacaoAlunoProfessor> buscarRecentes(int matricula) {
		return avaliacaoAPDao.buscarRecentes(matricula);
	}
		
	@Override
	public void inserir(AvaliacaoAlunoProfessor novo) {
		avaliacaoAPDao.inserir(novo);
	}

	@Override
	public void atualizar(AvaliacaoAlunoProfessor elemento) {
		avaliacaoAPDao.atualizar(elemento);
	}

	@Override
	public void remover(AvaliacaoAlunoProfessor elemento) {
		avaliacaoAPDao.remover(elemento);
	}
	
}

