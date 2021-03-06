package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dominio.Professor;
import servico.ProfessorService;

@ManagedBean
@SessionScoped
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
	
	public Professor buscar(int matricula){
		return professorService.buscar(matricula);
	}
	
	public Professor buscarNotas(int matricula){
		return professorService.buscarNotas(matricula);
	}
	
	public String verProfessores(){
		return "/selection.jsf";
	}
	
	public String cadastrar() {
		professorService.inserir(professor);
		return "/index.jsf";

	}
	
	public String voltar(){
		return "/professorHome.jsf";
	}
	
	public String voltarPublic(){
		return "/selection.jsf";
	}
	
	public String exibirNotas(int professor){
		return "/verTodosProfessor.jsf";
	}
	
	public String exibirNotasPublic(Professor professor){
		
		this.professor = professor;
		
		return "/verTodosProfessorPublic.jsf";
	}
	
	public String paginaProfessor(Professor selecionado){
		professor = selecionado;
		professor = professorService.buscar(professor);
		return "/professor.jsf";
	}
	
	public String avaliar(){
		return "/professor.jsf";
	}

	public String logoff(){
		return "/login.jsf";
	}
	
}
