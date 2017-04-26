package servico;

import java.util.List;

import dao.UniversidadeDao;
import dominio.Universidade;

public class UniversidadeService implements IServico<Universidade>{
	
	private UniversidadeDao universidadeDao;
	
	public UniversidadeService(){
		universidadeDao = new UniversidadeDao();
	}

	@Override
	public List<Universidade> buscarTodos() {
		return universidadeDao.buscarTodos();
	}

	@Override
	public Universidade buscar(Universidade elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Universidade novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Universidade elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Universidade elemento) {
		// TODO Auto-generated method stub
		
	}
	
	public Universidade buscarNotas(int id){
		return universidadeDao.buscarNotas(id);
	}
	
	public Universidade buscar(int id){
		return universidadeDao.buscar(id);
	}
	
	public boolean buscarVinculo(int matricula, int universidadeId){
		return universidadeDao.buscarVinculo(matricula, universidadeId);
	}
}
