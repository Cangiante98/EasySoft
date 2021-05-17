package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utente.Utente;

public class TabellaUtente {
	
	private static Connection conn = null;
	
	/**
	 * Cerca la persona con codicefiscale del parametro. Se la trova ritorna true altrimenti false
	 * @param codiceFiscale
	 * @return
	 */
	public static boolean cercaUtenteInTabella(String username) {
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
					      + "FROM Utente "
					      + "WHERE Username = '" + username + "';";
			
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
	 * Inserisce nella tabella la persona passata come parametro
	 * Ritorna 1 se la persona è stata inserita correttamente, altrimenti 0
	 *  
	 * @param personaInserita
	 */
	public static int inserisciUtenteInTabella(Utente utenteInserito) {
		int verificaInserimento = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
		
			String comandoSQL = "INSERT INTO Utente(Username,Password) "
									+ "VALUES ('"+ utenteInserito.getUsername() + "','" 
												+ utenteInserito.getHashPassword() + "')";
			
		
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
