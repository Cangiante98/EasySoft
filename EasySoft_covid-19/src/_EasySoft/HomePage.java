package _EasySoft;

import java.sql.SQLException;

import Exception.EasySoftException;
import database.ProxyDB;
import utente.Persona;
import utente.Utente;

public class HomePage {

	public static void main(String[] args) throws SQLException, EasySoftException {
		// TODO Auto-generated method stub
		Persona persona= new Persona("marco", "Sguera", "DDGMRC99I70W441T", "4358679486");
		Utente utente= new Utente(persona,"username","password",true);
		
		utente.addUtente();
		
		
	}

}
