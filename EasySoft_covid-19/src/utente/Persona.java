package utente;

public class Persona{
	private String nome; 			//max 20 caratteri
	private String cognome;			//max 20 caratteri
	private String codiceFiscale;	//esattamente 16 caratteri
	private String telefono;		//esattamente 10 caratteri
	private boolean flag = false;
	
	//Costruttore
	public Persona(String nome, String cognome, String codiceFiscale, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.telefono = "39" + telefono;
		this.flag = true;
	}
	
	
	//Reimposta dati persona 	
	public void setPersona(String nome, String cognome, String codiceFiscale, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.telefono = "39" + telefono;
	}
	
	public void setNome(String nuovoNome) {
		this.nome = nuovoNome;
	}
	
	public void setCognome(String nuovoCognome) {
		this.nome = nuovoCognome;
	}
	
	public void setCodFiscale(String nuovoCodFiscale) {
		this.nome = nuovoCodFiscale;
	}
	
	public void setTelefono(String nuovoTelefono) {
		this.nome = nuovoTelefono;
	}
	
	
	
	//Ottieni dati persona
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	
	
}

