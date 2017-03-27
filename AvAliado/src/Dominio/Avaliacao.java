package Dominio;

import java.util.Date;

public class Avaliacao {
	private long id;
	private Date data;
	private Aluno avaliador;
	private TipoAvaliacao tipo;
	private Professor avaliado;
	
	public Avaliacao(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Aluno getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(Aluno avaliador) {
		this.avaliador = avaliador;
	}
	public TipoAvaliacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoAvaliacao tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", data=" + data + ", avaliador=" + avaliador + ", tipo=" + tipo + ", avaliado="
				+ avaliado + "]";
	}
}
