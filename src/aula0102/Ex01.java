package aula0102;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex01 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// caminho dos drivers de conexão
		// opcional: String driver = "com.mysql.jdbc.Driver";
		String driver = "org.mariadb.jdbc.Driver";

		// classe que verifica se o drive que estou importando está realmente no meu
		// projeto
		Class.forName(driver);

		// opcional: caso não queira usar o comando "use bancoDados", tb pode-se
		// acrescentar no caminho da url o /BancoDados
		// String url = "jdbc:mariadb://localhost:3307/BDaula";
		String url = "jdbc:mariadb://localhost:3307/";

		String user = "root";
		String password = "";
		String sql;

		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps;

		sql = "create database if not exists BDaula";
		ps = conn.prepareStatement(sql);
		ps.execute();

		// sql = "drop database BDaula2";
		sql = "use BDaula";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "create table if not exists Pessoas(id int, nome varchar(30), cpf varchar(11), idade int)";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "create database if not exists BDTeste";
		ps = conn.prepareStatement(sql);
		ps.execute();

		sql = "use BDTeste";
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
