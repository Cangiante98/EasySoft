package utente;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class Persona{
	private String nome; 			//max 20 caratteri
	private String cognome;			//max 20 caratteri
	private String codiceFiscale;	//esattamente 16 caratteri
	private String telefono;		//esattamente 10 caratteri
	private String provincia;
	private String comune;
	private String civico;
	private String via;
	private String username;

	public Persona(String nome, String cognome, String codiceFiscale, String telefono, String provincia, String comune,
			String civico, String via, String username) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.telefono = telefono;
		this.provincia = provincia;
		this.comune = comune;
		this.civico = civico;
		this.via = via;
		this.username = username;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getCodiceFiscale() {
		return codiceFiscale;
	}



	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getComune() {
		return comune;
	}



	public void setComune(String comune) {
		this.comune = comune;
	}



	public String getCivico() {
		return civico;
	}



	public void setCivico(String civico) {
		this.civico = civico;
	}



	public String getVia() {
		return via;
	}



	public void setVia(String via) {
		this.via = via;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", telefono="
				+ telefono + ", provincia=" + provincia + ", comune=" + comune + ", via=" + via + ", civico=" + civico
				+ ", username=" + username + "]";
	}
	
	
	
}