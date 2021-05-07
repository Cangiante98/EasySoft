package utente;

public class Persona{
	private String nome; 			//max 20 caratteri
	private String cognome;			//max 20 caratteri
	private String codiceFiscale;	//esattamente 16 caratteri
	private String telefono;		//esattamente 10 caratteri
	private String regione;
	private String provincia;
	private String comune;
	private String via;
	private String civico;
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
	
	
	
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	public void setRegione(String regione) {
		this.regione = regione;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public void setComune(String comune) {
		this.comune = comune;
	}


	public void setCivico(String civico) {
		this.civico = civico;
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


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public String getRegione() {
		return regione;
	}


	public String getProvincia() {
		return provincia;
	}


	public String getComune() {
		return comune;
	}


	public String getCivico() {
		return civico;
	}
	
	
	
}

