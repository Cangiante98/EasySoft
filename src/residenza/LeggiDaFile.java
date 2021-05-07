package residenza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeggiDaFile {
	private static Scanner inputStream = null;
	
	public static void apriFile(String nomeFile){
		try{
			inputStream = new Scanner(new File(nomeFile));
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public static void leggiFile(){
		int i = 0; 
		while(inputStream.hasNext()){
			String riga = inputStream.nextLine();
			String[] array = riga.split(";");
			if(i > 0) {
				TabellaComune.inserisciComunaInTabella(array[0], array[1], array[2]);
			}
			i++;
		}
	}
	
	public static void chiudiFile(){
		inputStream.close();
	}
}
