package utente;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import database.*;
import Exception.*;
import _EasySoft.Token;
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
	
	
	/**
	 * Controlla la correttezza del formato di username e password.<p>
	 * Vincoli username:
	 * <ul>
	 * <li>Lunghezza minima = 5</li>
	 * <li>Lunghezza massima = 20</li>
	 * <li>Pu� contenere solo lettere, cifre e i seguenti caratteri: {._-}</li>
	 * <li>Deve iniziare con una lettera</li>
	 * </ul>
	 * <p>
	 * Password:
	 * <ul>
	 * <li>Lunghezza minima = 8</li>
	 * <li>Lunghezza massima = 50</li>
	 * <li>Può contenere solo lettere, cifre e i seguenti caratteri: {.,;:_+/*^=?!()\\[\\]{}@%#$-}</li>
	 * </ul>
	 * @param username Username da validare.
	 * @param password Password da validare.
	 * @return Possibili valori di ritorno:<br>
	 * 	0: Credenziali valide<br>
	 * 	1: Lunghezza username non valida<br>
	 * 	2: Formato username non valido<br>
	 *  3: Lunghezza password non valida<br>
	 *  4: Formato password non valido<br>
	 *  @see Pattern#matches(String, CharSequence)
	 */
	public static int checkCorrettezzaCredenziali(String username, String password) {
		if(username == null || username.length() > 20 || username.length() < 5)	return 1;
		if(Pattern.matches("[a-zA-z][a-zA-Z0-9._-]*", username) == false)	return 2;
		if(password == null || password.length() > 50 || password.length() < 8)	return 3;
		if(Pattern.matches("[a-zA-Z0-9.,;:_+/*^=?!()\\[\\]{}@%#$-]+", password) == false)	return 4;
		return 0;
	}
	/**
	 * Controlla la correttezza sintattica dei campi dell'impiegato.<br>
	 * Vengono utilizzati metodi locali per il controllo dei singoli campi.
	 * @param impiegato Impiegato da validare.
	 * @return Possibili valori di ritorno:<br>
	 *  0: Parametri corretti<br>
	 * 	1: Nome non corretto<br>
	 * 	2: Cognome non corretto<br>
	 * 	3: Data di nascita non corretta<br>
	 * 	4: Data di entrata non corretta<br> 
	 * 	5: Stipendio mensile non corretto<br>
	 *  6: Numero vendite massime all'anno non corretto<br>
	 *  @see #checkNome(String)
	 *  @see #checkDataEntrata(Date)
	 *  @see #checkDataNascita(Date)
	 */
	public static int checkPersona(Persona persona) {
		if(checkNome(persona.getNome()) == false)	return 1;
		if(checkNome(persona.getCognome()) == false)	return 2;
		if(checkCodiceFiscale(persona.getCodiceFiscale()) == false)	return 3;
		if(checkVia(persona.getVia()) == false) return 4;
		if(checkCivico(persona.getCivico()) == false) return 5;
		if(checknum(persona.getTelefono())== false) return 6;
		return 0; //Valido
	}
	/**
	 * Controllo correttezza sintattica nome o cognome.<br>
	 * Il nome e il cognome devono contenere solo lettere, e non possono avere lunghezza >30 caratteri.
	 * @param nome Nome impiegato.
	 * @return
	 * 		TRUE - Nome corretto.<br>
	 * 		FALSE - Nome non corretto.
	 * @see Character#isLetter(char)
	 */
	private static boolean checkNome(String nome) {
		if(nome == null)	return false;
		int leng = nome.length();
		if(leng > 30) return false;
		for(int i=0; i<leng; i++) {
			if(Character.isLetter(nome.charAt(i)) == false)
					return false;
		}
		return true;
	}
	/**
	 * Controllo correttezza semantica data di nascita.<br>
	 * L'impiegato deve essere maggiorenne per poter lavorare in azienda. 
	 * @param dataNascita Data di nascita.
	 * @return
	 * 		TRUE - Data corretta.<br>
	 * 		FALSE - Data non corretta.
	 * @see Calendar#add(int, int)
	 * @see Calendar#getTime()
	 * @see Date#compareTo(Date)
	 */
	private static boolean checkCodiceFiscale(String codicefiscale) {
		if(codicefiscale == null)	return false;
		int leng = codicefiscale.length();
		if(leng != 16) return false;
		
		for(int i =0; i==5; i++) {
			if (Character.isLetter(codicefiscale.charAt(i) )== false) return false;
		}
		for(int i=5; i==7;i++) {
			if (Character.isLetter(codicefiscale.charAt(i) )== true) return false;
		}
		if (Character.isLetter(codicefiscale.charAt(8) )== false) return false;
		for(int i =9; i==10; i++) {
			if (Character.isLetter(codicefiscale.charAt(i) )== true) return false;
		}
		if (Character.isLetter(codicefiscale.charAt(11) )== false) return false;
		for(int i =12; i==14; i++) {
			if (Character.isLetter(codicefiscale.charAt(i) )== true) return false;
		}
		if (Character.isLetter(codicefiscale.charAt(15) )== false) return false;
		return true;
		
	}
	
	/**
	 * Controllo correttezza semantica data di nascita.<br>
	 * L'impiegato deve essere maggiorenne per poter lavorare in azienda. 
	 * @param dataNascita Data di nascita.
	 * @return
	 * 		TRUE - Data corretta.<br>
	 * 		FALSE - Data non corretta.
	 * @see Calendar#add(int, int)
	 * @see Calendar#getTime()
	 * @see Date#compareTo(Date)
	 */
	private static boolean checkDataNascita(Date dataNascita) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR,-18); //Possono lavorare solo maggiorenni
		Date temp = c.getTime();
		if(dataNascita.compareTo(temp) > 0)	return false;
		return true;
	}
	
	private static boolean checkVia(String via)  {
		if(via == null)	return false;
		int leng = via.length();
		if(leng > 30) return false;
		for(int i=0; i<leng; i++) {
			if(Character.isLetter(via.charAt(i)) == false)
					return false;
		}
		return true;
	}
	
	private static boolean checkCivico(String civico) {
		if(civico == null)  return false;
		int leng = civico.length();
		if(leng > 6)		return false;
		for (int i =0; i<leng; i++) {
			if(Pattern.matches("[.,;:_+/*^=?!()\\[\\]{}@%#$-]+", civico) == true) {
				i=leng;
				return false;
			}
		}
		return true;
	}
	 private static boolean checknum(String telefono) {
		 if(telefono == null) return false;
		 int leng=telefono.length();
		 if(leng < 9 || leng>10) return false;
		 for(int i=0;i<leng;i++) {
			 if(Pattern.matches("[.,;:_+/*^=?!()\\[\\]{}@%#$-]+", telefono) == true || Character.isLetter(telefono.charAt(i)) == true) {
				 i=leng;
				 return false;
			 }
		 }
		return true;
	 }
	/**
	 * Genera l'hash della password fornita in input.<br>
	 * L'hash generato è sempre un numero positivo: <code> (password.hashCode() &amp; 0xfffffff) </code>
	 * @param password Password da cui generare il codice hash.
	 * @return Hash della password fornita in input.
	 */
	public static String hashPwd(String password) {
		if(password == null)	return null;
		int hash = (password.hashCode() & 0xfffffff);
		return Integer.toString(hash);
	}
}
