package controle;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dominio.Aluno;
import dominio.Professor;
import dominio.TipoPessoa;
import dominio.Usuario;
import servico.AlunoService;
import servico.ProfessorService;
import servico.UsuarioService;

@ManagedBean
@RequestScoped
public class UsuarioMBean {
	
	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	@EJB
	private UsuarioService usuarioService;
	private Usuario usuarioLogado;
	private Aluno aluno;
	private Professor professor;
	@Inject
	private AlunoService alunoService;
	@Inject
	private ProfessorService professorService;
	
	
	public UsuarioMBean(){
		usuario = new Usuario();
		listaUsuarios = new ArrayList<Usuario>();
		usuarioService = new UsuarioService();
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public Aluno getAluno(){
		return aluno;
	}
	
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}
	
	public Professor getProfessor(){
		return professor;
	}
	
	public void setProfessor(Professor professor){
		this.professor = professor;
	}
	
	public List<Usuario> getListaUsuarios(){
		return listaUsuarios;
	}
	
	public void setListaUsuarios(List<Usuario> listaUsuarios){
		this.listaUsuarios = listaUsuarios;
	}
	
	public Usuario getUsuarioLogado(){
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado){
		this.usuarioLogado = usuarioLogado;
	}
	
	public String login(){
			
		int resultado = usuarioService.login(usuario.getMatricula(),usuario.getSenha());
		switch(resultado){
			case 1: 
				aluno = alunoService.buscar(usuario.getMatricula());
				return "/alunoHome.jsf";
			
			case 2: 
				professor = professorService.buscar(usuario.getMatricula());
				return "/professorHome.jsf";
			
			case 0: FacesMessage msg = new FacesMessage("Senha incorreta");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
			
			case -1: FacesMessage msg2 = new FacesMessage("Usuario nao existe");
			msg2.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg2);
			return null;
		}
		return null;
	}
	
	public String logoff(){
		this.usuarioLogado = null;
		return "/login.jsf";
	}
	public Usuario logado(){
		return null;
		}
	
}
