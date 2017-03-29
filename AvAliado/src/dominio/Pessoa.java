package dominio;

public class Pessoa{

	private int matricula;
	private TipoPessoa tipoId;
	private String nome;
	private int telefone;
	private String email;

	public Pessoa(){
	}

	public int getMatricula(){
		return matricula;
	}
	
	public void setMatricula (int matricula){
		this.matricula = matricula;
	}

//	public TipoPessoa getTipoid(){
//		return tipoId;
//	}
//	
//	public void setTipoid (TipoPessoa tipoId){
//		this.tipoId = tipoId;
//	}

	public String getNome(){
		return nome;
	}
	
	public void setNome (String nome){
		this.nome = nome;
	}

	public int getTelefone(){
		return telefone;
	}
	
	public void setTelefone (int telefone){
		this.telefone = telefone;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail (String email){
		this.email = email;
	}

	@Override
	public String toString(){
		return "matricula = " + matricula + "tipoid = " + tipoId + "nome = " + nome + "telefone = " + telefone + "email = " + email;
	}
}
