package servico;

import java.util.List;

import javax.inject.Inject;

import dao.DisciplinaDao;
import dominio.Disciplina;

public class DisciplinaService implements IServico<Disciplina>{
	
	@Inject
	private DisciplinaDao disciplinaDao;
	
	public DisciplinaService(){
		disciplinaDao = new DisciplinaDao();
	}

	@Override
	public List<Disciplina> buscarTodos() {
		return disciplinaDao.buscarTodos();
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
	public void atualizar(Disciplina elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Disciplina elemento) {
		// TODO Auto-generated method stub
		
	}
	
	public Disciplina buscarNotas(String id){
		return disciplinaDao.buscarNotas(id);
	}
	
	public Disciplina buscar(String id){
		return disciplinaDao.buscar(id);
	}
	
	public boolean buscarVinculo(int matriculaAluno, int idProfessor){
		return disciplinaDao.buscarVinculo(matriculaAluno, idProfessor);
	}
	
	public boolean buscarVinculo1(int matriculaAluno, String disciplinaId){
		return disciplinaDao.buscarVinculo1(matriculaAluno, disciplinaId);
	}
	
	public boolean buscarVinculo2(int matriculaAluno, int idProfessor, int ano, int semestre, String disciplinaId){
		return disciplinaDao.buscarVinculo2(matriculaAluno, idProfessor, ano, semestre, disciplinaId);
	}

}
