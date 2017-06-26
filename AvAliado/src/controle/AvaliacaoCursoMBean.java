package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dominio.AvaliacaoCurso;
import dominio.Curso;
import servico.AvaliacaoCursoService;
import servico.CursoService;

@ManagedBean
@SessionScoped
public class AvaliacaoCursoMBean {
	
	private AvaliacaoCurso avaliacao;
	private List<AvaliacaoCurso> avaliacoes;
	private AvaliacaoCursoService avaliacaoService;
	private CursoService cursoService;
	
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
		
		avaliacaoService.inserir(avaliacao);
		
		FacesMessage msg = new FacesMessage("Avaliação Registrada.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		
		return "/alunoHome.jsf";
	}
	
	public String voltar(){
		return "/alunoHome.jsf";
	}
	
}
