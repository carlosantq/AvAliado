package servico;

import java.util.List;
import javax.inject.Inject;

import dao.AlunoDao;
import dominio.Aluno;

public class AlunoService implements IServico<Aluno>{
	
	@Inject
	AlunoDao alunoDao = new AlunoDao();
	
	public AlunoService(){
		alunoDao = new AlunoDao();
	}

	@Override
	public List<Aluno> buscarTodos() {
		return alunoDao.buscarTodos();
	}

	@Override
	public Aluno buscar(Aluno elemento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Aluno buscar(int matricula){
		return alunoDao.buscar(matricula);
	}

	@Override
	public void inserir(Aluno novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Aluno elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Aluno elemento) {
		// TODO Auto-generated method stub
		
	}

}
