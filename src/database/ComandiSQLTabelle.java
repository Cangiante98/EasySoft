package database;

import utente.Medico;
import utente.Persona;
import utente.Utente;

/**
 * 
 * @author ETTORE
 * Classe che contiene tutte le query SQL per il database
 * Creazione tabelle, modifica tabelle, inserimento in tabelle, ricerca in tabelle ecc.
 */
public class ComandiSQLTabelle {
	
	// Metodi per tabella Persona
	public static String creaTabPersona() {
		return "CREATE TABLE IF NOT EXISTS Persona ("
				+ "CodiceFiscale 	VARCHAR(16) PRIMARY KEY, "
				+ "Nome		  		VARCHAR(30) NOT NULL, "
				+ "Cognome			VARCHAR(30) NOT NULL, "
				+ "Telefono			VARCHAR(13) NOT NULL, "
				+ "Provincia		VARCHAR(40) NOT NULL, "
				+ "Comune			VARCHAR(40) NOT NULL, "
				+ "Via		 		VARCHAR(40) NOT NULL, "
				+ "Civico			VARCHAR(4) NOT NULL, "
				+ "Username			VARCHAR(30) NOT NULL"
				+ ");";
	}
	
	public static String inserisciPersona(Persona persona) {
		return "INSERT INTO Persona(CodiceFiscale,Nome,Cognome,Telefono,Provincia,Comune,Via,Civico,Username) "
				+ "VALUES ('"+ persona.getCodiceFiscale() + "','" 
				+ persona.getNome() + "','"
				+ persona.getCognome() + "','"
				+ "+39" + persona.getTelefono() + "','"
				+ persona.getProvincia()+ "','"
				+ persona.getComune() + "','"
				+ persona.getVia() + "','"
				+ persona.getCivico() + "','"
				+ persona.getUsername() + "')";
	}
	
	public static String ricercaPersona(String codiceFiscale) {
		return "SELECT COUNT(*) "
			      + "FROM Persona "
			      + "WHERE CodiceFiscale = '" + codiceFiscale + "';";
	}
	
	// metodi per tabella Medico
	public static String creaTabMedico() {
		return "CREATE TABLE IF NOT EXISTS Medico ("
				+ "Codice		  	VARCHAR(30) PRIMARY KEY, "
				+ "CodiceFiscale 	VARCHAR(16) NOT NULL, "
				+ "Nome		  		VARCHAR(30) NOT NULL, "
				+ "Cognome			VARCHAR(30) NOT NULL, "
				+ "Telefono			VARCHAR(13) NOT NULL, "
				+ "Provincia		VARCHAR(40) NOT NULL, "
				+ "Comune			VARCHAR(40) NOT NULL, "
				+ "Via		 		VARCHAR(40) NOT NULL, "
				+ "Civico			VARCHAR(4) NOT NULL, "
				+ "Username			VARCHAR(30) NOT NULL "
				+ ");";
	}
	
	public static String inserisciMedico(Medico medico) {
		return "INSERT INTO Medico(Codice,CodiceFiscale,Nome,Cognome,Telefono,Provincia,Comune,Via,Civico,Username) "
				+ "VALUES ('"
				+ medico.getCodice() + "','" 
				+ medico.getCodiceFiscale() + "','" 
				+ medico.getNome() + "','"
				+ medico.getCognome() + "','"
				+ "+39" + medico.getTelefono() + "','"
				+ medico.getProvincia()+ "','"
				+ medico.getComune() + "','"
				+ medico.getVia() + "','"
				+ medico.getCivico() + "','"
				+ medico.getUsername() + "')";
	}
	
	public static String ricercaMedico(String codiceMedico) {
		return "SELECT COUNT(*) "
			      + "FROM Medico "
			      + "WHERE Codice = '" + codiceMedico + "';";
	}
	
	
	// metodi per tabella Utente
	public static String creaTabUtente() {
		return "CREATE TABLE IF NOT EXISTS Utente ("
				+ "Username		VARCHAR(30) PRIMARY KEY, "
				+ "Password		VARCHAR(30) NOT NULL "
				+ ");";
	}
	
	public static String inserisciUtente(Utente utente) {
		return "INSERT INTO Utente(Username,Password) "
				+ "VALUES ('"
				+ utente.getUsername() + "','" 
				+ utente.getHashPassword() + "')";
	}
	
	public static String ricercaUtente(String username) {
		return "SELECT COUNT(*) "
			      + "FROM Utente "
			      + "WHERE Username = '" + username + "';";
	}
	
	
	// metodi per tabella Comuni
	public static String creaTabComuni() {
		return "CREATE TABLE IF NOT EXISTS Comuni ("
				+ "NomeComune		VARCHAR(50) PRIMARY KEY, "
				+ "Regione			VARCHAR(50) NOT NULL, "
				+ "Provincia		VARCHAR(50)	NOT NULL "
				+ ");";
	}
	
	// metodi per tabella MediciAutorizzati
	public static String creaTabMediciAutorizzati() {
		return "CREATE TABLE IF NOT EXISTS MediciAutorizzati ("
				+ "Codice 	VARCHAR(30) PRIMARY KEY"
				+ ");";
	}
	
	public static String inserisciMediciAutorizzati(String codice) {
		return"INSERT INTO MediciAutorizzati(Codice) "
				+ "VALUES ('"+ codice + "')";
	}
	
	public static String ricercaMediciAutorizzati(String codice) {
		return "SELECT COUNT(*) "
			      + "FROM MediciAutorizzati "
			      + "WHERE Codice = '" + codice + "';";
	}
	
	
}
