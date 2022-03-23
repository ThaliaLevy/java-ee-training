package aula0304;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o nome a ser buscado: ");
		String nomeBuscado = ler.nextLine();
		
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

		sql = "SELECT id, nome, telefone, email FROM alunos;";
		ps = conn.prepareStatement(sql);

		ResultSet resultado = ps.executeQuery();

		while (resultado.next()) {
			String nome = resultado.getString("nome");
			if(nomeBuscado.equalsIgnoreCase(nome)) {
				int id = resultado.getInt("id");
				int telefone = resultado.getInt("telefone");
				String email = resultado.getString("email");
				
				System.out.println(id + " " + nome + " " + telefone + " " + email);
				System.out.println("Deseja alterar o telefone desta pessoa?");
				System.out.println("1 para sim; 2 para não");
				
				String op = ler.nextLine();
				switch(op) {
				case "1":{
					System.out.println("Digite o novo número: ");
					int numeroNovo = ler.nextInt();
					// sem utilizar interrogação
					//sql = "UPDATE alunos SET telefone = '"+numeroNovo+"' WHERE nome = '"+nome+"';";
					
					// com interrogação
					sql = "UPDATE alunos SET telefone = ? WHERE nome = ?;";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, numeroNovo);
					ps.setString(2, nome);
					ps.executeUpdate();
					System.out.println("Alterado!");
					break;
				}
				case "2": {
					System.out.println("Não houve alteração. Obrigada!");
					break;
				}
				default: break;
				}
			}
		}

		conn.close();
		System.out.println("Fim");
	}

}
