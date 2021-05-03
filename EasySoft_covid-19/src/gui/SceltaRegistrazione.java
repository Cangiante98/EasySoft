package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class SceltaRegistrazione extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField txtUsername;
	JPasswordField passwordField;
	
	public SceltaRegistrazione() {
		
		setSize(600,300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		//bordo
		JPanel panelbordo= new JPanel();
		panelbordo.setBackground(Color.black);
		panelbordo.setBackground(Color.white);
		panelbordo.setBounds(getBounds());
		contentPane.add(panelbordo);

		
		// PULSANTE INDIETRO
				JButton btn_indietro = new JButton("Annulla");
				btn_indietro.setOpaque(true);
				btn_indietro.setForeground(Color.WHITE);
				btn_indietro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				btn_indietro.setBackground(new Color(178, 34, 34));
				btn_indietro.setBounds(450, 260, 65, 25);
				contentPane.add(btn_indietro);

				btn_indietro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new FinestraPrincipale();
					}
				});
				// PULSANTE X
				JButton btn_x = new JButton("X");
				btn_x.setOpaque(true);
				btn_x.setSize(new Dimension(10, 10));
				btn_x.setFont(new Font("Dialog", Font.BOLD, 10));
				btn_x.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				btn_x.setBackground(new Color(255, 51, 0));
				btn_x.setBounds(560, 0, 42, 23);
				btn_x.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				contentPane.add(btn_x);
				
				// labanalisi
				ImageIcon lab = new ImageIcon(SceltaRegistrazione.class.getResource("/labanalisi.png"));
				JButton button1 = new JButton(lab);
				button1.setBounds(310, 100, 100, 100);
				button1.setBackground(getForeground());
				button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				button1.setContentAreaFilled(false);
				button1.setBorder(null);
				contentPane.add(button1);
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				// persona
				ImageIcon pers = new ImageIcon(SceltaRegistrazione.class.getResource("/persona.png"));
				JButton button2 = new JButton(pers);
				button2.setBounds(180, 100, 100, 100);
				button2.setBackground(getForeground());
				button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				button2.setContentAreaFilled(false);
				button2.setBorder(null);
				contentPane.add(button2);
				button2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				// medico
				ImageIcon med = new ImageIcon(SceltaRegistrazione.class.getResource("/dottore.png"));
				JButton button3 = new JButton(med);
				button3.setBounds(50, 100, 100, 100);
				button3.setBackground(getForeground());
				button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				button3.setContentAreaFilled(false);
				button3.setBorder(null);
				contentPane.add(button3);
				button3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				
				JLabel easysoft = new JLabel("registrati come");
				easysoft.setHorizontalAlignment(SwingConstants.CENTER);
				easysoft.setBackground(new Color(0, 0, 139));
				easysoft.setFont(new Font("Dialog", Font.BOLD, 18));
				easysoft.setForeground(Color.BLACK);
				easysoft.setBounds(160, 45, 162, 29);
				easysoft.setHorizontalTextPosition(SwingConstants.CENTER);
				easysoft.setVerticalTextPosition(JLabel.TOP);
				contentPane.add(easysoft);
				
				JLabel medico = new JLabel("medico");
				medico.setHorizontalAlignment(SwingConstants.CENTER);
				medico.setBackground(new Color(0, 0, 139));
				medico.setFont(new Font("Dialog", Font.ITALIC, 12));
				medico.setForeground(Color.BLACK);
				medico.setBounds(20, 200, 162, 29);
				medico.setHorizontalTextPosition(SwingConstants.CENTER);
				medico.setVerticalTextPosition(JLabel.TOP);
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
				labanalisi.setForeground(Color.BLACK);
				labanalisi.setBounds(280, 200, 162, 29);
				labanalisi.setHorizontalTextPosition(SwingConstants.CENTER);
				labanalisi.setVerticalTextPosition(JLabel.TOP);
				contentPane.add(labanalisi);
		setVisible(true);
		
		
	}

}
