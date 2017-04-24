package dominio;

public class Disciplina {

	private int id;
	private String nome;
	private int notaDificuldade;
	private int notaRelevancia;
	private int notaRecomendacao;
	
	public Disciplina() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNotaDificuldade() {
		return notaDificuldade;
	}
	public void setNotaDificuldade(int notaDificuldade) {
		this.notaDificuldade = notaDificuldade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNotaRelevancia() {
		return notaRelevancia;
	}
	public void setNotaRelevancia(int notaRelevancia) {
		this.notaRelevancia = notaRelevancia;
	}
	public int getNotaRecomendacao() {
		return notaRecomendacao;
	}
	public void setNotaRecomendacao(int notaRecomendacao) {
		this.notaRecomendacao = notaRecomendacao;
	}
	
}
