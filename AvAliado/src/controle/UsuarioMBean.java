package controle;

import java.util.ArrayList;
import java.util.List;

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
		
		Usuario usuarioBd = new Usuario();
		
		for (Usuario usuarioTemp : usuarioService.buscarTodos()){
			if (usuarioTemp.getMatricula() == usuario.getMatricula()){
				usuarioBd = usuarioTemp;
			}
		}
				
		if (usuarioBd.getMatricula() != 0){
			if (usuarioBd.getSenha().equals(usuario.getSenha())){
				usuarioLogado = usuarioBd;
				
				if (usuarioLogado.getTipoid() == TipoPessoa.aluno){
					
					alunoService = new AlunoService();
					aluno = alunoService.buscar(usuarioLogado.getMatricula());
					
					return "/alunoHome.jsf";
				}else{
					
					professorService = new ProfessorService();
					professor = professorService.buscar(usuarioLogado.getMatricula());
					
					return "/professorHome.jsf";
				}
			}else{
				FacesMessage msg = new FacesMessage("Senha incorreta");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage("", msg);
				return null;
			}
		}else{
			FacesMessage msg = new FacesMessage("Usuário não existe.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}
	
	public String logoff(){
		this.usuarioLogado = null;
		return "/index.jsf";
	}
	
	
}
