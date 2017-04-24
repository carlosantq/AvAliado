package dominio;

import java.util.Date;

public class AvaliacaoCurso {

	private int matriculaPessoa;
	private int idCurso;
	private boolean dificuldade;
	private boolean flexibilidade;
	private boolean mercadoDeTrabalho;
	private Date data;
	private String comentario;
	
	public AvaliacaoCurso() {
		
	}
	
	public int getMatriculaPessoa() {
		return matriculaPessoa;
	}
	public void setMatriculaPessoa(int matriculaPessoa) {
		this.matriculaPessoa = matriculaPessoa;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public boolean isDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(boolean dificuldade) {
		this.dificuldade = dificuldade;
	}
	public boolean isFlexibilidade() {
		return flexibilidade;
	}
	public void setFlexibilidade(boolean flexibilidade) {
		this.flexibilidade = flexibilidade;
	}
	public boolean isMercadoDeTrabalho() {
		return mercadoDeTrabalho;
	}
	public void setMercadoDeTrabalho(boolean mercadoDeTrabalho) {
		this.mercadoDeTrabalho = mercadoDeTrabalho;
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
