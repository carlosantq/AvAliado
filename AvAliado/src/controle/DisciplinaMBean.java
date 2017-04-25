package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dominio.*;
import servico.*;

@ManagedBean
@SessionScoped
public class DisciplinaMBean {

	private Disciplina disciplina;
	private List<Disciplina> listaDisciplinas;
//	private DisciplinaService disciplinaService;
	
	public DisciplinaMBean() {
		this.disciplina = new Disciplina();;
		this.listaDisciplinas = new ArrayList<Disciplina>();
//		this.disciplinaService = new DisciplinaService();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}
	
//	public DisciplinaService getDisciplinaService() {
//		return disciplinaService;
//	}
//
//	public void setDisciplinaService(DisciplinaService disciplinaService) {
//		this.disciplinaService = disciplinaService;
//	}
}
