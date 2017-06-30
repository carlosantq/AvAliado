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
				
		if (disciplinaBuscado.getId() == null){
			FacesMessage msg = new FacesMessage("Este disciplina não existe.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (disciplinaBuscado != null && disciplinaService.buscarVinculo1(matricula, disciplinaBuscado.getId()) == false){
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
			avaliacao.setAno(disciplinaBuscado.getAno());
			avaliacao.setSemestre(disciplinaBuscado.getSemestre());
			
			return "/disciplina.jsf";
		}
	}
	
	public String voltar(){
		return "/alunoHome.jsf";
	}
	
	public String avaliar(){
		
		AvaliacaoDisciplina buscada = avaliacaoService.buscar(avaliacao);
		
		if (buscada.getProfessorId() != 0){
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
		
		return "/alunoHome.jsf";
	}
	
	public String remover(AvaliacaoDisciplina avaliacao){
		avaliacaoService.remover(avaliacao);
		
		FacesMessage msg = new FacesMessage("Avaliação Removida.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		
		return "/alunoHome.jsf";
		
	}
	
	public String atualizar(AvaliacaoDisciplina avaliacao){
		this.avaliacao = avaliacao;
		return "/disciplina.jsf";
	}
}
