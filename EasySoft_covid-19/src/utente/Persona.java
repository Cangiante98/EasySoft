package utente;

public class Persona {
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String telefono;
	
	public Persona(){
		this.nome = "NESSUN NOME";
		this.cognome = "NESSUN COGNOME";
		this.codiceFiscale = "0000000000";
		this.telefono = "0000000000";
	}
	
	public Persona(String nomeIniziale, String cognomeIniziale, String codiceFiscaleIniziale, String telefonoIniziale) {
		this.nome = nomeIniziale;
		this.cognome = cognomeIniziale;
		this.codiceFiscale = codiceFiscaleIniziale;
		this.telefono = telefonoIniziale;
	}
	
	public void setPersona(String nome, String cognome, String codiceFiscale, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.telefono = telefono;
	}
	
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

