package dominio;

import java.util.Date;

public class AvaliacaoAlunoProfessor {
	int matriculaAluno;
	int matriculaProfessor;
	int didatica;
	int provas;
	int personalidade;
	Date data;

	public AvaliacaoAlunoProfessor(){
	}

	public int getMatriculaAluno(){
		return matriculaAluno;
	}
	
	public void setMatriculaAluno (int matriculaAluno){
		this.matriculaAluno = matriculaAluno;
	}

	public int getMatriculaProfessor(){
		return matriculaProfessor;
	}
	
	public void setMatriculaProfessor (int matriculaProfessor){
		this.matriculaProfessor = matriculaProfessor;
	}

	public int getDidatica(){
		return didatica;
	}
	
	public void setDidatica (int didatica){
		this.didatica = didatica;
	}

	public int getProvas(){
		return provas;
	}
	
	public void setProvas (int provas){
		this.provas = provas;
	}

	public int getPersonalidade(){
		return personalidade;
	}
	
	public void setPersonalidade (int personalidade){
		this.personalidade = personalidade;
	}

	public Date getData(){
		return data;
	}

	public void setData (Date data){
		this.data = data;
	}

	public String toString(){
		return "matriculaAluno = " + matriculaAluno + "matriculaProfessor = " + matriculaProfessor + "didatica = " + didatica + "provas = " + provas + "personalidade = " + personalidade + "data = " + data;
	}
}
