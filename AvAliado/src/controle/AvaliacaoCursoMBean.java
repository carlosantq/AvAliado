package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dominio.AvaliacaoCurso;
import dominio.Curso;
import dominio.TipoPessoa;
import dominio.Usuario;
import servico.AvaliacaoCursoService;
import servico.CursoService;
import servico.UsuarioService;

@ManagedBean
@SessionScoped
public class AvaliacaoCursoMBean {
	
	private AvaliacaoCurso avaliacao;
	private List<AvaliacaoCurso> avaliacoes;
	private AvaliacaoCursoService avaliacaoService;
	private CursoService cursoService;
	@Inject
	private UsuarioService usuarioService;
	
	public AvaliacaoCursoMBean(){
		avaliacao = new AvaliacaoCurso();
		avaliacoes = new ArrayList<AvaliacaoCurso>();
		avaliacaoService = new AvaliacaoCursoService();
		cursoService = new CursoService();
	}
	
	public AvaliacaoCurso getAvaliacao(){
		return avaliacao;
	}
	
	public void setAvaliacao(AvaliacaoCurso avaliacao){
		this.avaliacao = avaliacao;
	}
	
	public List<AvaliacaoCurso> getAvaliacoes(){
		avaliacoes = avaliacaoService.buscarTodos();
		return avaliacoes;
	}
	
	public void setAvaliacoes(List<AvaliacaoCurso> avaliacoes){
		this.avaliacoes = avaliacoes;
	}
	
	public List<AvaliacaoCurso> buscarPorId(int id){
		return avaliacaoService.buscarPorId(id);
	}
	
	public List<AvaliacaoCurso> buscarPorMatricula(int matricula){
		return avaliacaoService.buscarPorMatricula(matricula);
	}
	
	public String paginaAvaliar(){
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		int matricula = Integer.parseInt(ec.getRequestParameterMap().get("matricula"));
		
		Curso cursoBuscado = cursoService.buscar(avaliacao.getCursoId());
		
		if (cursoBuscado.getId() == 0){
			FacesMessage msg = new FacesMessage("Este curso não existe.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (cursoService.buscarVinculo(matricula, cursoBuscado.getId()) == false){
			FacesMessage msg = new FacesMessage("Você não tem vínculo com o curso informado.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (avaliacaoService.buscarPorPessoaECurso(matricula, cursoBuscado.getId()).getMatriculaPessoa() != 0){
			FacesMessage msg = new FacesMessage("Você já avaliou este curso.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else {
			avaliacao.setMatriculaPessoa(matricula);
			
			return "/curso.jsf";
		}
	}
	
	
	public String avaliar(){
		
		usuarioService = new UsuarioService();
		Usuario usuario = usuarioService.buscar(avaliacao.getMatriculaPessoa());
		
		if (avaliacaoService.buscar(avaliacao).getCursoId() != 0){
			avaliacaoService.atualizar(avaliacao);
			FacesMessage msg = new FacesMessage("Avaliação Atualizada.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("", msg);
		}else{
			FacesMessage msg = new FacesMessage("Avaliação Registrada.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("", msg);
			avaliacaoService.inserir(avaliacao);
		}
		
		if (usuario.getTipoid() == TipoPessoa.aluno){
			return "/alunoHome.jsf";
		}else{
			return "/professorHome.jsf";
		}
	}
	
	public String voltar(){
		
		usuarioService = new UsuarioService();
		Usuario usuario = usuarioService.buscar(avaliacao.getMatriculaPessoa());
		
		if (usuario.getTipoid() == TipoPessoa.aluno){
			return "/alunoHome.jsf";
		}else{
			return "/professorHome.jsf";
		}
	}
	
	public String remover(AvaliacaoCurso avaliacao){
		avaliacaoService.remover(avaliacao);
		
		usuarioService = new UsuarioService();
		Usuario usuario = usuarioService.buscar(avaliacao.getMatriculaPessoa());
		
		FacesMessage msg = new FacesMessage("Avaliação Removida.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		
		if (usuario.getTipoid() == TipoPessoa.aluno){
			return "/alunoHome.jsf";
		}else{
			return "/professorHome.jsf";
		}
		
	}
	
	public String atualizar(AvaliacaoCurso avaliacao){
		this.avaliacao = avaliacao;
		return "/curso.jsf";
	}
	
}
