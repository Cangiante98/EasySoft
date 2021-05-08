package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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

import database.TabellaComuni;

public class LogIn_Window extends JFrame{
	private static String listaProvince[];// conterrà le province caricate dal db
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtUsername;
	JPasswordField passwordField;
	
	public static void main(String[] args) {
		listaProvince = TabellaComuni.caricaProvince();
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LogIn_Window();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public LogIn_Window() {
		
		setSize(600,300);
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
		
		//CREAZIONE DEl pulsante con azione all'interno del pannello
		JButton button1= new JButton();
		button1.setText("amministratore");
		button1.setBounds(0,270, 115, 20);
		button1.setOpaque(true);
		button1.setBackground(Color.white);
		button1.setBorderPainted(false);
		//button1.addActionListener(e -> System.out.println("Vaffancùllo"));
		button1.setFont(new Font("Dialog", Font.BOLD, 10));
		
		contentPane.add(button1);
				
		//pannello di sinistra
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 228, 400);
		
		contentPane.add(lblNewLabel);
		
		
		txtUsername = new JTextField();
		txtUsername.setBounds(291, 100, 250, 30);
		contentPane.add(txtUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(291, 160, 250, 30);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Registrati!");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TipoReg(listaProvince);
			}
		});

		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(518, 275, 75, 15);
		//btnNewButton.setFont(font);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Accedi");
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				//login();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBounds(456, 202, 85, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("X");
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setSize(new Dimension(10, 10));
		btnNewButton_2.setBackground(new Color(255, 51, 0));
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_2.setBounds(558, 0, 42, 23);
		contentPane.add(btnNewButton_2);
		
		
		JLabel lblSeiUnNuovo = new JLabel("Sei un nuovo utente?");
		//lblSeiUnNuovo.setFont(font);
		lblSeiUnNuovo.setBounds(400, 275, 133, 15);
		contentPane.add(lblSeiUnNuovo);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLogin.setBounds(373, 29, 62, 24);
		contentPane.add(lblLogin);
		
		
		JLabel lblUsername = new JLabel("Password");
		//lblUsername.setFont(font);
		lblUsername.setBounds(291, 140, 70, 15);
		contentPane.add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Username");
		//lblUsername_1.setFont(font);
		lblUsername_1.setBounds(291, 80, 72, 15);
		contentPane.add(lblUsername_1);
		
		
		
		ImageIcon user = new ImageIcon(LogIn_Window.class.getResource("/user.png"));
		Image userScaled = user.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		user = new ImageIcon(userScaled);
		
		//pannello di destra
		JLabel label = new JLabel("");
		label.setIcon(user);
		label.setBounds(432, 24, 31, 29);
		contentPane.add(label);
		
		
		setVisible(true);
	}
	
}
