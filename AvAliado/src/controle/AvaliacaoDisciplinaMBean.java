package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dominio.AvaliacaoDisciplina;
import dominio.Disciplina;
import servico.AvaliacaoDisciplinaService;
import servico.DisciplinaService;

@ManagedBean
@SessionScoped
public class AvaliacaoDisciplinaMBean {
	
	private AvaliacaoDisciplina avaliacao;
	private List<AvaliacaoDisciplina> avaliacoes;
	private AvaliacaoDisciplinaService avaliacaoService;
	private DisciplinaService disciplinaService;
	
	public AvaliacaoDisciplinaMBean(){
		avaliacao = new AvaliacaoDisciplina();
		avaliacoes = new ArrayList<AvaliacaoDisciplina>();
		avaliacaoService = new AvaliacaoDisciplinaService();
		disciplinaService = new DisciplinaService();
	}
	
	public AvaliacaoDisciplina getAvaliacao(){
		return avaliacao;
	}
	
	public void setAvaliacao(AvaliacaoDisciplina avaliacao){
		this.avaliacao = avaliacao;
	}
	
	public List<AvaliacaoDisciplina> getAvaliacoes(){
		avaliacoes = avaliacaoService.buscarTodos();
		return avaliacoes;
	}
	
	public void setAvaliacoes(List<AvaliacaoDisciplina> avaliacoes){
		this.avaliacoes = avaliacoes;
	}
	
	public List<AvaliacaoDisciplina> buscarPorId(String id){
		return avaliacaoService.buscarPorId(id);
	}
	
	public List<AvaliacaoDisciplina> buscarPorMatricula(int matricula){
		return avaliacaoService.buscarPorMatricula(matricula);
	}
	
	public String paginaAvaliar(){
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		int matricula = Integer.parseInt(ec.getRequestParameterMap().get("matricula"));
		
		Disciplina disciplinaBuscado = disciplinaService.buscar(avaliacao.getDisciplinaId());
		
		if (disciplinaBuscado.getId().equals(null)){
			FacesMessage msg = new FacesMessage("Este disciplina não existe.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (disciplinaService.buscarVinculo1(matricula, disciplinaBuscado.getId()) == false){
			FacesMessage msg = new FacesMessage("Você não tem vínculo com a disciplina informada.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (avaliacaoService.buscarPorPessoaEDisciplina(matricula, disciplinaBuscado.getId()).getMatriculaAluno() != 0){
			FacesMessage msg = new FacesMessage("Você já avaliou esta disciplina.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else {
			avaliacao.setMatriculaAluno(matricula);
			avaliacao.setProfessorId(disciplinaBuscado.getProfessorId());
			
			return "/disciplina.jsf";
		}
	}
	
	
	public String avaliar(){
		
		avaliacaoService.inserir(avaliacao);
		
		FacesMessage msg = new FacesMessage("Avaliação Registrada.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		
		return "/alunoHome.jsf";
	}
	
}