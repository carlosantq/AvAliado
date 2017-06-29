package dao;

import java.sql.*;

public class GerenciarConexao {

  private static Connection conexao;

  public static Connection getConexao() {
	  if (conexao == null) {  	
		  String username = "root";
		  String password = "sip12e12";
		  String url = "jdbc:mysql://localhost:3307/AvAliado";
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  conexao = DriverManager.getConnection(url, username, password);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	  return conexao;
  }
}
