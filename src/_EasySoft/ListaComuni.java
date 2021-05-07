package _EasySoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ListaComuni {
	
	private ArrayList<Integer> cap = new ArrayList<Integer>();
	private ArrayList<String> regione = new ArrayList<String>();
	private ArrayList<String> provincia = new ArrayList<String>();
	private ArrayList<String> paese = new ArrayList<String>();
	
	
	public ListaComuni() {
		
		regione.add("Apruzzo");
		regione.add("Basilicata");
		regione.add("Calabria");
		regione.add("Campania");
		regione.add("Emilia-Romagna");
		regione.add("Friuli-Venezia Giulia");
		regione.add("Lazio");
		regione.add("Liguria");
		regione.add("Lombardia");
		regione.add("Marche");
		regione.add("Molise");
		regione.add("Piemonte");
		regione.add("Puglia");
		regione.add("Sardegna");
		regione.add("Sicilia");
		regione.add("Toscana");
		regione.add("Trentino-Alto Adige");
		regione.add("Umbria");
		regione.add("Valle D'aosta");
		regione.add("Veneto");
		
		System.out.println(regione);
			
		String file = "listacomuni\\listacomuni - Copia.csv";
		
		String line="";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line=br.readLine())!= null) {
				
				String[] riga = line.split(";");
				//System.out.println(riga[0]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//file.close();
		}
		
	}
}
