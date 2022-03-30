package classeDAO;

import java.sql.SQLException;

public class ProdutoDAO {

	public String mensagem;
	
	// argumento da função é o objeto da classe Produto
	public boolean cadastrarEx01(Produto p) {
		try {
			Conexao c = new Conexao();

			c.sql = "create database if not exists BDProduto";
			c.ps = c.conn.prepareStatement(c.sql);
			c.ps.execute();
			
			c.sql = "use BDProduto";
			c.ps = c.conn.prepareStatement(c.sql);
			c.ps.execute();

			c.sql = "create table if not exists Produto(nome varchar(20), marca varchar(20), valor double, codigoBarras varchar(30));";
			c.ps = c.conn.prepareStatement(c.sql);
			c.ps.execute();

			c.sql = "insert into Produto(nome, marca, valor, codigoBarras) values(?, ?, ?, ?)";
			c.ps = c.conn.prepareStatement(c.sql);
			c.ps.setString(1, p.getNome());
			c.ps.setString(2, p.getMarca());
			c.ps.setDouble(3, p.getValor());
			c.ps.setString(4, p.getCodigoBarra());
			c.ps.execute();

			c.conn.close();

			mensagem = "Cadastro de produto realizado com sucesso!";
			return true;
			
			//o ideal é utilizar a forma acima, de salvar 1 msg em variavel e,
			//após retorno de booleano, a mensagem ser exibida em outra classe
			//NENHUMA msg ou interação com o usuario deve ser feita pela classe DAO
			//System.out.println("Cadastro de produto realizado com sucesso!");

		} catch (SQLException e) {
			mensagem = " " + e;
			return false;
		}
	}

	// argumento da função tem atributos individuais do objeto da classe Produto
	public void cadastrarEx02(String marca, String nome) {
		System.out.println(marca + nome);
	}
}
