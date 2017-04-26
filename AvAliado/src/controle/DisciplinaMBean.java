package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.*;
import servico.*;

@ManagedBean
@SessionScoped
public class DisciplinaMBean {

	private Disciplina disciplina;
	private List<Disciplina> listaDisciplinas;
    private DisciplinaService disciplinaService;
	
	public DisciplinaMBean() {
		this.disciplina = new Disciplina();;
		this.listaDisciplinas = new ArrayList<Disciplina>();
		this.disciplinaService = new DisciplinaService();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getListaDisciplinas() {
		listaDisciplinas = disciplinaService.buscarTodos();
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}
	
	public String voltarPublic(){
		return "/selection.jsf";
	}
	
	public String exibirNotasPublic(Disciplina disciplina){
		
		this.disciplina = disciplina;
		
		return "/verTodasDisciplinaPublic.jsf";
	}
	
	public Disciplina buscarNotas(String id){
		return disciplinaService.buscarNotas(id);
	}
	
	public Disciplina buscar(String id){
		return disciplinaService.buscar(id);
	}
	
}
