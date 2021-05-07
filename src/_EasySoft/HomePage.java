package _EasySoft;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
import Exception.EasySoftException;
import database.ProxyDB;
import residenza.Comune;
import residenza.CreaArchivio;
import residenza.Provincia;
import residenza.Regione;
import utente.Persona;
import utente.Utente;

public class HomePage {

	public static void main(String[] args) throws SQLException, EasySoftException, IOException {
		
		
		new CreaArchivio();
	}

}
