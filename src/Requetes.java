/*
 * Exemple JDBC - Affichage des nomps des employés depuis la table EMP
 * Utilise le driver java pur JDBC THIN.  
 */
import java.sql.*;
import java.io.*;

public class Requetes
	{
	InputStreamReader istream = new InputStreamReader(System.in) ;
	BufferedReader bufRead = new BufferedReader(istream) ;
	String chR;
	static Connection chCo; 
	public Requetes(Connection parCo) throws SQLException, ClassNotFoundException
		{
		chCo = parCo;
		try
			{
			chR = bufRead.readLine();
			}
		catch (IOException err)
			{
			System.out.println("Error reading line");
			}
		this.effectuerReq(chCo, chR);
		}
	public void effectuerReq(Connection parCo, String parRequete) throws SQLException, ClassNotFoundException
		{
		Statement stmt = parCo.createStatement();
		ResultSet resultat = stmt.executeQuery(chR);
//		ResultSetMetaData result = resultat.getMetaData();
//		int nbreColonnes = result.getColumnCount();
//	    while (resultat.next ())
//	    	{
//	    	for(int i=1; i<=nbreColonnes; i++)
//	    		{
//	    		System.out.print(resultat.getString(i)+ "");
//	    		}
//	    	System.out.println("");
//	    	}
		}
	}
