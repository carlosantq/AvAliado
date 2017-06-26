package dominio;

public class Universidade {
	
	private int id;
	private String nome;
	private String sigla;
	private String endereco;
	private String telefone;
	private int notaEstrutura;
	private int notaVidaCultural;
	private int notaAuxilios;
	
	public Universidade() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getNotaEstrutura() {
		return notaEstrutura;
	}
	public void setNotaEstrutura(int notaEstrutura) {
		this.notaEstrutura = notaEstrutura;
	}
	public int getNotaVidaCultural() {
		return notaVidaCultural;
	}
	public void setNotaVidaCultural(int notaVidaCultural) {
		this.notaVidaCultural = notaVidaCultural;
	}
	public int getNotaAuxilios() {
		return notaAuxilios;
	}
	public void setNotaAuxilios(int notaAuxilios) {
		this.notaAuxilios = notaAuxilios;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id + " - " + nome + " - " + sigla;
	}
	
}
