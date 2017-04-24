//package controle;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//
//import dominio.*;
//import servico.*;
//
//@ManagedBean
//@SessionScoped
//public class UniversidadeMBean {
//
//	private Universidade universidade;
//	private List<Universidade> listaUniversidades;
//	private UniversidadeService universidadeService;
//	
//	public UniversidadeMBean() {
//		super();
//		this.universidade = new Universidade();
//		this.listaUniversidades = new List<Universidade>();
//		this.universidadeService = new UniversidadeService();
//	}
//
//	public Universidade getUniversidade() {
//		return universidade;
//	}
//
//	public void setUniversidade(Universidade universidade) {
//		this.universidade = universidade;
//	}
//
//	public List<Universidade> getListaUniversidades() {
//		return listaUniversidades;
//	}
//
//	public void setListaUniversidades(List<Universidade> listaUniversidades) {
//		this.listaUniversidades = listaUniversidades;
//	}
//
//	public UniversidadeService getUniversidadeService() {
//		return universidadeService;
//	}
//
//	public void setUniversidadeService(UniversidadeService universidadeService) {
//		this.universidadeService = universidadeService;
//	}
//	
//	
//}
