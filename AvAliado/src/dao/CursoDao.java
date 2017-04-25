package dao;

import java.util.ArrayList;
import java.util.List;

import dominio.Curso;
import dominio.Disciplina;

public class CursoDao implements IDAO<Curso> {

	@Override
	public List<Curso> buscarTodos() {
		List<Curso> resultado = new ArrayList<Curso>();
		
		Curso d1 = new Curso();
		d1.setId(123);
		d1.setNome("BTI");
		d1.setNotaDificuldade(100);
		d1.setNotaFlexibilidade(100);
		d1.setNotaMercadoDeTrabalho(100);
		resultado.add(d1);
		
		Curso d2 = new Curso();
		d2.setId(234);
		d2.setNome("CET");
		d2.setNotaDificuldade(23);
		d2.setNotaFlexibilidade(14);
		d2.setNotaMercadoDeTrabalho(80);
		resultado.add(d2);
		
		Curso d3 = new Curso();
		d3.setId(345);
		d3.setNome("Letras");
		d3.setNotaDificuldade(30);
		d3.setNotaFlexibilidade(10);
		d3.setNotaMercadoDeTrabalho(1);
		resultado.add(d3);

		return resultado;
	}

	@Override
	public Curso buscar(Curso elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Curso novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Curso elemento) {
		// TODO Auto-generated method stub
		
	}

}
