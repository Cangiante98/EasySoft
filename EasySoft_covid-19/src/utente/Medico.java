package utente;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Medico{
	private String nome;
	private String cognome;
	private String email;
	private Date dataNascita;
	
	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

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
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = "Nome: " + nome + "\nCognome: " + cognome + "\nData Nascita: " + formatter.format(dataNascita);
		return s;
	}
	
}

