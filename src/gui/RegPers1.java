package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class RegPers1 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password1;
	private JTextField password2;

	public RegPers1() {
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
		
		// SETTO LE TENDINE INPUT
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(250, 100, 190, 30);
		contentPane.add(username);

		password1 = new JTextField();
		password1.setColumns(10);
		password1.setBounds(250, 165, 190, 30);
		contentPane.add(password1);
		
		password2 = new JTextField();
		password2.setColumns(10);
		password2.setBounds(250, 230, 190, 30);
		contentPane.add(password2);
		
		
		setVisible(true);
	}

}
