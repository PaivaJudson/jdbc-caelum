package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.Contato;
import data.FabricaDeConexao;


public class Main {
	
	static Connection conexao;
	
	public static void main(String[] args) throws SQLException {
		
		conexao = new FabricaDeConexao().getConnection();
		System.out.println("Conexão aberta!");
		
		Contato contato = new Contato("Quissanga Paiva", "judson.paiva@isptec.co.ao", "Luanda - Angola");
		
		inserirRegisto(contato);
		conexao.close();
		
	}
	
	public static boolean inserirRegisto(Contato contato) {

		String querySql = "INSERT INTO CONTATO(NOME, EMAIL, ENDERECO)" +
						  "VALUES(?,?,?)";
		
		try(PreparedStatement stm = conexao.prepareStatement(querySql);){
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			stm.execute();
		}catch(SQLException err) {
			err.printStackTrace();
		}
		return true;
	}
	
	public static void verRegistos() {
		
	}

}
