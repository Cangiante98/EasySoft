package utente;

public class Persona{
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String telefono;
	
	//Costruttori
	public Persona(){
		this.nome = "NESSUN NOME";
		this.cognome = "NESSUN COGNOME";
		this.codiceFiscale = "0000000000000000";
		this.telefono = "+39" + "0000000000";
	}
	
	public Persona(String nomeIniziale, String cognomeIniziale, String codiceFiscaleIniziale, String telefonoIniziale) {
		this.nome = nomeIniziale;
		this.cognome = cognomeIniziale;
		this.codiceFiscale = codiceFiscaleIniziale;
		this.telefono = "+39" + telefonoIniziale;
	}
	
	
	//Reimposta dati persona 	
	public void setPersona(String nome, String cognome, String codiceFiscale, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.telefono = "+39" + telefono;
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

