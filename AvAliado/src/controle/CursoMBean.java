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
//public class CursoMBean {
//	
//	private Curso curso;
//	private List<Curso> listaCursos;
//	private CursoService cursoService;
//	
//	public CursoMBean() {
//		this.curso = new Curso();
//		this.listaCursos = new List<Curso>();
//		this.cursoService = new CursoService();
//	}
//	public Curso getCurso() {
//		return curso;
//	}
//	public void setCurso(Curso curso) {
//		this.curso = curso;
//	}
//	public List<Curso> getListaCursos() {
//		return listaCursos;
//	}
//	public void setListaCursos(List<Curso> listaCursos) {
//		this.listaCursos = listaCursos;
//	}
//	public CursoService getCursoService() {
//		return cursoService;
//	}
//	public void setCursoService(CursoService cursoService) {
//		this.cursoService = cursoService;
//	}
//
//}
