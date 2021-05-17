package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.xml.crypto.Data;

import Exception.EasySoftException;
import database.TabellaComuni;
import database.TabellaPersona;
import database.TabellaUtente;
import utente.*;

@SuppressWarnings("rawtypes")
public class RegLab2 extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	private JComboBox provincia;
	private JComboBox comune;
	private JTextField nome;
	private JTextField cognome;
	private JTextField cf;
	private JTextField numero;	
	private JTextField via;
	private JTextField civico;	
	private JCheckBox chckbxSeiUnAmministratore;
	
	JPanel contentPane;
	JTextField txtUsername;
	JPasswordField passwordField;
	
	@SuppressWarnings("unchecked")
	public RegLab2(String user, String pass , String[] listaProvince) throws SQLException {
		
		this.username = user;
		this.password = pass;
		
		setSize(600, 460);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		//WINDOWS OPERATIVA
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(200,212,212));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		// PULSANTE ANNULLA
		JButton btn_indietro = new JButton("Annulla");
		btn_indietro.setOpaque(true);
		btn_indietro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_indietro.setBackground(new Color(255, 51, 0));
		btn_indietro.setBounds(522, 410, 65, 25);
		contentPane.add(btn_indietro);
		btn_indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LogIn_Window();
				}
			});
				
		// PULSANTE X
		JButton btn_x = new JButton("X");
		btn_x.setOpaque(true);
		btn_x.setSize(new Dimension(10, 10));
		btn_x.setFont(new Font("Dialog", Font.BOLD, 10));
		btn_x.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_x.setBackground(new Color(255, 51, 0));
		btn_x.setBounds(558, 0, 42, 23);
		contentPane.add(btn_x);
		btn_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});		
		
		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 12, 500, 424);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		contentPane.add(scrollPane);
		
		JPanel panelloscrollabile = new JPanel();
		panelloscrollabile.setLayout(null);
		panelloscrollabile.setPreferredSize(new Dimension(500,750));
		panelloscrollabile.setBorder(null);
		panelloscrollabile.setBackground(Color.WHITE);
		scrollPane.setViewportView(panelloscrollabile);
		
		// SETTO LE TENDINE INPUT
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(20, 100, 190, 30);
		panelloscrollabile.add(nome);

		cognome = new JTextField();
		cognome.setColumns(10);
		cognome.setBounds(20, 165, 190, 30);
		panelloscrollabile.add(cognome);
		
		cf = new JTextField();
		cf.setColumns(10);
		cf.setBounds(20, 230, 190, 30);
		panelloscrollabile.add(cf);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(20, 490, 190, 30);
		panelloscrollabile.add(numero);
		
		via= new JTextField();
		via.setColumns(10);
		via.setBounds(20, 425, 190, 30);
		panelloscrollabile.add(via);
		
		civico = new JTextField();
		civico.setColumns(10);
		civico.setBounds(215, 425, 30, 30);
		panelloscrollabile.add(civico);
		
		
		
		// SETTAGGIO LISTE PROVINCIE E COMUNI		
		provincia = new JComboBox(listaProvince);
		provincia.setBounds(20, 295, 190, 30);
		panelloscrollabile.add(provincia);
		
	
		comune = new JComboBox(new String[]{"Nessuna selezione"});
		comune.setBounds(20, 360, 190, 30);
		panelloscrollabile.add(comune);
		
		// Ascoltatore che si attiva quando l'utente sceglie una provincia.
		// Prende la provincia scelta e carica tutti i comuni per quella provincia e li inserisce nella tendina comune.
		provincia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String provinciaScelta = provincia.getSelectedItem().toString(); // provincia scelta nella tendina province
            	String listaComuni[] = TabellaComuni.caricaComuni(provinciaScelta); // carica la lista di comuni della provincia scelta
            	comune.setModel(new DefaultComboBoxModel<String>(listaComuni)); // inserisce i comuni nella tendina comuni
            	}
            });
	
		
		//Testo
		JLabel nome = new JLabel("nome");
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setBackground(new Color(0, 0, 139));
		nome.setFont(new Font("Dialog", Font.ITALIC, 15));
		nome.setForeground(Color.BLACK);
		nome.setBounds(20, 73, 162, 29);
		nome.setHorizontalTextPosition(SwingConstants.LEFT);
		nome.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(nome);
		
		//Testo
		JLabel cognome = new JLabel("cognome");
		cognome.setHorizontalAlignment(SwingConstants.LEFT);
		cognome.setBackground(new Color(0, 0, 139));
		cognome.setFont(new Font("Dialog", Font.ITALIC, 15));
		cognome.setForeground(Color.BLACK);
		cognome.setBounds(20, 138, 162, 29);
		cognome.setHorizontalTextPosition(SwingConstants.LEFT);
		cognome.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(cognome);
		
		//Testo
		JLabel cf = new JLabel("codice fiscale");
		cf.setHorizontalAlignment(SwingConstants.LEFT);
		cf.setBackground(new Color(0, 0, 139));
		cf.setFont(new Font("Dialog", Font.ITALIC, 15));
		cf.setForeground(Color.BLACK);
		cf.setBounds(20, 203, 162, 29);
		cf.setHorizontalTextPosition(SwingConstants.LEFT);
		cf.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(cf);
		
		//Testo
		JLabel provincia = new JLabel("provincia di residenza");
		provincia.setHorizontalAlignment(SwingConstants.LEFT);
		provincia.setBackground(new Color(0, 0, 139));
		provincia.setFont(new Font("Dialog", Font.ITALIC, 15));
		provincia.setForeground(Color.BLACK);
		provincia.setBounds(20, 268, 162, 29);
		provincia.setHorizontalTextPosition(SwingConstants.LEFT);
		provincia.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(provincia);
		
		//Testo
		JLabel comune = new JLabel("comune di residenza");
		comune.setHorizontalAlignment(SwingConstants.LEFT);
		comune.setBackground(new Color(0, 0, 139));
		comune.setFont(new Font("Dialog", Font.ITALIC, 15));
		comune.setForeground(Color.BLACK);
		comune.setBounds(20, 336, 162, 29);
		comune.setHorizontalTextPosition(SwingConstants.LEFT);
		comune.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(comune);
		

		//Testo
		JLabel via = new JLabel("via di residenza");
		via.setHorizontalAlignment(SwingConstants.LEFT);
		via.setBackground(new Color(0, 0, 139));
		via.setFont(new Font("Dialog", Font.ITALIC, 15));
		via.setForeground(Color.BLACK);
		via.setBounds(20, 401, 162, 29);
		via.setHorizontalTextPosition(SwingConstants.LEFT);
		via.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(via);
		
		//Testo
		JLabel civico = new JLabel("civico");
		civico.setHorizontalAlignment(SwingConstants.LEFT);
		civico.setBackground(new Color(0, 0, 139));
		civico.setFont(new Font("Dialog", Font.ITALIC, 15));
		civico.setForeground(Color.BLACK);
		civico.setBounds(215, 401, 162, 29);
		civico.setHorizontalTextPosition(SwingConstants.LEFT);
		civico.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(civico);
		
		//Testo
		JLabel tel = new JLabel("numero di cellulare");
		tel.setHorizontalAlignment(SwingConstants.LEFT);
		tel.setBackground(new Color(0, 0, 139));
		tel.setFont(new Font("Dialog", Font.ITALIC, 15));
		tel.setForeground(Color.BLACK);
		tel.setBounds(20, 463, 162, 29);
		tel.setHorizontalTextPosition(SwingConstants.LEFT);
		tel.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(tel);
		
		
		//REGISTRAZIONE
		JButton btnAggiungi = new JButton("registrati");
		btnAggiungi.setOpaque(true);
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				try {
					checkRegistrati(user,pass,listaProvince);
				} catch (EasySoftException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAggiungi.setForeground(Color.WHITE);
		btnAggiungi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiungi.setBackground(new Color(0, 153, 51));
		btnAggiungi.setBounds(18, 625, 450, 25);
		panelloscrollabile.add(btnAggiungi);
		
		setVisible(true);
	}
	
	@SuppressWarnings("unused")
	public void checkRegistrati(String user, String pass , String[] listaProvince) throws EasySoftException, SQLException {
		String tmpNome = nome.getText();
		String tmpCognome = cognome.getText();
		String tmpcf = cf.getText();
		String tmpnum = numero.getText();
		String tmpcomune= comune.getSelectedItem().toString();
		String tmpprovincia= provincia.getSelectedItem().toString();
		String tmpvia= via.getText();
		String tmpcivico= civico.getText();
		
		if(tmpNome.length() == 0 || tmpCognome.length() == 0 || tmpcf.length() == 0
				|| tmpnum.length() == 0 || tmpprovincia.length() == 0 || tmpcomune.length() == 0 || tmpcivico.length() ==0|| tmpvia.length()==0)
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Alcuni campi sono vuoti!");
			return;
		}
		
		if(tmpNome.length() > 20)
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Nome non valido!");
			return;
		}
		if(tmpCognome.length() > 20)
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Cognome non valido!");
			return;
		}
		Persona persona = new Persona(tmpNome,tmpCognome,tmpcf,tmpnum,tmpprovincia,tmpcomune,tmpcivico,tmpvia,user);
		int res = UtilityUtente.checkPersona(persona);
		
		switch(res) {
			case 0: //Valido
				break;
			case 1:
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR: Nome non valido!");
				return;
			case 2:
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR: Cognome non valido!");
				return;
			case 3:
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR:  Codice Fiscale non valido!");
				return;
			case 4:
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR: Via non valida");
				return;
			case 5:
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR:civico non valido");
				return;
			case 6:
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR:numero non valido");
				return;
		}
		
		//crea utente della persoa fisica
		Utente utente = new Utente(persona,username,UtilityUtente.hashPwd(password));
		
		//inserisce l'utente (username e password ) nella taebella Utente
		int risulInserUtente = TabellaUtente.inserisciUtenteInTabella(utente);
		
		// controlla il corretto inserimento dell'utente nella tabella
		if(risulInserUtente == 1)
			System.out.println("Utente inserito correttamente nella tabella 'Utente'");
		else
			System.out.println("Errore inserimento utente in tabella 'Utente'");
	
		//inserisce la persona nella taebella Persona
		int risultInserPersona = TabellaPersona.inserisciPersonaInTabella(persona);

		String messRisultatoInserimento; // messaggio che verrà visualizzato nell'interfaccia
		// controlla il corretto inserimento della persona nella tabella
		if(risultInserPersona == 1)
			messRisultatoInserimento = "Registrazione avvenuta con successo!";
		else
			messRisultatoInserimento = "Ci scusiamo si è verificato un errore!Riprova";
	
		
		setCursor(Cursor.getDefaultCursor());
		JOptionPane.showInternalMessageDialog(null, messRisultatoInserimento, "perfect", JOptionPane.PLAIN_MESSAGE);
		dispose();
		new LogIn_Window();
	}
	
	// Valida una data in formato String.
	@SuppressWarnings("unused")
	private int dateCheck(String data) {
		int lista_giorni[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		if(data == null)	return 1;
		if(data.length() != 10)	return 1;
		if(data.charAt(2) != '/' || data.charAt(5) != '/')	return 1;
		for(int i=0;i<data.length();i++)
		{
			if(i==2 || i==5)	continue;
			if(data.charAt(i) >= '0' && data.charAt(i) <= '9');
			else
				return 1;
		}
		
		try {
			int giorno = Integer.parseInt(data.substring(0,2));
			int mese = Integer.parseInt(data.substring(3,5));
			int anno = Integer.parseInt(data.substring(6,10));
				if(mese >= 0 && mese <= 12);
			else	return 1;
			
			if(giorno >= 1 && giorno <= lista_giorni[mese-1]);
			else	return 1;
			
			int corrente = Calendar.getInstance().get(Calendar.YEAR);
			if(anno >= 1900 && anno <= corrente);
			else	return 1;
		}
		catch (NumberFormatException e) {
			return 1;
		}
		
		return 0; //Valida
	}
}