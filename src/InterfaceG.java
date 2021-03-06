import javax.swing.*;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InterfaceG extends JPanel implements ActionListener
	{
	JTextArea chSaisieRequete;
	String chRequete;
	JTextArea chResultatRequete;
	JButton chBouton;
	FenetreMere chMommy;
	Connection chCo;
	
	public InterfaceG(FenetreMere parFenetre, Connection parCo, String parPseudo, String parServeur)
		{
		chMommy = parFenetre;
		chCo = parCo;
		
		JPanel lePanel2 = new JPanel(); lePanel2.setLayout(new BoxLayout(lePanel2, BoxLayout.LINE_AXIS));
		JLabel leUser = new JLabel("Utilisateur:  " + parPseudo); lePanel2.add(leUser);
		lePanel2.add(Box.createHorizontalStrut(64));
		JLabel leServeur = new JLabel("Serveur:  " + parServeur); lePanel2.add(leServeur);
		
		
		JPanel lePanel3 = new JPanel(); lePanel3.setLayout(new BoxLayout(lePanel3, BoxLayout.LINE_AXIS));
		chSaisieRequete = new JTextArea();
		lePanel3.add(Box.createHorizontalStrut(25));
		lePanel3.add(chSaisieRequete);
		lePanel3.add(Box.createVerticalStrut(34));
		lePanel3.add(Box.createHorizontalStrut(25));
		chBouton = new JButton("Action !"); chBouton.addActionListener(this);
		lePanel3.add(chBouton);
		lePanel3.add(Box.createHorizontalStrut(25));
		
		
		JPanel lePanel4 = new JPanel(); lePanel4.setLayout(new BoxLayout(lePanel4, BoxLayout.LINE_AXIS));
		chResultatRequete = new JTextArea(); chResultatRequete.setEditable(false);
		lePanel4.add(Box.createHorizontalStrut(13));
		lePanel4.add(Box.createVerticalStrut(19));
		lePanel4.add(chResultatRequete);
		lePanel4.add(Box.createHorizontalStrut(13));
		lePanel4.add(Box.createVerticalStrut(13));
		
		
		JPanel lePanel = new JPanel(); lePanel.setLayout(new BoxLayout(lePanel, BoxLayout.PAGE_AXIS));
		lePanel.add(Box.createVerticalStrut(8));
		lePanel.add(lePanel2);
		lePanel.add(Box.createHorizontalStrut(15));
		lePanel.add(Box.createVerticalStrut(15));
		lePanel.add(lePanel3);
		lePanel.add(Box.createVerticalStrut(9));
		lePanel.add(lePanel4);
		lePanel.add(Box.createVerticalStrut(11));
		this.setVisible(true);
		parFenetre.add(lePanel);
		this.actualiser();
		chMommy.actualiser();
		}
	public Insets getInsets()		//Insets == marge
		{
		Insets marge = new Insets(35, 15, 15, 15);
		return marge;		//Haut, gauche, bas, droite
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		if(parEvent.getSource() == chBouton)
			{
			chRequete = chSaisieRequete.getText();
			Statement stmt;
			try
				{
				stmt = chCo.createStatement();
				ResultSet resultat = stmt.executeQuery(chRequete);
				ResultSetMetaData result = resultat.getMetaData();
				int nbreColonnes = result.getColumnCount();
				while (resultat.next ())
		    		{
					for(int i=1; i<=nbreColonnes; i++)
						{
						chResultatRequete.setLineWrap(true);
						chResultatRequete.append(resultat.getString(i) + "");
						}
					chResultatRequete.append("" + '\n');
		    		}
				} 
			catch (SQLException e1)
				{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		this.actualiser();
			}
		}
	public void actualiser()
		{
		this.revalidate();
		this.repaint();
		}
	}
