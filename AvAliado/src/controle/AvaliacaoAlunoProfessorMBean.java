package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AvaliacaoAlunoProfessorDao;
import dominio.AvaliacaoAlunoProfessor;

@ManagedBean
@SessionScoped
public class AvaliacaoAlunoProfessorMBean {
	private AvaliacaoAlunoProfessor avaliacao;
	private List<AvaliacaoAlunoProfessor> avaliacoes;
	
	public AvaliacaoAlunoProfessorMBean(){
		avaliacao = new AvaliacaoAlunoProfessor();
		avaliacoes = new ArrayList<AvaliacaoAlunoProfessor>();
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
		AvaliacaoAlunoProfessorDao avaliacaoDao = new AvaliacaoAlunoProfessorDao();
		avaliacoes = avaliacaoDao.buscarTodasAvaliacoes();
		return avaliacoes;
	}
	
	public void setAvaliacoes(List<AvaliacaoAlunoProfessor> avaliacoes){
		this.avaliacoes = avaliacoes;
	}
	
	
}
