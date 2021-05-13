package database;

import java.sql.*;
import utente.Persona;

public class TabellaPersona {
	private static Connection conn = null;
	
	/**
	 * Crea la tabella persona se non esiste già
	 */
	public static void creaTabellaPersona() {
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL ="CREATE TABLE IF NOT EXISTS Persona ("
									+ "CodiceFiscale 	CHAR(16) PRIMARY KEY, "
									+ "Nome		  	VARCHAR(20) NOT NULL, "
									+ "Cognome		VARCHAR(20) NOT NULL, "
									+ "Provincia	VARCHAR(30) NOT NULL, "
									+ "Comune		VARCHAR(30) NOT NULL, "
									+ "Via		 	VARCHAR(30) NOT NULL, "
									+ "Civico		CHAR(4) NOT NULL, "
									+ "Username		VARCHAR(30) NOT NULL "
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

	/**
	 * Inserisce nella tabella la persona passata come parametro
	 * Ritorna 1 se la persona è stata inserita correttamente, altrimenti 0
	 *  
	 * @param personaInserita
	 */
	public static int inserisciPersonaInTabella(Persona personaInserita) {
		int verificaInserimento = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			Persona persona = personaInserita; 
			
			
			String comandoSQL = "INSERT INTO Persona(CodiceFiscale,Nome,Cognome,Telefono,Pronvicia,Comune,Via,Civico,Username) "
									+ "VALUES ('"+ persona.getCodiceFiscale() + "','" 
												+ persona.getNome() + "','"
												+ persona.getCognome() + "','"
												+ persona.getTelefono() + "','"
												+ persona.getProvincia()+ "','"
												+ persona.getComune() + "','"
												+ persona.getVia() + "','"
												+ persona.getCivico() + "','"
												+ persona.getUsername() + "')";
			
		
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
	
	/**
	 * Cerca la persona con codicefiscale del parametro. Se la trova ritorna true altrimenti false
	 * @param codiceFiscale
	 * @return
	 */
	public static boolean cercaPersonaInTabella(String codiceFiscale) {
		boolean trovata = false;
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			// chiede il numero di persona che hanno questo codice fiscale
			// perciò sarà 0 oppure 1
			String comandoSQL = "SELECT COUNT(*) "
					      + "FROM Persona "
					      + "WHERE CodiceFiscale = '" + codiceFiscale + "';";
			
			//esegue il comando SQL
			Statement istruzione = conn.createStatement();
			ResultSet risultato= istruzione.executeQuery(comandoSQL);
			
			
			String stringaTrovata = null;
			
			//se viene trovata una persona con codice fiscale uguale sarà "1" altrimenti "0" (in string)
			while(risultato.next()) {
			 stringaTrovata = risultato.getString(1);
			}
			
			trovata = stringaTrovata.equals("1");// "trovata" sarà true se la stringa è "1", altrimenti false 
			
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trovata;
	}
	
	/**
	 * Modifica nel db gli attributi di una persona
	 * @param personaModificata --> persona già MODIFICATA
	 * @param codFiscaleVecchio --> è usato per indicare quale persona deve essere modificata
	 * N.B. il parametro codFiscaleVecchio deve essere il codice fiscale VECCHIO, altrimenti la modifica non avviene
	 * Se si vuole modificare il codice fiscale bisogna inserire in codFiscaleVecchio il codice fiscale PRIMA della modifica
	 * @return 1 se è stata inserita correttamente
	 *		   0 altrimenti
	 */
	public static int modificaPersona(Persona personaModificata, String codFiscaleVecchio) {
		int verificaInserimento = 0;
		
		try {
			// carica driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			Persona persona = personaModificata;
			
			String comandoSQL = "UPDATE Persona "
						  + "SET Nome = '" + persona.getNome() + "' "
						  		+ ", Cognome = '" + persona.getCognome() + "' "
						  		+ ", Telefono = '" + persona.getTelefono() + "' "
						  + "WHERE CodiceFiscale = '" + codFiscaleVecchio + "'";
			
			Statement istruzione = conn.createStatement();
			// carica il comando SQL
			//ritorna 1 se è stata inserita altrimenti 0
			verificaInserimento = istruzione.executeUpdate(comandoSQL);
			
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verificaInserimento;
	}

	/**
	 * Elimina una persona dalla tabella prendendo come parametro la persona da eliminare
	 * @param personaScelta
	 * @return 1 se la persona è stata eliminata
	 * 		   0 altrimenti
	 */
	public static int eliminaPersonaDaTabella(Persona personaScelta) {
		int verificaEliminazione = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			Persona persona = personaScelta;
			
			// stringa contenete i comandi SQL
			String comandoSQL = "DELETE "
					      + "FROM Persona "
					      + "WHERE CodiceFiscale = '" + persona.getCodiceFiscale() + "';";
			
			
			//esegue il comando SQL
			Statement istruzione = conn.createStatement();
			verificaEliminazione = istruzione.executeUpdate(comandoSQL);
			
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return verificaEliminazione;
	}
	
	public static void stampaTabellaPersona() {
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			String comandoSQL = "SELECT * "
						  + "FROM Persona;";
			
		
			Statement istruzione = conn.createStatement();
			ResultSet risultato = istruzione.executeQuery(comandoSQL);
			
			System.out.println("CODICEFISCALE    NOME                   COGNOME                TELEFONO");
			System.out.println("--------------------------------------------------------------------------");
		
			while (risultato.next()) {
				System.out.printf("%-16s ", risultato.getString(1)); // codice fiscale
				System.out.printf("%-22s ", risultato.getString(2)); // nome
				System.out.printf("%-22s ", risultato.getString(3)); // cognome
				System.out.printf("%-12s", risultato.getString(4)); // telefono
				System.out.println("\n--------------------------------------------------------------------------");
			}
			
			// chiude connessione database
			ConnectorDB.close(conn);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void eliminaTabella() {
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL ="DROP TABLE Persona;";
		
			
			Statement istruzione = conn.createStatement();
			// elimina tabella
			istruzione.execute(comandoSQL);

			// chiude connessione database
			ConnectorDB.close(conn);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
