package utente;

public class Azienda{
	private String partitaIva;     	//max 11 caratteri
	private String nome;			//max 20 caratteri
	private String telefono;		//max 10 caratteri
	private String email;   		//max 30 caratteri
	
	// costruttore
	public Azienda(String partitaIva, String nome, String telefono, String email) {
		this.partitaIva = partitaIva;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
	}
	
	//reimposta laboratorio
	public void setDatoreLavoro(String partitaIva, String nome, String telefono, String email) {
		this.partitaIva = partitaIva;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
	}
	
	public void setPartitaIva(String nuovaPartitaIva) {
		this.partitaIva = nuovaPartitaIva;
	}
	
	public void setNome(String nuovoNome) {
		this.nome = nuovoNome;
	}
	
	public void setTelefono(String nuovoTelefono) {
		this.telefono = nuovoTelefono;
	}
	
	public void setNuovaEmail(String nuovaEmail) {
		this.email = nuovaEmail;
	}

	
	//ottieni dati laboratorio
	public String getPartitaIva() {
		return this.partitaIva;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	
	public String getEmail() {
		return this.email;
	}
}
