package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utente.LabAnalisi; 

public class TabellaLaboratorioAnalisi {
	private static Connection conn = null;
	
	/**
	 * Crea la tabella laboratorioAnalisi se non esiste già
	 */
	public void creaTabellaLabAnalisi() {
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL ="CREATE TABLE IF NOT EXISTS LaboratorioAnalisi ("
									+ "PartitaIva 	CHAR(11) PRIMARY KEY, "
									+ "Nome		  	VARCHAR(20) NOT NULL, "
									+ "Telefono		CHAR(10) NOT NULL, "
									+ "Email		VARCHAR(30) NOT NULL "
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
	 * Inserisce nella tabella il laboratorio passato come parametro
	 * Ritorna 1 se il laboratorio è stato inserito correttamente, altrimenti 0
	 *  
	 * @param laboratorioInserito
	 */
	public static int inserisciLaboratorioInTabella(LabAnalisi laboratorioInserito) {
		int verificaInserimento = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			LabAnalisi laboratorio = laboratorioInserito; 
			
			
			String comandoSQL = "INSERT INTO LaboratorioAnalisi(PartitaIva,Nome,Telefono,Email) "
									+ "VALUES ('"+ laboratorio.getPartitaIva() + "','" 
												+ laboratorio.getNome() + "','"
												+ laboratorio.getTelefono() + "','"
												+ laboratorio.getEmail() + "');";
			
		
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
	 * Cerca il laboratorio con partitaIva del parametro. Se la trova ritorna true altrimenti false
	 * @param partitaIva
	 * @return
	 */
	public static boolean cercaLaboratorioInTabella(String partitaIva) {
		boolean trovato = false;
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			// chiede il numero di laboratori che hanno questa partitaIva
			// perciò sarà 0 oppure 1
			String comandoSQL = "SELECT COUNT(*) "
					      + "FROM LaboratorioAnalisi "
					      + "WHERE PartitaIva = '" + partitaIva + "';";
			
			//esegue il comando SQL
			Statement istruzione = conn.createStatement();
			ResultSet risultato= istruzione.executeQuery(comandoSQL);
			
			
			String stringaTrovata = null;
			
			//se viene trovato un laboratorio con partitaIva uguale sarà "1" altrimenti "0" (in string)
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
	 * Modifica nel db gli attributi di un laboratorio
	 * @param laboratorioModificato --> laboratorio già MODIFICATO
	 * @param partitaIvaVecchia --> è usato per indicare quale laboratorio deve essere modificato
	 * N.B. il parametro partitaIvaVecchia deve essere la partitaIva VECCHIA, altrimenti la modifica non avviene
	 * Se si vuole modificare la partitaIva bisogna inserire in partitaIvaVecchia la partita iva PRIMA della modifica
	 * @return 1 se è stata inserita correttamente
	 *		   0 altrimenti
	 */
	public static int modificaLaboratorio(LabAnalisi laboratorioModificato, String partitaIvaVecchia) {
		int verificaInserimento = 0;
		
		try {
			// carica driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			LabAnalisi laboratorio = laboratorioModificato;
			
			String comandoSQL = "UPDATE LaboratorioAnalisi "
						  + "SET Nome = '" + laboratorio.getNome() + "' "
						  		+ ", Telefono = '" + laboratorio.getTelefono() + "' "
						  		+ ",  Email= '" + laboratorio.getEmail() + "' "
						  + "WHERE PartitaIva = '" + partitaIvaVecchia + "'";
			
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
	 * Elimina un laboratorio dalla tabella prendendo come parametro il laboratorio da eliminare
	 * @param laboratorioScelto
	 * @return 1 se il laboratorio è stato eliminato
	 * 		   0 altrimenti
	 */
	public static int eliminaLaboratorioDaTabella(LabAnalisi laboratorioScelto) {
		int verificaEliminazione = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			LabAnalisi laboratorio = laboratorioScelto;
			
			// stringa contenete i comandi SQL
			String comandoSQL = "DELETE "
					      + "FROM LaboratorioAnalisi "
					      + "WHERE PartitaIva = '" + laboratorio.getPartitaIva() + "';";
			
			
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
	
	public static void stampaTabellaLaboratorio() {
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			String comandoSQL = "SELECT * "
						  + "FROM LaboratorioAnalisi;";
			
		
			Statement istruzione = conn.createStatement();
			ResultSet risultato = istruzione.executeQuery(comandoSQL);
			
			System.out.println("PARTITAIVA   NOME                  TELEFONO    EMAIL");
			System.out.println("--------------------------------------------------------------------------");
		
			while (risultato.next()) {
				System.out.printf("%-13s ", risultato.getString(1)); // partita iva
				System.out.printf("%-22s ", risultato.getString(2)); // nome
				System.out.printf("%-12s ", risultato.getString(3)); // telefono
				System.out.printf("%-32s", risultato.getString(4));  // email
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
			String comandoSQL ="DROP TABLE LaboratorioAnalisi;";
		
			
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

