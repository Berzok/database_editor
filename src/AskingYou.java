import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class AskingYou extends JFrame implements ActionListener
	{
	public JTextField saisiePseudo;
	public JTextField saisiePassword;
	public JButton connect;
	public static FenetreMere mommy;
	public static AskingYou me;
	public String chServeur;
	
	public boolean madere;
	
	private ButtonGroup boutonGroupe = new ButtonGroup();
	private JRadioButton chSetna = new JRadioButton("Setna");
	private JRadioButton chMadere = new JRadioButton("Madere");
	public AskingYou(String parTitre, FenetreMere parFenetre)
		{
		super(parTitre);
		chServeur = "madere";
		this.setSize(275, 130);
		this.setLocationRelativeTo(null);
		mommy = parFenetre;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.createPanel();
		this.setVisible(true);
		this.setResizable(false);
		}
	public void createPanel()
		{
		JPanel lePanel1 = new JPanel(); lePanel1.setLayout(new BoxLayout(lePanel1, BoxLayout.LINE_AXIS));
		JLabel lePseudo = new JLabel("     Identifiant:   "); lePanel1.add(lePseudo);
		lePanel1.add(Box.createHorizontalStrut(10));
		saisiePseudo = new JTextField("");
		lePanel1.add(saisiePseudo);
		lePanel1.add(Box.createHorizontalStrut(10));
		
		
		JPanel lePanel2 = new JPanel(); lePanel2.setLayout(new BoxLayout(lePanel2, BoxLayout.LINE_AXIS));
		JLabel lePassword = new JLabel("  Mot de passe:   "); lePanel2.add(lePassword);
		saisiePassword = new JTextField("");
		lePanel2.add(saisiePassword);
		lePanel2.add(Box.createHorizontalStrut(10));
		
		
		JPanel lePanel3 = new JPanel();
		chMadere.setSelected(true);
		
		chMadere.addActionListener(new StateListener());
		lePanel3.add(chMadere);
		boutonGroupe.add(chMadere);
		
		chSetna.addActionListener(new StateListener());
		lePanel3.add(chSetna); boutonGroupe.add(chSetna);
		lePanel3.add(Box.createHorizontalStrut(10));
		
		connect = new JButton("Connexion");
		connect.addActionListener(this);
		lePanel3.add(connect);
		
		
		JPanel lePanel4 = new JPanel(); lePanel4.setLayout(new BoxLayout(lePanel4, BoxLayout.PAGE_AXIS));
		lePanel4.add(Box.createVerticalStrut(10));
		lePanel4.add(lePanel1);
		lePanel4.add(Box.createVerticalStrut(3));
		lePanel4.add(lePanel2);
		lePanel4.add(lePanel3);
		lePanel4.add(Box.createVerticalStrut(10));
		add(lePanel4);
		
		}
	
	class StateListener implements ActionListener
		{
		public void actionPerformed(ActionEvent parEvent)
			{
			if(parEvent.getSource() == chSetna)
				{
				madere = false;
				chServeur = "setna";
				}
			else
				{
				madere = true;
				chServeur = "madere";
				}
			}
		}
	 
	
	public void actionPerformed(ActionEvent parEvent)
		{
		if(parEvent.getSource() == connect);
			try
				{
				mommy.createConnexion(mommy, saisiePseudo.getText(), saisiePassword.getText(), this, madere, chServeur);
				}
			catch (ClassNotFoundException e)
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			catch (SQLException e)
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		
		}
	}
