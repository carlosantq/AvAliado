package dominio;

public class Professor extends Pessoa{

	int didaticaLike;
	int didaticaDislike;
	int provasLike;
	int provasDislike;
	int personalidadeLike;
	int personalidadeDislike;

	public Professor(){
	}

	public int getDidaticaLike(){
		return didaticaLike;
	}
	
	public void setDidaticaLike (int didaticaLike){
		this.didaticaLike = didaticaLike;
	}

	public int getDidaticaDislike(){
		return didaticaDislike;
	}
	
	public void setDidaticaDislike (int didaticaDislike){
		this.didaticaDislike = didaticaDislike;
	}

	public int getProvasLike(){
		return provasLike;
	}
	
	public void setProvasLike (int provasLike){
		this.provasLike = provasLike;
	}

	public int getProvasDislike(){
		return provasDislike;
	}
	
	public void setProvasDislike (int provasDislike){
		this.provasDislike = provasDislike;
	}

	public int getPersonalidadeLike(){
		return personalidadeLike;
	}
	
	public void setPersonalidadeLike (int personalidadeLike){
		this.personalidadeLike = personalidadeLike;
	}

	public int getPersonalidadeDislike(){
		return personalidadeDislike;
	}

	public void setPersonalidadeDislike (int personalidadeDislike){
		this.personalidadeDislike = personalidadeDislike;
	}
}
