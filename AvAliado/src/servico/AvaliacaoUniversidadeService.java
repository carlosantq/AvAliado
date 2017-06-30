package servico;

import java.util.List;

import javax.inject.Inject;

import dao.AvaliacaoUniversidadeDao;
import dominio.AvaliacaoUniversidade;

public class AvaliacaoUniversidadeService implements IServico<AvaliacaoUniversidade>{

	@Inject
	private AvaliacaoUniversidadeDao universidadeDao;
	
	public AvaliacaoUniversidadeService(){
		universidadeDao = new AvaliacaoUniversidadeDao();
	}
	
	@Override
	public List<AvaliacaoUniversidade> buscarTodos() {
		return universidadeDao.buscarTodos();
	}

	@Override
	public AvaliacaoUniversidade buscar(AvaliacaoUniversidade elemento) {
		return universidadeDao.buscar(elemento);
	}

	@Override
	public void inserir(AvaliacaoUniversidade novo) {
		universidadeDao.inserir(novo);
	}

	@Override
	public void atualizar(AvaliacaoUniversidade elemento) {
		universidadeDao.atualizar(elemento);
	}

	@Override
	public void remover(AvaliacaoUniversidade elemento) {
		universidadeDao.remover(elemento);
	}
	
	public List<AvaliacaoUniversidade> buscarPorId(int id){
		return universidadeDao.buscarPorId(id);
	}
	
	public List<AvaliacaoUniversidade> buscarPorMatricula(int matricula){
		return universidadeDao.buscarPorMatricula(matricula);
	}
	
	public AvaliacaoUniversidade buscarPorPessoaEUniversidade(int matricula, int universidadeId){
		return universidadeDao.buscarPorPessoaEUniversidade(matricula, universidadeId);
	}

}
