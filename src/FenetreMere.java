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
	
	public void createInterface(String parPseudo)
		{
		InterfaceG leContenu = new InterfaceG(this, chCo, chPseudo);
		}
	
	public void createConnexion (FenetreMere parFenetre, String parPseudo, String parPassword, AskingYou parYou, int parServeur) throws SQLException, ClassNotFoundException
		{
		chPseudo = parPseudo; chMotdepasse = parPassword;
		parYou.dispose();
		String url = null;
		if(parServeur == 1)
			{
			url = "jdbc:oracle:thin:@madere:1521:info";			
			}
		if(parServeur == 0)
			{
			url = "jdbc:oracle:thin:@setna:1521:info";
			}
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		chCo = DriverManager.getConnection(url, chPseudo, chMotdepasse);
		this.createInterface(chPseudo);
		}
	public void actualiser()
		{
		this.validate();
		this.repaint();
		}
	}
//Statement stmt = con.createStatement()