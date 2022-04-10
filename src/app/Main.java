package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Contato;
import data.ContatoDao;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		
		Contato contato = new Contato("QUISSANGA COGE", "judson.paiva@isptec.co.ao", "Luanda - Angola");
		ContatoDao contatoDao = new ContatoDao();
		
		//boolean res = contatoDao.inserirRegisto(contato);
		//System.out.println(res);
		
		List<Contato> lista = contatoDao.pesquisarRegisto(contato);
		//for(Contato contato1 lista) {
			
		}
		
	}
}
