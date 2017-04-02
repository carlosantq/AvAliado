package dao;

import java.util.List;

public interface IDAO <T>{
	public List<T> buscarTodos();
	public T buscar(T elemento);
	public void inserir(T novo);
	public void atualizar();
	public void remover(T elemento);
}
