package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GerenciarConexao;
import dominio.Universidade;

public class UniversidadeDao implements IDAO<Universidade>{

	@Override
	public List<Universidade> buscarTodos() {
		List<Universidade> resultado = new ArrayList<Universidade>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Universidade";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Universidade universidade = new Universidade();
				universidade.setId(rs.getInt("id"));
				universidade.setNome(rs.getString("nome"));
				universidade.setSigla(rs.getString("sigla"));
				universidade.setEndereco(rs.getString("endereco"));
				universidade.setTelefone(rs.getString("telefone"));
				universidade.setNotaEstrutura(rs.getInt("notaEstrutura"));
				universidade.setNotaVidaCultural(rs.getInt("notaVidaCultural"));
				universidade.setNotaAuxilios(rs.getInt("notaAuxilios"));
				resultado.add(universidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Universidade buscar(Universidade elemento) {
		Universidade resultado = new Universidade();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Universidade WHERE id="+elemento.getId();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setId(rs.getInt("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setSigla(rs.getString("sigla"));
				resultado.setEndereco(rs.getString("endereco"));
				resultado.setTelefone(rs.getString("telefone"));
				resultado.setNotaEstrutura(rs.getInt("notaEstrutura"));
				resultado.setNotaVidaCultural(rs.getInt("notaVidaCultural"));
				resultado.setNotaAuxilios(rs.getInt("notaAuxilios"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public Universidade buscar(int id){
		Universidade resultado = new Universidade();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Universidade WHERE id="+id;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setId(rs.getInt("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setSigla(rs.getString("sigla"));
				resultado.setEndereco(rs.getString("endereco"));
				resultado.setTelefone(rs.getString("telefone"));
				resultado.setNotaEstrutura(rs.getInt("notaEstrutura"));
				resultado.setNotaVidaCultural(rs.getInt("notaVidaCultural"));
				resultado.setNotaAuxilios(rs.getInt("notaAuxilios"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void inserir(Universidade novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Universidade VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, novo.getId());
			ps.setString(2, novo.getNome());
			ps.setString(3, novo.getSigla());
			ps.setString(4, novo.getEndereco());
			ps.setString(5, novo.getTelefone());
			ps.setInt(6, novo.getNotaEstrutura());
			ps.setInt(7, novo.getNotaVidaCultural());
			ps.setInt(8, novo.getNotaAuxilios());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Universidade elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Universidade elemento) {
		// TODO Auto-generated method stub
		
	}
	
	public Universidade buscarNotas(int id){
		Universidade resultado = new Universidade();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT CAST(((SELECT COUNT(estrutura) FROM AvaliacaoUniversidade WHERE universidadeId='"+id+"' and "
				+ "estrutura=true)/notaEstrutura)*100 AS decimal(10, 2)) AS notaEstrutura, CAST(((SELECT COUNT(vidaCultural) FROM AvaliacaoUniversidade "
				+ "WHERE universidadeId='"+id+"' and vidaCultural=true)/notaVidaCultural)*100 AS decimal(10, 2)) AS notaVidaCultural, "
				+ "CAST(((SELECT COUNT(auxilios) FROM AvaliacaoUniversidade WHERE universidadeId='"+id+"' and "
				+ "auxilios=true)/notaAuxilios)*100 AS decimal(10, 2)) AS notaAuxilios FROM Universidade WHERE id='"+id+"';";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				resultado.setId(id);
				resultado.setNotaEstrutura(rs.getInt("notaEstrutura"));
				resultado.setNotaVidaCultural(rs.getInt("notaVidaCultural"));
				resultado.setNotaAuxilios(rs.getInt("notaAuxilios"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean buscarVinculo(int matricula, int universidadeId){
		boolean returnInformation = false;
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM VinculoUniversidade WHERE pessoaID="+ matricula + " AND universidadeID =" + universidadeId;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				returnInformation = false;
			}else{
				returnInformation = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return returnInformation;
	}
	
	

}
