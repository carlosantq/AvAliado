package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dominio.Professor;
import servico.ProfessorService;

@ManagedBean
@RequestScoped
public class ProfessorMBean {
	private Professor professor;
	private List<Professor> listaProfessores;
	private ProfessorService professorService;
	
	public ProfessorMBean(){
		professor = new Professor();
		listaProfessores = new ArrayList<Professor>();
		professorService = new ProfessorService();
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Professor> getListaProfessores() {
        listaProfessores = professorService.buscarTodos();
		return listaProfessores;
	}
	
	public void setListaProfessores(List<Professor> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}
	
	public String cadastrar() {
		professorService.inserir(professor);
		return "/index.jsf";

	}
	
	public String paginaProfessor(Professor selecionado){
		professor = selecionado;
		professor = professorService.buscar(professor);
		return "/professor.jsf";
	}
	
	public String avaliar(){
		return "/professor.jsf";
	}

	
	
}
