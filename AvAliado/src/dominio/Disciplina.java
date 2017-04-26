package dominio;

public class Disciplina {

	private String id;
	private String nome;
	private int cursoId;
	private int professorId;
	private int ano;
	private int semestre;
	private int notaDificuldade;
	private int notaRelevancia;
	private int notaRecomendacao;
	private int notaCobranca;
	
	public Disciplina() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCursoId(){
		return cursoId;
	}
	
	public void setCursoId(int cursoId){
		this.cursoId = cursoId;
	}
	
	public int getProfessorId(){
		return professorId;
	}
	
	public void setProfessorId(int professorId){
		this.professorId = professorId;
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
	
	public int getNotaDificuldade() {
		return notaDificuldade;
	}
	
	public void setNotaDificuldade(int notaDificuldade) {
		this.notaDificuldade = notaDificuldade;
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
	
	public int getNotaCobranca(){
		return notaCobranca;
	}
	
	public void setNotaCobranca(int notaCobranca){
		this.notaCobranca = notaCobranca;
	}
	
	
}
