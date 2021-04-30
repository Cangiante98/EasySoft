package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.*;
import it.uniba.di.prog2.cs2021.gruppo31.database.ConnectorDB;
import utente.Utente;

public class ProxyDB {
	private String query;
	private Connection connector;
	private static ProxyDB istance = new ProxyDB();
	
	private ProxyDB() {}
	
	public static ProxyDB getIstance() {
		return istance;
	}
	
	public void checkUtente(String username, String hashPassword)throws SQLException,EasySoftException {
		query = "SELECT USERNAME,HASH_PASSWORD FROM UTENTE WHERE USERNAME LIKE '" + username + "';";
		connector = ConnectorDB.connect();
		
		PreparedStatement ps = connector.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		
	}
	public void addUtente(Utente utente) throws SQLException,EasySoftException {
		
	}
}
