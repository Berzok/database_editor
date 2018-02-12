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
		super("Outil d'édition de bases de données");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		}
	public static void main (String[] args) throws SQLException, ClassNotFoundException
		{
		FenetreMere laFenetre = new FenetreMere();
//		chCo = DriverManager.getConnection(url, "USER", "PASSWORD");
		AskingYou whoAreYou = new AskingYou("Connexion...", laFenetre);
		}
	
	public static void createInterface(FenetreMere parFenetre, String parPseudo)
		{
		InterfaceG leContenu = new InterfaceG(parFenetre, parPseudo);
		}
	
	public void createConnexion (FenetreMere parFenetre, String parPseudo, String parPassword, AskingYou parYou) throws SQLException, ClassNotFoundException
		{
		chPseudo = parPseudo; chMotdepasse = parPassword;
		parYou.dispose();
		String url = "jdbc:oracle:thin:@madere:1521:info";
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection chCo = DriverManager.getConnection(url, chPseudo, chMotdepasse);
		createInterface(parFenetre, chPseudo);
		this.revalidate();
		}
	public void actualiser()
		{
		this.revalidate();
		}
	}
//Statement stmt = con.createStatement()