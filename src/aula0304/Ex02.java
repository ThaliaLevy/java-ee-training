package aula0304;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex02 {

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

		// posição:   1    2     3      4 > as posições começam do 1
		sql = "SELECT id, nome, telefone, email FROM alunos;";
		ps = conn.prepareStatement(sql);
		
		// recebe o resultado da consulta de uma query
		ResultSet resultado = ps.executeQuery();

		// next() > faz a leitura enquanto houver indice de 1 array
		while (resultado.next()) {
			// pegando o valor do indice do array
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			int telefone = resultado.getInt("telefone");
			String email = resultado.getString("email");
			
			System.out.println(id + " " + nome + " " + telefone + " " + email);
		}

		conn.close();
		System.out.println("Fim");
	}

}
