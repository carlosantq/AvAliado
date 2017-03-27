package controle;

import java.util.List;
import javax.faces.bean.ManagedBean;

import dominio.AvaliacaoAlunoProfessor;
import dao.AvaliacaoAlunoProfessorDao;

@ManagedBean
public class AvaliacaoAlunoProfessorMBean {
	private AvaliacaoAlunoProfessor avaliacao;
	private List<AvaliacaoAlunoProfessor> avaliacoes;
	
	public AvaliacaoAlunoProfessorMBean(){
	}
	
	public String voltar(){
		return "/index.jsf";
	}
	
	public String avaliar(){
		return "avaliar";
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
