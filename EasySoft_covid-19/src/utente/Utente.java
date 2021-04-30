package utente;
import java.sql.SQLException;

import Exception.EasySoftException;
import database.*;

public class Utente {
	private Persona persona;
	private Medico medico;
	private LabAnalisi lab_analisi;
	
	private String username = null;
	private String hashPassword= null;
	
	private boolean adminFlag = false;
	
	/**
	 * Costruttore parametrico.<br>
	 * Inizializza tutti i campi relativi all'utente.
	 * @param impiegato Impiegato relativo all'utente.
	 * @param username Username utente.
	 * @param hashPassword Hash password utente.
	 * @param adminFlag Flag che indica se l'utente è un amministratore o meno.
	 * @see Utility_Utente#hashPwd(String)
	 */
	public Utente(Persona persona, String username, String hashPassword, boolean adminFlag) {
		this.persona = persona;
		this.username = username;
		this.adminFlag = adminFlag;
		this.hashPassword = hashPassword;
	}
	
	public Utente(Medico persona, String username, String hashPassword, boolean adminFlag, Medico medico) {
		this.medico = medico;
		this.username = username;
		this.adminFlag = adminFlag;
		this.hashPassword = hashPassword;
	}
	
	public Utente(LabAnalisi lab_analisi, String username, String hashPassword, boolean adminFlag) {
		this.lab_analisi = lab_analisi;
		this.username = username;
		this.adminFlag = adminFlag;
		this.hashPassword = hashPassword;
	}

	public Persona getPersona() {
		return persona;
	}

	public Medico getMedico() {
		return medico;
	}

	public LabAnalisi getLab_analisi() {
		return lab_analisi;
	}
	
	public String getUsername() {
		return username;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public boolean isAdminFlag() {
		return adminFlag;
	}
	
	/**
	 * Aggiunge l'utente nella base dati.<br>
	 * Il metodo utilizza l'interfaccia {@link it.uniba.di.prog2.cs2021.gruppo31.database.LogIn_SignIn} del package
	 * {@link it.uniba.di.prog2.cs2021.gruppo31.database} per accedere al metodo 
	 * {@link it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB#addUtente(Utente)} e aggiungere l'utente al DB.
	 * @throws SQLException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		IMPIEGATO_ALREADY_EXISTS, USERNAME_ALREADY_EXISTS.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.LogIn_SignIn
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB#addUtente(Utente)
	 */
	public void addUtente() throws SQLException,EasySoftException {
		LogIn_SignIn login =(LogIn_SignIn) ProxyDB.getIstance();
		login.addUtente(this);
	}
	
}
