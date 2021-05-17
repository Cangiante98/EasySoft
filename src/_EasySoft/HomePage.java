package _EasySoft;

import database.TabellaComuni;
import database.TabellaMediciAutorizzati;

public class HomePage {

	public static void main(String[] args){
		String user = "nome utente";
		String pass= "password0";
		
		TabellaMediciAutorizzati.inserisciMedicoAutorizzatoInTabella("ac4a64so");
		TabellaMediciAutorizzati.inserisciMedicoAutorizzatoInTabella("iuyt64so");
		TabellaMediciAutorizzati.inserisciMedicoAutorizzatoInTabella("ac‡Ëouso");
		TabellaMediciAutorizzati.inserisciMedicoAutorizzatoInTabella("ac4aeewq2");
		
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
