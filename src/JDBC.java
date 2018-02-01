import java.sql.*;

public class JDBC
	{
	static Connection chCo;
	Statement chStmt;
//	ResultSet resultat = chStmt.executeQuery("");
	public static void main (String[] args) throws SQLException, ClassNotFoundException
		{
		String url = "jdbc:oracle:thin:@madere:1521:info";
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		chCo = DriverManager.getConnection(url, "USER", "PASSWORD");
		AskingYou whoAreYou = new AskingYou("Connexion...");
		
		}
	}
//Statement stmt = con.createStatement()