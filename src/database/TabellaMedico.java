package database;

import java.sql.*;
import utente.Medico;

public class TabellaMedico {
	private static Connection conn = null;
	
	/**
	 * Crea la tabella Medico se non esiste già
	 */
	public static void creaTabellaMedico() {
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL ="CREATE TABLE IF NOT EXISTS Medico ("
									+ "CodiceFiscale 	CHAR(10) PRIMARY KEY, "
									+ "Nome		  	VARCHAR(20) NOT NULL, "
									+ "Cognome		VARCHAR(20) NOT NULL, "
									+ "Telefono		CHAR(12) NOT NULL "
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
	 * Inserisce nella tabella il Medico passato come parametro
	 * Ritorna 1 se il Medico è stato inserito correttamente, altrimenti 0
	 *  
	 * @param medicoInserito
	 */
	public static int inserisciMedicoInTabella(Medico medicoInserito) {
		int verificaInserimento = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			Medico medico = medicoInserito; 
			
			
			String comandoSQL = "INSERT INTO Medico(CodiceFiscale,Nome,Cognome,Telefono) "
									+ "VALUES ('"+ medico.getCodiceFiscale() + "','" 
												+ medico.getNome() + "','"
												+ medico.getCognome() + "','"
												+ medico.getTelefono() + "')";
			
		
			Statement istruzione = conn.createStatement();
			//inserisce il medico nella tabella se non esiste già
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
	 * Cerca il medico con codicefiscale del parametro. Se lo trova ritorna true altrimenti false
	 * @param codiceFiscale
	 * @return
	 */
	public static boolean cercaMedicoInTabella(String codiceFiscale) {
		boolean trovato = false;
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			// chiede il numero di persona che hanno questo codice fiscale
			// perciò sarà 0 oppure 1
			String comandoSQL = "SELECT COUNT(*) "
					      + "FROM Medico "
					      + "WHERE CodiceFiscale = '" + codiceFiscale + "';";
			
			//esegue il comando SQL
			Statement istruzione = conn.createStatement();
			ResultSet risultato= istruzione.executeQuery(comandoSQL);
			
			
			String stringaTrovata = null;
			
			//se viene trovato un medico con codice fiscale uguale sarà "1" altrimenti "0" (in string)
			while(risultato.next()) {
			 stringaTrovata = risultato.getString(1);
			}
			
			trovato = stringaTrovata.equals("1");// "trovato" sarà true se la stringa è "1", altrimenti false 
			
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return trovato;
	}
	
	/**
	 * Modifica nel db gli attributi di un medico
	 * @param medicoModificato --> medico già MODIFICATo
	 * @param codFiscaleVecchio --> è usato per indicare quale medico deve essere modificato
	 * N.B. il parametro codFiscaleVecchio deve essere il codice fiscale VECCHIO, altrimenti la modifica non avviene
	 * Se si vuole modificare il codice fiscale bisogna inserire in codFiscaleVecchio il codice fiscale PRIMA della modifica
	 * @return 1 se è stata inserita correttamente
	 *		   0 altrimenti
	 */
	public static int modificaMedico(Medico medicoModificato, String codFiscaleVecchio) {
		int verificaInserimento = 0;
		
		try {
			// carica driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			Medico medico = medicoModificato;
			
			String comandoSQL = "UPDATE Medico "
						  + "SET Nome = '" + medico.getNome() + "' "
						  		+ ", Cognome = '" + medico.getCognome() + "' "
						  		+ ", Telefono = '" + medico.getTelefono() + "' "
						  + "WHERE CodiceFiscale = '" + codFiscaleVecchio + "'";
			
			Statement istruzione = conn.createStatement();
			// carica il comando SQL
			//ritorna 1 se è stato inserito altrimenti 0
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
	 * Elimina un medico dalla tabella prendendo come parametro il medico da eliminare
	 * @param medicoScelta
	 * @return 1 se il medico è stato eliminato
	 * 		   0 altrimenti
	 */
	public static int eliminaMedicoDaTabella(Medico medicoScelto) {
		int verificaEliminazione = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			Medico medico = medicoScelto;
			
			// stringa contenete i comandi SQL
			String comandoSQL = "DELETE "
					      + "FROM Medico "
					      + "WHERE CodiceFiscale = '" + medico.getCodiceFiscale() + "';";
			
			
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
	
	public static void stampaTabellaMedico() {
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			String comandoSQL = "SELECT * "
						  + "FROM Medico;";
			
		
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
			String comandoSQL ="DROP TABLE Medico;";
		
			
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