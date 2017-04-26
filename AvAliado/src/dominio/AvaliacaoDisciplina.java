package dominio;

import java.util.Date;

public class AvaliacaoDisciplina {
	
	private int matriculaAluno;
	private int professorId;
	private String disciplinaId;
	private int ano;
	private int semestre;
	private boolean cobranca;
	private boolean dificuldade;
	private boolean relevancia;
	private boolean recomandacao;
	private Date data;
	private String comentario;
	
	public AvaliacaoDisciplina() {
	}
	
	public int getMatriculaAluno() {
		return matriculaAluno;
	}
	
	public void setMatriculaAluno(int matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	
	public int getProfessorId() {
		return professorId;
	}
	
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	
	public String getDisciplinaId() {
		return disciplinaId;
	}
	
	public void setDisciplinaId(String disciplinaId) {
		this.disciplinaId = disciplinaId;
	}
	
	public boolean getDificuldade() {
		return dificuldade;
	}
	
	public void setDificuldade(boolean dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	public boolean getRelevancia() {
		return relevancia;
	}
	
	public void setRelevancia(boolean relevancia) {
		this.relevancia = relevancia;
	}
	
	public boolean getRecomendacao() {
		return recomandacao;
	}
	
	public void setRecomendacao(boolean recomandacao) {
		this.recomandacao = recomandacao;
	}
	
	public boolean getCobranca(){
		return cobranca;
	}
	
	public void setCobranca(boolean cobranca){
		this.cobranca = cobranca;
	}
	
	public int getAno(){
		return ano;
	}
	
	public void setAno(int ano){
		this.ano = ano;
	}
	
	public int getSemestre(){
		return semestre;
	}
	
	public void setSemestre(int semestre){
		this.semestre = semestre;
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
