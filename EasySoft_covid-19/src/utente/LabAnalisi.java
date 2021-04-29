package utente;

public class LabAnalisi {
	private String codice=null;
	private String hashPassword=null;
	
	public LabAnalisi(String codice,String pass) {
		this.codice=codice;
		this.hashPassword=pass;	
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	
}
