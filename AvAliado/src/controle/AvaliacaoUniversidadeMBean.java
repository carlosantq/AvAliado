package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dominio.AvaliacaoUniversidade;
import dominio.Universidade;
import servico.AvaliacaoUniversidadeService;
import servico.UniversidadeService;

@ManagedBean
@SessionScoped
public class AvaliacaoUniversidadeMBean {
	
	private AvaliacaoUniversidade avaliacao;
	private List<AvaliacaoUniversidade> avaliacoes;
	private AvaliacaoUniversidadeService avaliacaoService;
	private UniversidadeService universidadeService;
	
	public AvaliacaoUniversidadeMBean(){
		avaliacao = new AvaliacaoUniversidade();
		avaliacoes = new ArrayList<AvaliacaoUniversidade>();
		avaliacaoService = new AvaliacaoUniversidadeService();
		universidadeService = new UniversidadeService();
	}
	
	public AvaliacaoUniversidade getAvaliacao(){
		return avaliacao;
	}
	
	public void setAvaliacao(AvaliacaoUniversidade avaliacao){
		this.avaliacao = avaliacao;
	}
	
	public List<AvaliacaoUniversidade> getAvaliacoes(){
		avaliacoes = avaliacaoService.buscarTodos();
		return avaliacoes;
	}
	
	public void setAvaliacoes(List<AvaliacaoUniversidade> avaliacoes){
		this.avaliacoes = avaliacoes;
	}
	
	public List<AvaliacaoUniversidade> buscarPorId(int id){
		return avaliacaoService.buscarPorId(id);
	}
	
	public List<AvaliacaoUniversidade> buscarPorMatricula(int matricula){
		return avaliacaoService.buscarPorMatricula(matricula);
	}
	
	public String paginaAvaliar(){
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		int matricula = Integer.parseInt(ec.getRequestParameterMap().get("matricula"));
		
		Universidade universidadeBuscada = universidadeService.buscar(avaliacao.getUniversidadeId());
		
		if (universidadeBuscada.getId() == 0){
			FacesMessage msg = new FacesMessage("Esta universidade não existe.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (universidadeService.buscarVinculo(matricula, universidadeBuscada.getId()) == false){
			FacesMessage msg = new FacesMessage("Você não tem vínculo com a universidade informada.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else if (avaliacaoService.buscarPorPessoaEUniversidade(matricula, universidadeBuscada.getId()).getMatriculaPessoa() != 0){
			FacesMessage msg = new FacesMessage("Você já avaliou esta universidade.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else {
			avaliacao.setMatriculaPessoa(matricula);
			
			return "/universidade.jsf";
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
