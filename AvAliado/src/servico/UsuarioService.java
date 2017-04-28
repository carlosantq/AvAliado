package servico;

import java.util.List;

import javax.inject.Inject;

import dao.UsuarioDao;
import dominio.TipoPessoa;
import dominio.Usuario;

public class UsuarioService implements IServico<Usuario> {

	@Inject
	protected UsuarioDao usuarioDao;

	public UsuarioService() {
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

	public int login(int matricula, String senha) {
		Usuario usuarioBd = new Usuario();

		for (Usuario usuarioTemp : buscarTodos()) {
			if (usuarioTemp.getMatricula() == matricula) {
				usuarioBd = usuarioTemp;
			}
		}
		if(usuarioBd.getMatricula()!= 0){
			if(usuarioBd.getSenha().equals(senha)){
				if(usuarioBd.getTipoid() == TipoPessoa.aluno){
					return 1;
				}
				if(usuarioBd.getTipoid() == TipoPessoa.professor){
					return 2;
				}
			}
			return 0;
			
		}
		return -1;
	}

}
