package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.*;
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
		
		if(rs.next() == false)
		{
			ps.close();
			ConnectorDB.close(connector);
			throw new EasySoftException(ErroriDB.USERNAME_NOT_FOUND);
		}
		
		String tempUsername = rs.getString("USERNAME");
		String tempPassword = rs.getString("HASH_PASSWORD");
		
		if(tempUsername.equals(username) && tempPassword.equals(hashPassword));
		else
		{
			ps.close();
			ConnectorDB.close(connector);
			throw new EasySoftException(ErroriDB.INCORRECT_PASSWORD);
		}
		
		ps.close();
		ConnectorDB.close(connector);
		
		
	}
	public void addUtente(Utente utente) throws SQLException,EasySoftException {
		
	}
}
