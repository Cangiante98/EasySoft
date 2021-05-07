package residenza;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectorDB;

public class TabellaComune {
	private static Connection conn = null;
	
	/**
	 * Crea la tabella comuni se non esiste già
	 */
	public static void creaTabellaComuni() {
				
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL = "CREATE TABLE IF NOT EXISTS Comuni ("
									+ "NomeComune 		VARCHAR(100) NOT NULL, "
									+ "Regione 			VARCHAR(100) NOT NULL, "
									+ "Provincia 		VARCHAR(100) NOT NULL, "
									+ "PRIMARY KEY(NomeComune,Regione,Provincia)"
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
	
	public static int inserisciComunaInTabella(String comune, String regione, String provincia) {
		int verificaInserimento = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			

			
			
			
			
			String comandoSQL = "INSERT INTO Comuni(NomeComune, Regione, Provincia) "
									+ "VALUES ('"+ comune + "','" 
												 + regione + "','"
												 + provincia + "')";
			
			Statement istruzione = conn.createStatement();
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
