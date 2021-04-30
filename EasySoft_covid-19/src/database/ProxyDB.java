package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
	/**
	 * {@inheritDoc}
	 */
	public void addUtente_Persona(Utente utente) throws SQLException,EasySoftException{
		query = "INSERT INTO IMPIEGATO(NOME,COGNOME,CODICEFISCALE,TELEFONO) VALUES (?,?,?,?);";
		connector = ConnectorDB.connect();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement ps = connector.prepareStatement(query);
		
		ps.setString(1,utente.getPersona().getNome());
		ps.setString(2,utente.getPersona().getCognome());
		ps.setString(3,utente.getPersona().getCodiceFiscale());
		ps.setString(4,utente.getPersona().getTelefono());
		
		try {
			ps.executeUpdate();
		}
		catch (SQLException ex) {
			ps.close();
			ConnectorDB.close(connector);
			throw new EasySoftException(ErroriDB.PERSONA_ALREADY_EXISTS);
		}
		query = "SELECT last_insert_rowid();";
		ps = connector.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		int lastID = rs.getInt(1);
		
		query = "INSERT INTO UTENTE VALUES (?,?,?,?);";
		ps = connector.prepareStatement(query);
		ps.setString(1,utente.getUsername());
		ps.setString(2,utente.getHashPassword());
		ps.setBoolean(3,utente.isAdmin());
		ps.setInt(4,lastID);
		
		try {
			ps.executeUpdate();
		}
		catch (SQLException ex) {
			query = "DELETE FROM PERSONA WHERE CODICE = ?;";
			ps = connector.prepareStatement(query);
			ps.setInt(1,lastID);
			ps.executeUpdate();
			ps.close();
			ConnectorDB.close(connector);
			throw new EasySoftException(ErroriDB.USERNAME_ALREADY_EXISTS);
		}
		ps.close();
		ConnectorDB.close(connector);
		
	}
	/**
	 * {@inheritDoc}
	 */
	public void addUtente_Medico(Utente utente) throws SQLException,EasySoftException{
		query = "INSERT INTO MEDICO(NOME,COGNOME,DATA_NASCITA) VALUES (?,?,?);";
		connector = ConnectorDB.connect();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement ps = connector.prepareStatement(query);
		
		ps.setString(1,utente.getMedico().getNome());
		ps.setString(2,utente.getMedico().getCognome());
		ps.setString(3,formatter.format(utente.getMedico().getDataNascita()));
		
		try {
			ps.executeUpdate();
		}
		catch (SQLException ex) {
			ps.close();
			ConnectorDB.close(connector);
			throw new EasySoftException(ErroriDB.MEDICO_ALREADY_EXISTS);
		}
		query = "SELECT last_insert_rowid();";
		ps = connector.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		int lastID = rs.getInt(1);
		
		query = "INSERT INTO MEDICO VALUES (?,?,?,?);";
		ps = connector.prepareStatement(query);
		ps.setString(1,utente.getUsername());
		ps.setString(2,utente.getHashPassword());
		ps.setBoolean(3,utente.isAdmin());
		ps.setInt(4,lastID);
		
		try {
			ps.executeUpdate();
		}
		catch (SQLException ex) {
			query = "DELETE FROM MEDICO WHERE CODICE = ?;";
			ps = connector.prepareStatement(query);
			ps.setInt(1,lastID);
			ps.executeUpdate();
			ps.close();
			ConnectorDB.close(connector);
			throw new EasySoftException(ErroriDB.USERNAME_ALREADY_EXISTS);
		}
		ps.close();
		ConnectorDB.close(connector);
	}
	/**
	 * {@inheritDoc}
	 */
	public void addUtente_LabAnalisi(Utente utente) throws SQLException,EasySoftException{
		query = "INSERT INTO LABANALISI(CODICE,HASHPASSWORD) VALUES (?,?);";
		connector = ConnectorDB.connect();
	
		PreparedStatement ps = connector.prepareStatement(query);
		
		ps.setString(1,utente.getLab_analisi().getCodice());
		ps.setString(2,utente.getLab_analisi().getHashPassword());
		
		try {
			ps.executeUpdate();
		}
		catch (SQLException ex) {
			ps.close();
			ConnectorDB.close(connector);
			throw new EasySoftException(ErroriDB.LABANALISI_ALREADY_EXISTS);
		}
		query = "SELECT last_insert_rowid();";
		ps = connector.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		int lastID = rs.getInt(1);
		
		query = "INSERT INTO LABANALISI VALUES (?,?,?,?);";
		ps = connector.prepareStatement(query);
		ps.setString(1,utente.getUsername());
		ps.setString(2,utente.getHashPassword());
		ps.setBoolean(3,utente.isAdmin());
		ps.setInt(4,lastID);
		
		try {
			ps.executeUpdate();
		}
		catch (SQLException ex) {
			query = "DELETE FROM LABANALISI WHERE CODICE = ?;";
			ps = connector.prepareStatement(query);
			ps.setInt(1,lastID);
			ps.executeUpdate();
			ps.close();
			ConnectorDB.close(connector);
			throw new EasySoftException(ErroriDB.USERNAME_ALREADY_EXISTS);
		}
		ps.close();
		ConnectorDB.close(connector);
	}
}
