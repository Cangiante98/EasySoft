package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class OperazioniTabellaDB {
	private static Connection conn = null;
	
	/**
	 * crea tabella nel database in base al comandoSQL passato
	 * @param comandoSQL --> comando per la creazione della specifica tabella
	 * 
	 */
	public static void creaTabella(String comandoSQL) {
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			
			Statement istruzione = conn.createStatement();
			istruzione.execute(comandoSQL);
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			// chiude connessione database
			try {
				ConnectorDB.close(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Inserisce una riga con di attributi nella tabella specificata
	 * Ritorna 1 se la riga è stata inserita correttamente, altrimenti 0
	 *  
	 * @param comandoSQL --> comando per la creazione della specifica tabella
	 */
	public static int inserisciRigaInTabella(String comandoSQL) {
		int verificaInserimento = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
		
			Statement istruzione = conn.createStatement();
			//inserisce le riga nella tabella se non esiste già
			//ritorna 1 se è stata inserita altrimenti 0
			verificaInserimento = istruzione.executeUpdate(comandoSQL);
			
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			// chiude connessione database
			try {
				ConnectorDB.close(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return verificaInserimento;
	}
	
	/**
	 * Cerca un riferimento nella tabella specificata nel comando SQL passato. Se lo trova ritorna true altrimenti false
	 * @param comandoSQL
	 * @return true se è stato trovato un riferimento altrimenti false
	 */
	public static boolean cercaInTabella(String comandoSQL) {
		boolean trovato = false;
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			
			//esegue il comando SQL
			Statement istruzione = conn.createStatement();
			ResultSet risultato= istruzione.executeQuery(comandoSQL);
			
			
			String stringaTrovata = null;
			
			// stringaTrovata conterrà 1 se viene trovata la corrispondenza, altrimenti 0 (in string)
			while(risultato.next()) {
			 stringaTrovata = risultato.getString(1);
			}
			
			trovato = stringaTrovata.equals("1");// "trovato" sarà true se la stringa è "1", altrimenti false 
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			// chiude connessione database
			try {
				ConnectorDB.close(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return trovato;
	}
	
	/**
	 * Carica dal database tutte le province e le inserisce in un Array ordinato 
	 * @return
	 */
	public static String[] caricaProvince() {
		ArrayList<String> listaProvince = new ArrayList<String>();
		String arrayListaProvince[] = null;  
		
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
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			// chiude connessione database
			try {
				ConnectorDB.close(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// ordina in base al nome
		Collections.sort(listaProvince);
		
		//copia l'arraylist in un array cosi da ritornare l'array 
		arrayListaProvince = listaProvince.toArray(new String[listaProvince.size()]);
		
		return arrayListaProvince;
	}

	/**
	 * Carica dal database tutti i comuni e li inserisci in un Array ordinato 
	 * @param provinciaInserita
	 * @return
	 */
	public static String[] caricaComuni(String provinciaInserita) {
		ArrayList<String> listaComuni = new ArrayList<String>();
		String arrayListaComuni[] = null;  
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
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			// chiude connessione database
			try {
				ConnectorDB.close(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		// ordina in base al nome
		Collections.sort(listaComuni);
		
		//copia l'arraylist in un array cosi da ritornare l'array 
		arrayListaComuni = listaComuni.toArray(new String[listaComuni.size()]);
		
		return arrayListaComuni;
	}

	
}
