package aula0304;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex01 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver = "org.mariadb.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mariadb://localhost:3307/";

		String user = "root";
		String password = "";
		String sql;

		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps;

		sql = "create database if not exists BDTeste";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "use BDTeste";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "insert into Alunos(id, nome) values(?, ?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 10);
		ps.setString(2, "Testando ?");
		ps.execute();
		
		conn.close();
		System.out.println("Fim");
	}

}
