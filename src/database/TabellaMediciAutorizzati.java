package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import utente.Persona;

public class TabellaMediciAutorizzati {
	private static Connection conn = null;
	
	public static void creaTabellaMediciAutorizzati() {
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL ="CREATE TABLE IF NOT EXISTS MediciAutorizzati ("
									+ "CodiceFiscale 	VARCHAR(30) PRIMARY KEY"
									+ ");";
		
			
			Statement istruzione = conn.createStatement();
			// crea tabella se non esiste già
			istruzione.execute(comandoSQL);
			
			// chiude connessione database
			ConnectorDB.close(conn);

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int inserisciMedicoAutorizzatoInTabella(String codice) {
		int verificaInserimento = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			String comandoSQL = "INSERT INTO MediciAutorizzati(Codice) "
									+ "VALUES ('"+ codice + "')";
			
		
			Statement istruzione = conn.createStatement();
			//inserisce la persona nella tabella se non esiste già
			//ritorna 1 se è stata inserita altrimenti 0
			verificaInserimento = istruzione.executeUpdate(comandoSQL);
			
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return verificaInserimento;
	}

	
}
