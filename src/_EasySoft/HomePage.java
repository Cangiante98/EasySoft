package _EasySoft;

import java.sql.SQLException;

import Exception.EasySoftException;
import utente.UtilityUtente;

public class HomePage {

	public static void main(String[] args){
		String user = "nome utente";
		String pass= "password0";
		try {
			UtilityUtente.checkUtente(user,UtilityUtente.hashPwd(pass));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EasySoftException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		 
}
