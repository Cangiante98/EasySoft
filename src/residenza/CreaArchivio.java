package residenza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CreaArchivio {
	private ArrayList<Integer> cap = new ArrayList<Integer>();
	private ArrayList<String> provincia = new ArrayList<String>();
	private ArrayList<String> paese = new ArrayList<String>();

	public CreaArchivio() {
		String file = "listacomuni\\listacomuni.csv";

		Regione regione = new Regione("prova");
		regione.addRegione();

		/*Regione basilicata = new Regione();
		basilicata.setNomereg("Basilicata");
		Regione calabria = new Regione();
		calabria.setNomereg("Calabria");
		Regione campania = new Regione();
		campania.setNomereg("Campania");
		Regione emilia = new Regione();
		emilia.setNomereg("Emilia-Romagna");
		Regione friuli = new Regione();
		friuli.setNomereg("Friuli-Venezia Giulia");
		Regione lazio = new Regione();
		lazio.setNomereg("Lazio");
		Regione liguria = new Regione();
		liguria.setNomereg("Liguria");
		Regione lombardia = new Regione();
		lombardia.setNomereg("Lombardia");
		Regione marche = new Regione();
		marche.setNomereg("Marche");
		Regione molise = new Regione();
		molise.setNomereg("Molise");
		Regione piemonte = new Regione();
		piemonte.setNomereg("Piemonte");
		Regione puglia = new Regione();
		puglia.setNomereg("Puglia");
		Regione sardegna = new Regione();
		sardegna.setNomereg("Sardegna");
		Regione sicilia = new Regione();
		sicilia.setNomereg("Sicilia");
		Regione toscana = new Regione();
		toscana.setNomereg("Toscana");
		Regione trentino = new Regione();
		trentino.setNomereg("Trentino-Alto Adige/S�dtirol");
		Regione umbria = new Regione();
		umbria.setNomereg("Umbria");
		Regione valle = new Regione();
		valle.setNomereg("Valle d'Aosta/Vall�e d'Aoste");
		Regione veneto = new Regione();
		veneto.setNomereg("Veneto");*/
		
		
		/*String line = "";
		int i = -1;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				i = i + 1;
				String[] riga = line.split(";");

				// System.out.println(riga [1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// file.close();
		}
		*/

	}

}
