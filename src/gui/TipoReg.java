package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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

public class TipoReg extends JFrame {
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtUsername;
	JPasswordField passwordField;
	
	public TipoReg(String listaProvince[]) {
				
		setSize(600,300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(200,200,200));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 12, 450, 220);
		panel.setPreferredSize(new Dimension(500, 150));
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		
		
		// PULSANTE INDIETRO
		JButton btn_indietro = new JButton("Annulla");
		btn_indietro.setOpaque(true);
		btn_indietro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_indietro.setBackground(new Color(255, 51, 0));
		btn_indietro.setBounds(525, 260, 65, 25);
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
		btn_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btn_x);
		
		// labanalisi
		ImageIcon lab = new ImageIcon(TipoReg.class.getResource("/labanalisi.png"));
		JButton button1 = new JButton(lab);
		button1.setBounds(310, 87, 100, 100);
		button1.setBackground(getForeground());
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button1.setContentAreaFilled(false);
		button1.setBorder(null);
		panel.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegLab1(listaProvince);
			}
		});
		// persona
		ImageIcon pers = new ImageIcon(TipoReg.class.getResource("/persona.png"));
		JButton button2 = new JButton(pers);
		button2.setBounds(180, 100, 100, 100);
		button2.setBackground(getForeground());
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button2.setContentAreaFilled(false);
		button2.setBorder(null);
		contentPane.add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegPers1(listaProvince);
				/******+***
				 * 
				 * MODIFICATO da marco
				 * 
				 */
			}
		});
		// medico
		ImageIcon med = new ImageIcon(TipoReg.class.getResource("/dottore.png"));
		JButton button3 = new JButton(med);
		button3.setBounds(50, 100, 100, 100);
		button3.setBackground(getForeground());
		button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button3.setContentAreaFilled(false);
		button3.setBorder(null);
		contentPane.add(button3);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegMed1(listaProvince);
			}
		});
		
		JLabel easysoft = new JLabel("registrati come");
		easysoft.setHorizontalAlignment(SwingConstants.CENTER);
		easysoft.setBackground(new Color(0, 0, 139));
		easysoft.setFont(new Font("Dialog", Font.BOLD, 18));
		easysoft.setForeground(Color.BLACK);
		easysoft.setBounds(145, 45, 162, 29);
		easysoft.setHorizontalTextPosition(SwingConstants.CENTER);
		easysoft.setVerticalTextPosition(JLabel.TOP);
		contentPane.add(easysoft);
		
		JLabel medico = new JLabel("medico");
		medico.setHorizontalAlignment(SwingConstants.CENTER);
		medico.setBackground(new Color(0, 0, 139));
		medico.setFont(new Font("Dialog", Font.ITALIC, 12));
		medico.setForeground(Color.BLACK);
		medico.setBounds(20, 200, 162, 29);
		medico.setHorizontalTextPosition(SwingConstants.CENTER);				medico.setVerticalTextPosition(JLabel.TOP);
		contentPane.add(medico);
		
		JLabel personafisica = new JLabel("persona fisica");
		personafisica.setHorizontalAlignment(SwingConstants.CENTER);
		personafisica.setBackground(new Color(0, 0, 139));
		personafisica.setFont(new Font("Dialog", Font.ITALIC, 12));
		personafisica.setForeground(Color.BLACK);
		personafisica.setBounds(150, 200, 162, 29);
		personafisica.setHorizontalTextPosition(SwingConstants.CENTER);
		personafisica.setVerticalTextPosition(JLabel.TOP);
		contentPane.add(personafisica);
		
		JLabel labanalisi = new JLabel("laboratorio analisi");
		labanalisi.setHorizontalAlignment(SwingConstants.CENTER);
		labanalisi.setBackground(new Color(0, 0, 139));
		labanalisi.setFont(new Font("Dialog", Font.ITALIC, 12));
		labanalisi.setBounds(290, 200, 162, 29);
		labanalisi.setHorizontalTextPosition(SwingConstants.CENTER);
		labanalisi.setVerticalTextPosition(JLabel.TOP);
		contentPane.add(labanalisi);
		
		setVisible(true);
		contentPane.add(panel);
	}

}
