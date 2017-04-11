package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.AvaliacaoAlunoProfessor;
import servico.AvaliacaoAlunoProfessorService;

@ManagedBean
@SessionScoped
public class AvaliacaoAlunoProfessorMBean {
	
	private AvaliacaoAlunoProfessor avaliacao;
	private List<AvaliacaoAlunoProfessor> avaliacoes;
	private AvaliacaoAlunoProfessorService avaliacaoAPService;
	
	public AvaliacaoAlunoProfessorMBean(){
		avaliacao = new AvaliacaoAlunoProfessor();
		avaliacoes = new ArrayList<AvaliacaoAlunoProfessor>();
		avaliacaoAPService = new AvaliacaoAlunoProfessorService();
	}
	
	public String voltar(){
		return "/index.jsf";
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
	
}
