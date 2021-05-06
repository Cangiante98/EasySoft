package residenza;

import java.util.ArrayList;

import database.LogIn_SignIn;
import database.ProxyDB;

public class Regione {
	
	private String nomereg= null;
	private ArrayList <Provincia> ListaProvincia=null;
	
	public Regione() {
		super();
	}
	public String getNomereg() {
		return nomereg;
	}
	
	public void setNomereg(String nomereg) {
		this.nomereg = nomereg;
	}
	
	public ArrayList<Provincia> getListaProvincia() {
		return ListaProvincia;
	}
	
	public void setListaProvincia(ArrayList<Provincia> listaProvincia) {
		ListaProvincia = listaProvincia;
	}

	public Regione(String nomereg,ArrayList<Provincia> listaProvincia) {
		super();
		this.nomereg = nomereg;
		ListaProvincia = listaProvincia;
	}
	public Regione(String nomereg) {
		super();
		this.nomereg = nomereg;
	}
	@Override
	public String toString() {
		return "Regione [nomereg=" + nomereg + ", ListaComuni=" + ", ListaProvincia=" + ListaProvincia
				+ "]";
	}
	
	public void addRegione() {
		LogIn_SignIn login =ProxyDB.getIstance();
		login.addRegione(this);
	}
	
	
}
