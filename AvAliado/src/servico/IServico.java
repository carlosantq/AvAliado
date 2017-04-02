package servico;

import java.util.List;

public interface IServico <Y>{
	public List<Y> buscarTodos();
	public Y buscar(Y elemento);
	public void inserir(Y novo);
	public void atualizar(Y elemento);
	public void remover(Y elemento);
}
