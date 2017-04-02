package servico;

import java.util.List;
import javax.inject.Inject;

import dao.PessoaDao;
import dominio.Pessoa;

public class PessoaService implements IServico<Pessoa>{
	
	@Inject
	private PessoaDao pessoaDao;
	
	public PessoaService(){
		pessoaDao = new PessoaDao();
	}

	@Override
	public List<Pessoa> buscarTodos() {
		return pessoaDao.buscarTodos();
	}

	@Override
	public Pessoa buscar(Pessoa elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Pessoa novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Pessoa elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Pessoa elemento) {
		// TODO Auto-generated method stub
		
	}

}
