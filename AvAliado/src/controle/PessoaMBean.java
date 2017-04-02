package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Pessoa;
import servico.PessoaService;

@ManagedBean
@SessionScoped
public class PessoaMBean {
	private Pessoa pessoa;
	private List<Pessoa> listaPessoas;
	private PessoaService pessoaService;
	
	public PessoaMBean(){
		pessoa = new Pessoa();
		listaPessoas = new ArrayList<Pessoa>();
		pessoaService = new PessoaService();
	}

	public String logar(){
		return "/selection.jsf";
	}
	
	public String voltar(){
		return "/selection.jsf";
	}
	
	public Pessoa getPessoa(){
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas(){
		return listaPessoas;
	}
	
	public void setListaPessoas(List<Pessoa> listaPessoas){
		this.listaPessoas = listaPessoas;
	}
	
	
}
