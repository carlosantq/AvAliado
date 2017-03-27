package controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Dominio.Professor;

public class ProfessorMB {
	private Professor professor;
	private List<Professor> listaProfessores;
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}
	public void setListaProfessores(List<Professor> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}
	
	public ProfessorMB(){
		
	}
	
	public String cadastrar() {
		listaProfessores.add(professor);
		FacesMessage msg = new FacesMessage("Professor adicionado com sucesso");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		professor = new Professor();
		return "/interna/lista.jsf"; // ainda inexistente

	}
	
}
