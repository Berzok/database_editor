import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.sql.*;

public class FenetreMere extends JFrame
	{
	static String chPseudo;
	static String chMotdepasse;
	static String chServeur = "madere";
	Connection chCo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	ResultSet resultat = chStmt.executeQuery("");
	public FenetreMere()
		{
		super("Outil d'�dition de bases de donn�es");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		}
	public static void main (String[] args) throws SQLException, ClassNotFoundException
		{
		FenetreMere laFenetre = new FenetreMere();
		AskingYou whoAreYou = new AskingYou("Connexion...", laFenetre);
		}
	
	public void createInterface(String parPseudo, String parServeur)
		{
		InterfaceG leContenu = new InterfaceG(this, chCo, chPseudo, chServeur);
		}
	
	public void createConnexion (FenetreMere parFenetre, String parPseudo, String parPassword, AskingYou parYou, boolean parMadere, String parServeur) throws SQLException, ClassNotFoundException
		{
		chPseudo = parPseudo; chMotdepasse = parPassword; chServeur = parServeur;
		parYou.dispose();
		String url = null;
		if(parMadere)
			{
			url = "jdbc:oracle:thin:@madere:1521:info";			
			}
		else
			{
			url = "jdbc:oracle:thin:@setna:1521:info";
			}
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		chCo = DriverManager.getConnection(url, chPseudo, chMotdepasse);
		this.createInterface(chPseudo, chServeur);
		}
	public void actualiser()
		{
		this.validate();
		this.repaint();
		}
	}
//Statement stmt = con.createStatement()