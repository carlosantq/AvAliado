package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dominio.Aluno;

@ManagedBean
@RequestScoped
public class AlunoMBean {
	private Aluno aluno;
	private List<Aluno> listaAlunos;
	
	public AlunoMBean(){
		aluno = new Aluno();
		listaAlunos = new ArrayList<Aluno>();
	}
	
	public Aluno getAluno(){
		return aluno;
	}
	
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	
	
}
