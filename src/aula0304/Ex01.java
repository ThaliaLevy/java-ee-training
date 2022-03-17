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

		sql = "create database if not exists BDaula";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "use BDaula";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "create table if not exists Alunos(id int, nome varchar(30), telefone varchar(11), email varchar(30))";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "create table if not exists Professores(id int, nome varchar(30), salario double, cpf varchar(11))";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "insert into Alunos(id, nome, telefone, email) values(0, 'Thalia', 21999999, 'thalia@hotmail'), (1, 'Luana', 21999999, 'luana@hotmail'),(2, 'Diego', 21999999, 'diego@hotmail')";
		ps = conn.prepareStatement(sql);
		ps.execute();

		/*
		 * sql = "drop table alunos"; ps = conn.prepareStatement(sql); ps.execute();
		 */

		conn.close();
		System.out.println("Fim");
	}

}
