package utente;

public class Medico{
	private String nome;
	private String cognome;
	private String email;
	
	//Costruttori
	public Medico(){
		this.nome = "NESSUN NOME";
		this.cognome = "NESSUN COGNOME";
		this.email = "NESSUN EMAIL";
	}
	
	public Medico(String nomeIniziale, String cognomeIniziale, String emailIniziale) {
		this.nome = nomeIniziale;
		this.cognome = cognomeIniziale;
		this.email = emailIniziale;
		
	}
	
	
	//Reimposta dati medico 	
	public void setMedico(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
	public void setNome(String nuovoNome) {
		this.nome = nuovoNome;
	}
	
	public void setCognome(String nuovoCognome) {
		this.nome = nuovoCognome;
	}
	
	public void setEmail(String nuovaEmail) {
		this.email = nuovaEmail;
	}
	
	
	//Ottieni dati medico
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
}

