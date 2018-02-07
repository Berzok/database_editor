import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class FenetreMere extends JFrame implements ActionListener
	{
	static String chPseudo;
	static String chMotdepasse;
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
	
	public void createConnexion (String parPseudo, String parPassword, AskingYou parYou) throws SQLException, ClassNotFoundException
		{
		chPseudo = parPseudo; chMotdepasse = parPassword;
		parYou.dispose();
		String url = "jdbc:oracle:thin:@madere:1521:info";
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection chCo = DriverManager.getConnection(url, chPseudo, chMotdepasse);
		}
	
	public void actionPerformed(ActionEvent parEvent)
		{
		
		}
	}
//Statement stmt = con.createStatement()