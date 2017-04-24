package dominio;

import java.util.Date;

public class AvaliacaoUniversidade {

	private int matriculaPessoa;
	private int idUniversidade;
	private boolean estrutura;
	private boolean vidaCultural;
	private boolean auxilios;
	private Date data;
	private String comentario;
	
	public AvaliacaoUniversidade() {
		
	}
	
	public int getMatriculaPessoa() {
		return matriculaPessoa;
	}
	public void setMatriculaPessoa(int matriculaPessoa) {
		this.matriculaPessoa = matriculaPessoa;
	}
	public int getIdUniversidade() {
		return idUniversidade;
	}
	public void setIdUniversidade(int idUniversidade) {
		this.idUniversidade = idUniversidade;
	}
	public boolean isEstrutura() {
		return estrutura;
	}
	public void setEstrutura(boolean estrutura) {
		this.estrutura = estrutura;
	}
	public boolean isVidaCultural() {
		return vidaCultural;
	}
	public void setVidaCultural(boolean vidaCultural) {
		this.vidaCultural = vidaCultural;
	}
	public boolean isAuxilios() {
		return auxilios;
	}
	public void setAuxilios(boolean auxilios) {
		this.auxilios = auxilios;
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
