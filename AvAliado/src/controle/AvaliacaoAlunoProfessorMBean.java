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
import servico.DisciplinaService;
import servico.ProfessorService;

@ManagedBean
@SessionScoped
public class AvaliacaoAlunoProfessorMBean {
	
	private AvaliacaoAlunoProfessor avaliacao;
	private List<AvaliacaoAlunoProfessor> avaliacoes;
	private AvaliacaoAlunoProfessorService avaliacaoAPService;
	private ProfessorService professorService;
	private DisciplinaService disciplinaService;
	
	public AvaliacaoAlunoProfessorMBean(){
		avaliacao = new AvaliacaoAlunoProfessor();
		avaliacoes = new ArrayList<AvaliacaoAlunoProfessor>();
		avaliacaoAPService = new AvaliacaoAlunoProfessorService();
		professorService = new ProfessorService();
		disciplinaService = new DisciplinaService();
	}
	
	public AvaliacaoAlunoProfessor getAvaliacao(){
		return avaliacao;
	}
	
	public void setAvaliacao(AvaliacaoAlunoProfessor avaliacao){
		this.avaliacao = avaliacao;
	}
	
	public List<AvaliacaoAlunoProfessor> getAvaliacoes(){
		avaliacoes = avaliacaoAPService.buscarTodos();
		return avaliacoes;
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
		int matricula = Integer.parseInt(ec.getRequestParameterMap().get("matricula"));
		
		Professor professorBuscado = professorService.buscar(avaliacao.getMatriculaProfessor());
		
		if (professorBuscado.getMatricula() == 0){
			FacesMessage msg = new FacesMessage("Este professor não existe.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (disciplinaService.buscarVinculo(matricula, professorBuscado.getMatricula()) == false){
			FacesMessage msg = new FacesMessage("Você não esteve em nenhuma disciplina ministrada por este professor. A avaliação não poderá ser feita.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (avaliacaoAPService.buscarPorAlunoEProfessor(professorBuscado.getMatricula(), matricula).getMatriculaProfessor() != 0){
			FacesMessage msg = new FacesMessage("Você já avaliou este professor.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else {
			avaliacao.setMatriculaAluno(matricula);
			
			return "/professor.jsf";
		}
	}
	
	public String voltar(){
		return "/alunoHome.jsf";
	}
	
	public String avaliar(){
		
		if (avaliacaoAPService.buscar(avaliacao).getMatriculaProfessor() != 0){
			avaliacaoAPService.atualizar(avaliacao);
			FacesMessage msg = new FacesMessage("Avaliação Atualizada.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("", msg);
		}else{
			FacesMessage msg = new FacesMessage("Avaliação Registrada.");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage("", msg);
			avaliacaoAPService.inserir(avaliacao);
		}
		
		return "/alunoHome.jsf";
	}
	
	public String remover(AvaliacaoAlunoProfessor avaliacao){
		avaliacaoAPService.remover(avaliacao);
		
		FacesMessage msg = new FacesMessage("Avaliação Removida.");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		
		return "/alunoHome.jsf";
		
	}
	
	public String atualizar(AvaliacaoAlunoProfessor avaliacao){
		this.avaliacao = avaliacao;
		return "/professor.jsf";
	}
	
}
