package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	
	private String url  	= "jdbc://localhost/caelum";
	private String user 	= "root";
	private String password = "admin";
	
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		}catch(SQLException er) {
			throw new RuntimeException(er);
		}
	}
}
