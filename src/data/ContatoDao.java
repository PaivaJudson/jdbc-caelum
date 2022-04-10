package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao {

	private Connection conexao;
	
	public ContatoDao() {
		this.conexao = new FabricaDeConexao().getConnection();
	}
	
	
	public boolean inserirRegisto(Contato contato) {

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
	
	public List<Contato> pesquisarRegisto(Contato contato) {
		
		String querySql = "SELECT * FROM CONTATO";
		
		try {
			PreparedStatement stm = conexao.prepareStatement(querySql);
			ResultSet rs = stm.executeQuery();
			List<Contato> lista = new ArrayList<Contato>();
			
			while(rs.next()) {
				lista.add(new Contato(rs.getString("NOME"), rs.getString("EMAIL"), rs.getString("ENDERECO")));
			}
			
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
