package classeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
	
	public String user;
	public String password;
	public String sql;
	public PreparedStatement ps;
	public Connection conn;
	
	public Conexao() {
		try {			
			String driver = "org.mariadb.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mariadb://localhost:3307/";

			user = "root";
			password = "";

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
