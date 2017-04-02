package servico;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.ProfessorDao;
import dominio.Professor;

@Stateful
public class ProfessorService implements IServico<Professor>{
	@Inject
	private ProfessorDao professorDao;
	
	@Override
	public List<Professor> buscarTodos() {
		return professorDao.buscarTodos();
	}

	@Override
	public Professor buscar(Professor elemento) {
		return professorDao.buscar(elemento); //retorna o professor buscado
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void inserir(Professor novo) {
		Professor p = professorDao.buscar(novo);
		if(p == null){
			professorDao.inserir(novo);
		}else {
			atualizar(novo); 
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void remover(Professor elemento) {
		Professor p = professorDao.buscar(elemento);
		if(p!=null){
			professorDao.remover(p);//ainda n�o existe 
		}
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void atualizar(Professor elemento) {
		// TODO Auto-generated method stub
		//ainda nao existe
	}



	

}
