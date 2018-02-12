import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InterfaceG extends JPanel implements ActionListener
	{
	JTextField chSaisieRequete;
	String chRequete;
	JTextArea chResultatRequete;
	JButton chBouton;
	FenetreMere chMommy;
	public InterfaceG(FenetreMere parFenetre, String parPseudo)
		{
		chMommy = parFenetre;
		JPanel lePanel2 = new JPanel(); lePanel2.setLayout(new BoxLayout(lePanel2, BoxLayout.LINE_AXIS));
		JLabel leUser = new JLabel("Utilisateur: " + parPseudo); lePanel2.add(leUser);
		JPanel lePanel3 = new JPanel(); lePanel3.setLayout(new BoxLayout(lePanel3, BoxLayout.LINE_AXIS));
		chSaisieRequete = new JTextField(20); lePanel3.add(chSaisieRequete);
		chBouton = new JButton("Action !"); chBouton.addActionListener(this);
		lePanel3.add(chBouton);
		JPanel lePanel4 = new JPanel(); lePanel4.setLayout(new BoxLayout(lePanel4, BoxLayout.LINE_AXIS));
		chResultatRequete = new JTextArea(); chResultatRequete.setEditable(false);
		lePanel4.add(chResultatRequete);
		JPanel lePanel = new JPanel(); lePanel.setLayout(new BoxLayout(lePanel, BoxLayout.PAGE_AXIS));
		lePanel.add(lePanel2);
		lePanel.add(lePanel3);
		lePanel.add(lePanel4);
		this.setVisible(true);
		parFenetre.add(lePanel);
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		if(parEvent.getSource() == chBouton)
			{
			chRequete = chSaisieRequete.getText();
			Statement stmt;
			try
				{
				stmt = chMommy.chCo.createStatement();
				ResultSet resultat = stmt.executeQuery(chRequete);
				chResultatRequete.setText(chRequete);
				} 
			catch (SQLException e1)
				{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		chMommy.actualiser();
		}
		}
	}
