package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ProfessorDao;
import dominio.Professor;

@ManagedBean
@RequestScoped
public class ProfessorMBean {
	private Professor professor;
	private List<Professor> listaProfessores;
	
	public ProfessorMBean(){
		professor = new Professor();
		listaProfessores = new ArrayList<Professor>();
		System.out.println("1");
	}
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Professor> getListaProfessores() {
		System.out.println("Pegando a lista 2");
		ProfessorDao professorDao = new ProfessorDao();
        listaProfessores = professorDao.buscarTodosProfessores();
		return listaProfessores;
	}
	public void setListaProfessores(List<Professor> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}
	
	public String cadastrar() {
		
		/*
		listaProfessores.add(professor);
		FacesMessage msg = new FacesMessage("Professor adicionado com sucesso");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		professor = new Professor();
		return "/interna/lista.jsf"; // ainda inexistente
		*/
		return "/index.jsf";

	}
	
	public String avaliar(){
		return "/professor.jsf";
	}

	
	
}
