package _EasySoft;

import java.sql.SQLException;

import javax.swing.JComboBox;

import Exception.EasySoftException;
import database.TabellaComuni;
import database.TabellaMedico;
import database.TabellaPersona;
import utente.UtilityUtente;

public class HomePage {

	public static void main(String[] args){
		String user = "nome utente";
		String pass= "password0";
		
		
		
		System.out.println(TabellaComuni.caricaComuni("Bari"));
		/*try {
			UtilityUtente.checkUtente(user,UtilityUtente.hashPwd(pass));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EasySoftException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
		 
}
