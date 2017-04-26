package servico;

import java.util.List;

import javax.inject.Inject;

import dao.AlunoDao;
import dao.CursoDao;
import dominio.*;

public class CursoService implements IServico<Curso> {

	@Inject
	CursoDao cursoDao = new CursoDao();
	
	public CursoService() {
		cursoDao = new CursoDao();
	}
	
	@Override
	public List<Curso> buscarTodos() {
		return cursoDao.buscarTodos();
	}

	@Override
	public Curso buscar(Curso elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Curso novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Curso elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Curso elemento) {
		// TODO Auto-generated method stub
	}
	
	public Curso buscarNotas(int id){
		return cursoDao.buscarNotas(id);
	}
	
	public Curso buscar(int id){
		return cursoDao.buscar(id);
	}
	
	public boolean buscarVinculo(int matricula, int cursoId){
		return cursoDao.buscarVinculo(matricula, cursoId);
	}

}
