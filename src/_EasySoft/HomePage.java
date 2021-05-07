package _EasySoft;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
import Exception.EasySoftException;
import database.TabellaComuni;

public class HomePage {

	public static void main(String[] args) throws SQLException, EasySoftException, IOException {
		ArrayList<String> listaProvince = new ArrayList<String>(); 
		listaProvince = TabellaComuni.caricaProvince();
		
		for(int i = 0; i < listaProvince.size(); i++) {
			System.out.println(listaProvince.get(i));
		}
	}

}
