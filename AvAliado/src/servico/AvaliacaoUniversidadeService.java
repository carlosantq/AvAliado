package servico;

import java.util.List;

import javax.inject.Inject;

import dao.AvaliacaoUniversidadeDao;
import dominio.AvaliacaoUniversidade;

public class AvaliacaoUniversidadeService implements IServico<AvaliacaoUniversidade>{

	@Inject
	private AvaliacaoUniversidadeDao avaliacaoDao;
	
	public AvaliacaoUniversidadeService(){
		avaliacaoDao = new AvaliacaoUniversidadeDao();
	}
	
	@Override
	public List<AvaliacaoUniversidade> buscarTodos() {
		return avaliacaoDao.buscarTodos();
	}

	@Override
	public AvaliacaoUniversidade buscar(AvaliacaoUniversidade elemento) {
		return avaliacaoDao.buscar(elemento);
	}

	@Override
	public void inserir(AvaliacaoUniversidade novo) {
		avaliacaoDao.inserir(novo);
	}

	@Override
	public void atualizar(AvaliacaoUniversidade elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AvaliacaoUniversidade elemento) {
		// TODO Auto-generated method stub
		
	}
	
	public List<AvaliacaoUniversidade> buscarPorId(int id){
		return avaliacaoDao.buscarPorId(id);
	}
	
	public List<AvaliacaoUniversidade> buscarPorMatricula(int matricula){
		return avaliacaoDao.buscarPorMatricula(matricula);
	}
	
	public AvaliacaoUniversidade buscarPorPessoaEUniversidade(int matricula, int universidadeId){
		return avaliacaoDao.buscarPorPessoaEUniversidade(matricula, universidadeId);
	}

}
