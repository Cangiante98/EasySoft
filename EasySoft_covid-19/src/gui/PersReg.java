package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class PersReg extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JPanel contentPane;
	JTextField txtUsername;
	JPasswordField passwordField;
	
	public PersReg() {
		setSize(600, 450);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		//WINDOWS OPERATIVA
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(200,212,212));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//pannello di lavoro utente
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 12, 575, 425);
		panel.setPreferredSize(new Dimension(575, 500));
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		// PULSANTE ANNULLA
		JButton btn_indietro = new JButton("Annulla");
		btn_indietro.setOpaque(true);
		btn_indietro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_indietro.setBackground(new Color(255, 51, 0));
		btn_indietro.setBounds(520, 410, 65, 25);
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
		
		textField = new JComboBox();
		textField.setBounds(20, 35, 190, 30);
		panel.add(textField);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 100, 190, 30);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(20, 165, 190, 30);
		panel.add(textField_2);
		
		
		contentPane.add(panel);
		setVisible(true);
	}

}
