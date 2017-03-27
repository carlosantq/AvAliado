package dominio;

import java.util.Date;

public class Comentario {
	private long id; 
	private String conteudo;
	private Date data;
	private Pessoa ComentadoPor;
	private Pessoa ComentadoEm;
	
	public Comentario(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Pessoa getComentadoPor() {
		return ComentadoPor;
	}
	public void setComentadoPor(Pessoa comentadoPor) {
		ComentadoPor = comentadoPor;
	}
	public Pessoa getComentadoEm() {
		return ComentadoEm;
	}
	public void setComentadoEm(Pessoa comentadoEm) {
		ComentadoEm = comentadoEm;
	}
}
