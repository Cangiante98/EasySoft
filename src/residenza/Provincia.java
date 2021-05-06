package residenza;

import java.util.ArrayList;

public class Provincia {
	
	private ArrayList <Comune> ListaComuni;
	private String nomeProvincia=null;
	
	
	public ArrayList<Comune> getProvincie() {
		return ListaComuni;
	}
	public void setProvincie(ArrayList<Comune> ListaComuni) {
		this.ListaComuni = ListaComuni;
	}
	public String getProvincia() {
		return nomeProvincia;
	}
	public void setProvincia(String provincia) {
		this.nomeProvincia = provincia;
	}
	
	public Provincia(ArrayList<Comune> ListaComuni, String provincia) {
		super();
		this.ListaComuni = ListaComuni;
		this.nomeProvincia = provincia;
	}
	
	public Provincia(String provincia) {
		super();
		this.nomeProvincia = provincia;
	}
	

}
