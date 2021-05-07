package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TabellaComuni {
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
	
	/**
	 * Carica dal database tutte le province e le inserisce in un ArrayList ordinato 
	 * @return
	 */
	public static ArrayList<String> caricaProvince() {
		ArrayList<String> listaProvince = new ArrayList<String>();
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL = "SELECT DISTINCT Provincia "
								+ "FROM Comuni;";
			
			//esegue il comando SQL
			Statement istruzione = conn.createStatement();
			ResultSet risultato= istruzione.executeQuery(comandoSQL);
			
			
			String stringaTrovata = null;
			
			while(risultato.next()) {
				stringaTrovata = risultato.getString(1);
				listaProvince.add(stringaTrovata);
			}
			
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ordina in base al nome
		Collections.sort(listaProvince);
		
		return listaProvince;
	}

	
	public static ArrayList<String> caricaComuni(String provinciaInserita) {
		ArrayList<String> listaComuni = new ArrayList<String>();
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL = "SELECT NomeComune "
					      + "FROM Comuni "
					      + "WHERE Provincia = '" + provinciaInserita + "';";
			
			//esegue il comando SQL
			Statement istruzione = conn.createStatement();
			ResultSet risultato= istruzione.executeQuery(comandoSQL);
			
			
			String stringaTrovata = null;
			
			while(risultato.next()) {
				stringaTrovata = risultato.getString(1);
				listaComuni.add(stringaTrovata);
			}
			
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ordina in base al nome
		Collections.sort(listaComuni);
		
		return listaComuni;
	}

	
}
