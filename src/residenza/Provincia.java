package residenza;

import java.util.ArrayList;

public class Provincia {
	
	private String nome = null;
	private ArrayList <Comune> ListaComuni;
	
	// costruttori
	public Provincia(String nome, ArrayList<Comune> ListaComuni) {
		super();
		this.nome = nome;
		this.ListaComuni = ListaComuni;
	}
	
	public Provincia(String nome) {
		super();
		this.nome = nome;
	}
	
	
	public ArrayList<Comune> getProvincie() {
		return ListaComuni;
	}
	public void setProvincie(ArrayList<Comune> ListaComuni) {
		this.ListaComuni = ListaComuni;
	}
	public String getNome() {
		return nome;
	}
	
	
	public void setProvincia(String nome) {
		this.nome = nome;
	}
	
	
	

}
