package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Curso;
import servico.CursoService;

@ManagedBean
@SessionScoped
public class CursoMBean {
	
	private Curso curso;
	private List<Curso> listaCursos;
	private CursoService cursoService;
	
	public CursoMBean() {
		this.curso = new Curso();
		this.listaCursos = new ArrayList<Curso>();
		this.cursoService = new CursoService();
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<Curso> getListaCursos() {
		listaCursos = cursoService.buscarTodos();
		return listaCursos;
	}
	
	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}
	
	public String voltarPublic(){
		return "/selection.jsf";
	}
	
	public String exibirNotasPublic(Curso curso){
		
		this.curso = curso;
		
		return "/verTodosCursoPublic.jsf";
	}
	
	public Curso buscarNotas(int id){
		return cursoService.buscarNotas(id);
	}
	
	public Curso buscar(int id){
		return cursoService.buscar(id);
	}
}
