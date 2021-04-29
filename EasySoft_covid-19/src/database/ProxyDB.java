package database;

import java.sql.Connection;
import java.sql.SQLException;

import Exception.*;
import utente.Utente;

public class ProxyDB {
	private String query;
	private Connection connector;
	private static ProxyDB istance = new ProxyDB();
	public ProxyDB() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProxyDB getIstance() {
		return istance;
	}
	
	public void checkUtente() {
		
	}
	public void addUtente(Utente utente) throws SQLException,EasySoftException {
		
	}
}
