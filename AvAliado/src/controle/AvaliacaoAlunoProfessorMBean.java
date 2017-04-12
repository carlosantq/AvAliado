package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dominio.Aluno;
import dominio.AvaliacaoAlunoProfessor;
import dominio.Professor;
import servico.AlunoService;
import servico.AvaliacaoAlunoProfessorService;
import servico.ProfessorService;

@ManagedBean
@SessionScoped
public class AvaliacaoAlunoProfessorMBean {
	
	private AvaliacaoAlunoProfessor avaliacao;
	private List<AvaliacaoAlunoProfessor> avaliacoes;
	private AvaliacaoAlunoProfessorService avaliacaoAPService;
	private ProfessorService professorService;
	
	public AvaliacaoAlunoProfessorMBean(){
		avaliacao = new AvaliacaoAlunoProfessor();
		avaliacoes = new ArrayList<AvaliacaoAlunoProfessor>();
		avaliacaoAPService = new AvaliacaoAlunoProfessorService();
		professorService = new ProfessorService();
	}
	
	public AvaliacaoAlunoProfessor getAvaliacao(){
		return avaliacao;
	}
	
	public void setAvaliacao(AvaliacaoAlunoProfessor avaliacao){
		this.avaliacao = avaliacao;
	}
	
	public List<AvaliacaoAlunoProfessor> getAvaliacoes(){
		return avaliacaoAPService.buscarTodos();
	}
	
	public void setAvaliacoes(List<AvaliacaoAlunoProfessor> avaliacoes){
		this.avaliacoes = avaliacoes;
	}
	
	public List<AvaliacaoAlunoProfessor> buscarPorMatricula(int matricula){
		return avaliacaoAPService.buscarPorMatricula(matricula);
	}
	
	public List<AvaliacaoAlunoProfessor> buscarRecentes(int matricula){
		return avaliacaoAPService.buscarRecentes(matricula);
	}
	
	public String paginaAvaliar(){
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		int matriculaAluno = Integer.parseInt(ec.getRequestParameterMap().get("matriculaAluno"));
		
		Professor professorBuscado = professorService.buscar(avaliacao.getMatriculaProfessor());
		
		if (professorBuscado.getMatricula() == 0){
			FacesMessage msg = new FacesMessage("Professor não existe.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}else if (avaliacaoAPService.buscarPorAlunoEProfessor(professorBuscado.getMatricula(), matriculaAluno).getMatriculaProfessor() != 0){
			FacesMessage msg = new FacesMessage("Já existe uma avaliação feita.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}else{
			
			avaliacao.setMatriculaAluno(matriculaAluno);
			
			return "/professor.jsf";
		}
	}
	
	public String voltar(){
		return "/alunoHome.jsf";
	}
	
	public String avaliar(){
		
		avaliacaoAPService.inserir(avaliacao);
		
		FacesMessage msg = new FacesMessage("Avaliação Registrada.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		
		return "/alunoHome.jsf";
	}
	
}
