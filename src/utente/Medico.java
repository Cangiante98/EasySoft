package utente;

public class Medico extends Persona{
	
	String codice;
	
	public Medico(String codice, String nome, String cognome, String codiceFiscale, String telefono, String provincia, String comune,
			String civico, String via, String username) {
		super(nome, cognome, codiceFiscale, telefono, provincia, comune, civico, via, username);
		this.codice = codice;
	
	}
	
	
	public String getCodice() {
		return this.codice;
	}
}
