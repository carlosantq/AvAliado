package dao;

import java.sql.*;

public class GerenciarConexao {

  private static Connection conexao;

  public static Connection getConexao() {
	  if (conexao == null) {  	
		  String username = "root";
		  String password = "imd@2017";
		  String url = "jdbc:mysql://localhost:3306/AvAliado";
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
