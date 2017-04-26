package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Universidade;
import servico.UniversidadeService;

@ManagedBean
@SessionScoped
public class UniversidadeMBean {

	private Universidade universidade;
	private List<Universidade> listaUniversidades;
	private UniversidadeService universidadeService;
	
	public UniversidadeMBean() {
		this.universidade = new Universidade();
		this.listaUniversidades = new ArrayList<Universidade>();
		this.universidadeService = new UniversidadeService();
	}

	public Universidade getUniversidade() {
		return universidade;
	}

	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}

	public List<Universidade> getListaUniversidades() {
		listaUniversidades = universidadeService.buscarTodos();
		return listaUniversidades;
	}

	public void setListaUniversidades(List<Universidade> listaUniversidades) {
		this.listaUniversidades = listaUniversidades;
	}
	
	public String voltarPublic(){
		return "/selection.jsf";
	}
	
	public String exibirNotasPublic(Universidade universidade){
		
		this.universidade = universidade;
		
		return "/verTodasUniversidadePublic.jsf";
	}
	
	public Universidade buscarNotas(int id){
		return universidadeService.buscarNotas(id);
	}
	
	public Universidade buscar(int id){
		return universidadeService.buscar(id);
	}
	
}
