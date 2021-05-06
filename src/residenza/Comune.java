package residenza;

import java.util.ArrayList;

import database.LogIn_SignIn;
import database.ProxyDB;

public class Comune {
	
	private String nomeComune=null;
	
	
	
	
	public String getNomeComune() {
		return nomeComune;
	}

	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}
	
	public Comune() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comune(String nomeComune) {
		super();
		this.nomeComune = nomeComune;
	}

	public void addComune() {
		LogIn_SignIn login =ProxyDB.getIstance();
		login.addComune(this);
	}
	
	

}
