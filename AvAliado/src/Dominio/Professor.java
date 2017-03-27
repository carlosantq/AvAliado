package Dominio;

import java.util.ArrayList;

public class Professor extends Pessoa {
	private ArrayList<Avaliacao> prova;
	private ArrayList<Avaliacao> didatica;
	private ArrayList<Avaliacao> personalidade;
	private String descricao;
	private ArrayList<Comentario> comentarios;
	public ArrayList<Avaliacao> getProva() {
		return prova;
	}
	public void setProva(ArrayList<Avaliacao> prova) {
		this.prova = prova;
	}
	public ArrayList<Avaliacao> getDidatica() {
		return didatica;
	}
	public void setDidatica(ArrayList<Avaliacao> didatica) {
		this.didatica = didatica;
	}
	public ArrayList<Avaliacao> getPersonalidade() {
		return personalidade;
	}
	public void setPersonalidade(ArrayList<Avaliacao> personalidade) {
		this.personalidade = personalidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "Professor [prova=" + prova + ", didatica=" + didatica + ", personalidade=" + personalidade
				+ ", descricao=" + descricao + ", comentarios=" + comentarios + "]";
	}
	
}
