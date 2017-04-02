package dominio;

public class Professor extends Pessoa{

	private int notaDidatica;
	private int notaProvas;
	private int notaPersonalidade;

	public Professor(){
	}

	public int getNotaDidatica(){
		return notaDidatica;                                               
	}
	
	public void setNotaDidatica (int notaDidatica){
		this.notaDidatica = notaDidatica;
	}
	public int getNotaProvas(){
		return notaProvas;
	}
	
	public void setNotaProvas (int notaProvas){
		this.notaProvas = notaProvas;
	}

	public int getNotaPersonalidade(){
		return notaPersonalidade;
	}
	
	public void setNotaPersonalidade (int notaPersonalidade){
		this.notaPersonalidade = notaPersonalidade;
	}
}

