package servico;

import java.util.List;

import javax.inject.Inject;

import dao.AvaliacaoDisciplinaDao;
import dominio.AvaliacaoDisciplina;

public class AvaliacaoDisciplinaService implements IServico<AvaliacaoDisciplina>{

	@Inject
	private AvaliacaoDisciplinaDao disciplinaDao;
	
	public AvaliacaoDisciplinaService(){
		disciplinaDao = new AvaliacaoDisciplinaDao();
	}
	
	@Override
	public List<AvaliacaoDisciplina> buscarTodos() {
		return disciplinaDao.buscarTodos();
	}

	@Override
	public AvaliacaoDisciplina buscar(AvaliacaoDisciplina elemento) {
		return disciplinaDao.buscar(elemento);
	}

	@Override
	public void inserir(AvaliacaoDisciplina novo) {
		disciplinaDao.inserir(novo);
	}

	@Override
	public void atualizar(AvaliacaoDisciplina elemento) {
		disciplinaDao.atualizar(elemento);
	}

	@Override
	public void remover(AvaliacaoDisciplina elemento) {
		disciplinaDao.remover(elemento);
	}
	
	public List<AvaliacaoDisciplina> buscarPorId(String id){
		return disciplinaDao.buscarPorId(id);
	}
	
	public List<AvaliacaoDisciplina> buscarPorMatricula(int matricula){
		return disciplinaDao.buscarPorMatricula(matricula);
	}
	
	public AvaliacaoDisciplina buscarPorPessoaEDisciplina(int matricula, String disciplinaIdId){
		return disciplinaDao.buscarPorPessoaEDisciplina(matricula, disciplinaIdId);
	}

}
