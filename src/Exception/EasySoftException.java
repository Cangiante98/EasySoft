package Exception;

/**
 * Classe che si occupa di gestire le eccezioni custom.<br>
 * La classe AziendaException estende la classe Exception e
 * ne reimplementa alcuni metodi costruttori secondo le specifiche.
 * @author marco
 * @version 1.1
 */
public class EasySoftException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore aparamterico.<br>
	 * Si limita a richiamare il costruttore
	 * aparametrico della classe Exception.
	 * @see Exception#Exception()
	 */
	public EasySoftException() {
		super();
	}

	/**
	 * Costruttore parametrico.<br>
	 * Riceve come parametro un messaggio di errore
	 * e si occupa di invocare il costruttore della
	 * classe Exception che prende in input una stringa.
	 * @param message Messaggio di errore.
	 * @see Exception#Exception(String)
	 */
	public EasySoftException(String message) {
		super(message);
	}

	/**
	 * Costruttore parametrico.<br>
	 * Riceve come parametro un oggetto Throwable
	 * che indica la causa dell'eccezione, e si occupa
	 * di invocare il costruttore della classe Exception
	 * che prende in input un oggetto Thowable.
	 * @param cause Causa dell'eccezione.
	 * @see Exception#Exception(Throwable)
	 */
	public EasySoftException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Costruttore parametrico.<br>
	 * Riceve come parametri sia un oggetto Throwable
	 * sia un messaggio di errore, e si occupa
	 * di invocare il costruttore della classe Exception
	 * che prende in input i due parametri.
	 * @param message Messaggio di errore.
	 * @param cause Causa dell'eccezione.
	 * @see Exception#Exception(String, Throwable)
	 */
	public EasySoftException(String message, Throwable cause) {
		super(message,cause);
	}
}
