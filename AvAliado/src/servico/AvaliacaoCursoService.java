package servico;

import java.util.List;

import javax.inject.Inject;

import dao.AvaliacaoCursoDao;
import dominio.AvaliacaoCurso;

public class AvaliacaoCursoService implements IServico<AvaliacaoCurso>{

	@Inject
	private AvaliacaoCursoDao cursoDao;
	
	public AvaliacaoCursoService(){
		cursoDao = new AvaliacaoCursoDao();
	}
	
	@Override
	public List<AvaliacaoCurso> buscarTodos() {
		return cursoDao.buscarTodos();
	}

	@Override
	public AvaliacaoCurso buscar(AvaliacaoCurso elemento) {
		return cursoDao.buscar(elemento);
	}

	@Override
	public void inserir(AvaliacaoCurso novo) {
		cursoDao.inserir(novo);
	}

	@Override
	public void atualizar(AvaliacaoCurso elemento) {
		cursoDao.atualizar(elemento);
	}

	@Override
	public void remover(AvaliacaoCurso elemento) {
		cursoDao.remover(elemento);
	}
	
	public List<AvaliacaoCurso> buscarPorId(int id){
		return cursoDao.buscarPorId(id);
	}
	
	public List<AvaliacaoCurso> buscarPorMatricula(int matricula){
		return cursoDao.buscarPorMatricula(matricula);
	}
	
	public AvaliacaoCurso buscarPorPessoaECurso(int matricula, int cursoId){
		return cursoDao.buscarPorPessoaECurso(matricula, cursoId);
	}

}
