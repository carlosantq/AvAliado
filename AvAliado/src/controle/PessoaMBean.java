package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaMBean {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	public PessoaMBean(){
		pessoa = new Pessoa();
		pessoas = new ArrayList<Pessoa>();
	}
	
	public String logar(){
		return "/selection.jsf";
	}
	
	public String voltar(){
		return "/index.jsf";
	}
	
	public String avaliar(){
		return "avaliar";
	}
	
	public Pessoa getPessoa(){
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getAvaliacoes(){
		//PessoaDao pessoaDao = new PessoaDao();
		//pessoas = pessoaDao.buscarTodasAvaliacoes();
		return pessoas;
	}
	
	public void setAvaliacoes(List<Pessoa> pessoas){
		this.pessoas = pessoas;
	}
	
	
}
