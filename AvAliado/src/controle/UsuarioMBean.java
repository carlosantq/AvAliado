package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dominio.TipoPessoa;
import dominio.Usuario;
import servico.UsuarioService;

@ManagedBean
@RequestScoped
public class UsuarioMBean {
	
	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	private UsuarioService usuarioService;
	private Usuario usuarioLogado;
	
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
					return "/alunoHome.jsf";
				}else{
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
