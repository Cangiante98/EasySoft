package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
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

import database.TabellaComuni;

@SuppressWarnings("rawtypes")
public class PersReg extends JFrame{

	
	private static final long serialVersionUID = 1L;

	private JComboBox selezione0;
	private JComboBox selezione1;
	private JTextField tenda0;
	private JTextField tenda1;
	private JTextField tenda2;
	private JTextField tenda3;
	private JTextField tenda4;	
	JPanel contentPane;
	JTextField txtUsername;
	JPasswordField passwordField;
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param listaProvince
	 * @throws SQLException
	 */
	public PersReg(String listaProvince[]) throws SQLException {
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
		panelloscrollabile.setPreferredSize(new Dimension(500,600));
		panelloscrollabile.setBorder(null);
		panelloscrollabile.setBackground(Color.WHITE);
		scrollPane.setViewportView(panelloscrollabile);
		
		// SETTO LE TENDINE INPUT
		tenda0 = new JTextField();
		tenda0.setColumns(10);
		tenda0.setBounds(20, 100, 190, 30);
		panelloscrollabile.add(tenda0);

		tenda1 = new JTextField();
		tenda1.setColumns(10);
		tenda1.setBounds(20, 165, 190, 30);
		panelloscrollabile.add(tenda1);
		
		tenda2 = new JTextField();
		tenda2.setColumns(10);
		tenda2.setBounds(20, 230, 190, 30);
		panelloscrollabile.add(tenda2);
		
		tenda3 = new JTextField();
		tenda3.setColumns(10);
		tenda3.setBounds(20, 295, 190, 30);
		panelloscrollabile.add(tenda3);
		
		//inserisce la lista dell province nel menù a tendina
		selezione0 = new JComboBox(listaProvince);
		
	
		selezione0.setBounds(20, 360, 190, 30);
		panelloscrollabile.add(selezione0);
		
		
		
		selezione1 = new JComboBox();
		selezione1.setBounds(20, 425, 190, 30);
		panelloscrollabile.add(selezione1);
		
		
		
		tenda4 = new JTextField();
		tenda4.setColumns(10);
		tenda4.setBounds(20, 490, 190, 30);
		panelloscrollabile.add(tenda4);
		
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
		JLabel data = new JLabel("data di nascita");
		data.setHorizontalAlignment(SwingConstants.LEFT);
		data.setBackground(new Color(0, 0, 139));
		data.setFont(new Font("Dialog", Font.ITALIC, 15));
		data.setForeground(Color.BLACK);
		data.setBounds(20, 203, 162, 29);
		data.setHorizontalTextPosition(SwingConstants.LEFT);
		data.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(data);
		
		//Testo
		JLabel cf = new JLabel("codice fiscale");
		cf.setHorizontalAlignment(SwingConstants.LEFT);
		cf.setBackground(new Color(0, 0, 139));
		cf.setFont(new Font("Dialog", Font.ITALIC, 15));
		cf.setForeground(Color.BLACK);
		cf.setBounds(20, 268, 162, 29);
		cf.setHorizontalTextPosition(SwingConstants.LEFT);
		cf.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(cf);
		
		//Testo
		JLabel provincia = new JLabel("provincia di residenza");
		provincia.setHorizontalAlignment(SwingConstants.LEFT);
		provincia.setBackground(new Color(0, 0, 139));
		provincia.setFont(new Font("Dialog", Font.ITALIC, 15));
		provincia.setForeground(Color.BLACK);
		provincia.setBounds(20, 333, 162, 29);
		provincia.setHorizontalTextPosition(SwingConstants.LEFT);
		provincia.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(provincia);
		
		//Testo
		JLabel comune = new JLabel("comune di residenza");
		comune.setHorizontalAlignment(SwingConstants.LEFT);
		comune.setBackground(new Color(0, 0, 139));
		comune.setFont(new Font("Dialog", Font.ITALIC, 15));
		comune.setForeground(Color.BLACK);
		comune.setBounds(20, 401, 162, 29);
		comune.setHorizontalTextPosition(SwingConstants.LEFT);
		comune.setVerticalTextPosition(JLabel.TOP);
		panelloscrollabile.add(comune);
		
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
				//check(home);
			}
		});
		btnAggiungi.setForeground(Color.WHITE);
		btnAggiungi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiungi.setBackground(new Color(0, 153, 51));
		btnAggiungi.setBounds(18, 550, 450, 25);
		panelloscrollabile.add(btnAggiungi);
		
		setVisible(true);
	}

}

