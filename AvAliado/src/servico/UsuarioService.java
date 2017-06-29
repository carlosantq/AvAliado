package servico;

import java.util.List;

import javax.inject.Inject;

import dao.UsuarioDao;
import dominio.Usuario;

public class UsuarioService implements IServico<Usuario>{
	
	@Inject
	protected UsuarioDao usuarioDao;
	
	public UsuarioService(){
		usuarioDao = new UsuarioDao();
	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuarioDao.buscarTodos();
	}

	@Override
	public Usuario buscar(Usuario elemento) {
		return usuarioDao.buscar(elemento);
	}
	
	public Usuario buscar(int matricula){
		return usuarioDao.buscar(matricula);
	}

	@Override
	public void inserir(Usuario novo) {
		usuarioDao.inserir(novo);
	}

	@Override
	public void atualizar(Usuario elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Usuario elemento) {
		// TODO Auto-generated method stub
		
	}

}
