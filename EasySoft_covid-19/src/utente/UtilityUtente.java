package utente;

import java.sql.SQLException;
import java.text.ParseException;

import database.*;
import Exception.*;
public class UtilityUtente {

	/**
	 * Metodo che si occupa di effettuare il login dell'utente al sistema.<br>
	 * Se username e password ricevuti in input sono registrati sulla base dati,
	 * il metodo imposta il token in modo tale che l'utente possa effettuare il login
	 * attraverso la classe {@link it.uniba.di.prog2.cs2021.gruppo31.HomePage}.
	 * @param username Username dell'utente.
	 * @param hashPassword Hash della password dell'utente.
	 * @throws SQLException
	 * @throws AziendaException Possibili eccezioni:<br>
	 * 		USERNAME_NOT_FOUND, INCORRECT_PASSWORD.
	 * @see it.uniba.di.prog2.cs2021.gruppo31.Token#setHashPassword(String)
	 * @see it.uniba.di.prog2.cs2021.gruppo31.database.LogIn_SignIn#checkUtente(String, String)
	 */
	public static void checkUtente(String username, String hashPassword) throws SQLException,EasySoftException {
		LogIn_SignIn login = (LogIn_SignIn) ProxyDB.getIstance();
		login.checkUtente(username,hashPassword);
		//Token.getIstance().setHashPassword(hashPassword);
	}
}
