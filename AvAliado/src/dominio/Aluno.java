package dominio;

public class Aluno extends Pessoa{

	private int periodo;

	public Aluno(){
	}

	public int getPeriodo(){
		return periodo;
	}

	public void setPeriodo (int periodo){
		this.periodo = periodo;
	}
}
