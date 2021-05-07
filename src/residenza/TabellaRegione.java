package residenza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectorDB;
public class TabellaRegione{
	
	
	private static Connection conn = null;
		
	/**
	 * Crea la tabella regioni se non esiste già
	 */
	public static void creaTabellaRegione() {
				
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL = "CREATE TABLE IF NOT EXISTS Regioni ("
									+ "NomeRegione 		VARCHAR(30) NOT NULL, "
									+ "NomeProvincia 	VARCHAR(30) NOT NULL, "
									+ "PRIMARY KEY(NomeRegione,NomeProvincia)"
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
	
	public static int inserisciRegioneInTabella(Regione regioneInserita) {
		int verificaInserimento = 0;
		
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			

			
			
			String comandoSQL = null;
			Statement istruzione = conn.createStatement();
			for(int i = 0; i < regioneInserita.getListaProvincia().size(); i++) {
				comandoSQL = "INSERT INTO Regioni(NomeRegione, NomeProvincia) "
										+ "VALUES ('"+ regioneInserita.getNomereg() + "','" 
													 + regioneInserita.getListaProvincia().get(i).getNome() + "')";
			
			
				//ritorna 1 se è stata inserita altrimenti 0
				verificaInserimento = istruzione.executeUpdate(comandoSQL);
			}
			// chiude connessione database
			ConnectorDB.close(conn);
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return verificaInserimento;
	}
	
	//***** NON FUNZIONA - DA SISTEMARE ******+
	public static void stampaTabellaRegione() {
		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			String comandoSQL = "SELECT * "
						  + "FROM Regioni;";
			
		
			Statement istruzione = conn.createStatement();
			ResultSet risultato = istruzione.executeQuery(comandoSQL);
			
			System.out.println("NOMEREG              CAPOLUOGO          ");
			System.out.println("--------------------------------------------------------------------------");
		
			while (risultato.next()) {
				System.out.printf("%-16s ", risultato.getString(1)); // NOME REGIONE
				System.out.printf("%-22s ", risultato.getString(2)); // CAPOLUOGO
				System.out.println("\n--------------------------------------------------------------------------");
			}
			
			// chiude connessione database
			ConnectorDB.close(conn);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void eliminaTabellaRegione() {

		try {
			// caricamento del driver
			new com.mysql.cj.jdbc.Driver();
		
			// crea una connessione al database "dbTamponi" usando credenziali di accesso appropriate.
			conn = ConnectorDB.connect();
			
			// stringa contenete i comandi SQL
			String comandoSQL ="DROP TABLE Regioni;";
		
			
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
	
	public static ArrayList<Provincia> getListaProvince(Regione regioneInserita){
		ArrayList<Provincia> listaProvince = new ArrayList<Provincia>();
		
		
		
		return listaProvince;
	}
}
