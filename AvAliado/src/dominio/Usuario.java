package dominio;

public class Usuario{
	
	int matricula;
	String senha;
	TipoPessoa tipoId;
	
	public Usuario(){
	}
	
	public int getMatricula(){
		return matricula;
	}
	
	public void setMatricula(int matricula){
		this.matricula = matricula;
	}
	
	public String getSenha(){
		return senha;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public TipoPessoa getTipoid(){
		return tipoId;
	}
	
	public void setTipoid (TipoPessoa tipoId){
		this.tipoId = tipoId;
	}

	
}
