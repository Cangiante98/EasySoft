package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import Exception.EasySoftException;
import Exception.ErroriDB;
import database.TabellaUtente;
import utente.UtilityUtente;

public class RegPers1 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public RegPers1(String listaProvince[]) {
		setSize(600, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(200,200,200));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon img = new ImageIcon(LogIn_Window.class.getResource("/covid-19.png"));
		Image imgScaled = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		img = new ImageIcon(imgScaled);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(35, 100, 150, 150);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAziendaEdile = new JLabel("EasySoft");
		lblAziendaEdile.setHorizontalAlignment(SwingConstants.CENTER);
		lblAziendaEdile.setBackground(new Color(0, 0, 139));
		lblAziendaEdile.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAziendaEdile.setForeground(Color.BLACK);
		lblAziendaEdile.setBounds(28, 35, 162, 29);
		lblAziendaEdile.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAziendaEdile.setVerticalTextPosition(JLabel.TOP);
		contentPane.add(lblAziendaEdile);
		
		//pannello di sinistra
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 228, 460);
								
		contentPane.add(lblNewLabel);
		
		
		
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
		
		// pulsante info
		img = new ImageIcon(LogIn_Window.class.getResource("/info.png"));	
		JButton button = new JButton(img);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setContentAreaFilled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String warning = "Vincoli username:\n";
				warning += "- Lunghezza minima = 5\n";
				warning += "- Lunghezza massima = 20\n";
				warning += "- Puo' contenere solo lettere, cifre e i seguenti caratteri: { ._- }\n";
				warning += "- Deve iniziare con una lettera\n";
				warning += "Vincoli password:\n";
				warning += "- Lunghezza minima = 8\n";
				warning += "- Lunghezza massima = 50\n";
				warning += "- Puo' contenere solo lettere, cifre e i seguenti caratteri: { .,;:_+/*^=?!()[]{}@%#$- }\n";
				JOptionPane.showMessageDialog(null, warning);
			}
		});
		button.setBorder(null);
		button.setBounds(369, 10, 32, 32);
		contentPane.add(button);
		
		JLabel lblregistrazione = new JLabel("info utente");
		lblregistrazione.setFont(new Font("Dialog", Font.BOLD, 18));
		lblregistrazione.setBounds(260, 18, 155, 15);
		contentPane.add(lblregistrazione);
		
		JLabel lblUsername = new JLabel("Inserisci username:");
		lblUsername.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblUsername.setBounds(251, 82, 155, 15);
		contentPane.add(lblUsername);
		
		JLabel lblpass = new JLabel("Inserisci password:");
		lblpass.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblpass.setBounds(251, 147, 155, 15);
		contentPane.add(lblpass);
		
		JLabel lblpass2 = new JLabel("Reinserisci password:");
		lblpass2.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblpass2.setBounds(251, 212, 155, 15);
		contentPane.add(lblpass2);
		
		
		// SETTO LE TENDINE INPUT
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(250, 100, 190, 30);
		contentPane.add(txtUsername);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(250, 165, 190, 30);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		passwordField_1.setBounds(250, 230, 190, 30);
		contentPane.add(passwordField_1);
		
		//pulsante avanti e annulla
		JButton btnNewButton_1 = new JButton("Avanti");
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				checkreg(listaProvince);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(46, 139, 87));
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBounds(503, 263, 85, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setOpaque(true);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TipoReg(listaProvince);
			}
		});
		btnAnnulla.setForeground(new Color(255, 255, 255));		
		btnAnnulla.setBackground(new Color(178, 34, 34));
		btnAnnulla.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAnnulla.setBounds(406, 263, 85, 25);
		contentPane.add(btnAnnulla);
		
		setVisible(true);
	}
	
	public void checkreg(String listaProvince[]) {
		
		String user = txtUsername.getText();
		char[] charPass = passwordField.getPassword();
		String pass = new String(charPass);
		char[] charPass_1 = passwordField_1.getPassword();
		String pass_1 = new String(charPass_1);
		
		
		if(user.length() == 0 || pass.length() == 0 || pass_1.length() == 0)
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Alcuni campi sono vuoti!");
			return;
		}
		if(pass.equals(pass_1));
		else
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Le password non coincidono!");
			return;
		}
		
		int res = UtilityUtente.checkCorrettezzaCredenziali(user,pass);
		if(res == 0);
		else {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Vincoli non rispettati!\nPremere su Info per controllare i vincoli.");
			return;
		}
		
		/*boolean trovato = TabellaUtente.cercaUtenteInTabella(user);
		
		if(trovato == true)
			System.out.println("Trovato");
		else
			System.out.println("Non trovato");
		*/
		try {
			System.out.println("ENTRATO!!!!!");
			UtilityUtente.checkUtente(user,UtilityUtente.hashPwd(pass));
			System.out.println("USCITO!!!!!");
			boolean trovato = TabellaUtente.cercaUtenteInTabella(user);
			
			if(trovato == true)
				System.out.println("Trovato");
			else
				System.out.println("Non trovato");
			
		} catch (EasySoftException e) {
			if(e.getMessage().equals(ErroriDB.USERNAME_NOT_FOUND)) { //Username valido
				dispose();
				setCursor(Cursor.getDefaultCursor());
				try {
					new RegPers2(user,pass,listaProvince);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return;
			}
		} catch (Exception e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
			return;
		}
		
		setCursor(Cursor.getDefaultCursor());
		JOptionPane.showMessageDialog(null, "ERROR: Username già in uso!");
		
		return;
	}

}
