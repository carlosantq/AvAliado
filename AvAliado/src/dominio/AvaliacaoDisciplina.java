package dominio;

import java.util.Date;

public class AvaliacaoDisciplina {
	
	private int matriculaPessoa;
	private int idDisciplina;
	private boolean dificuldade;
	private boolean relevancia;
	private boolean recomandacao;
	private Date data;
	private String comentario;
	
	public AvaliacaoDisciplina() {
	}
	
	public int getMatriculaPessoa() {
		return matriculaPessoa;
	}
	public void setMatriculaPessoa(int matriculaPessoa) {
		this.matriculaPessoa = matriculaPessoa;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public boolean isDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(boolean dificuldade) {
		this.dificuldade = dificuldade;
	}
	public boolean isRelevancia() {
		return relevancia;
	}
	public void setRelevancia(boolean relevancia) {
		this.relevancia = relevancia;
	}
	public boolean isRecomandacao() {
		return recomandacao;
	}
	public void setRecomandacao(boolean recomandacao) {
		this.recomandacao = recomandacao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
