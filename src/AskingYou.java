import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class AskingYou extends JFrame implements ActionListener
	{
	public JTextField saisiePseudo;
	public JTextField saisiePassword;
	public static JButton connect;
	public static FenetreMere mommy;
	public static AskingYou me;
	public int chServeur;
	public AskingYou(String parTitre, FenetreMere parFenetre)
		{
		super(parTitre);
		this.setSize(275, 125);
		this.setLocationRelativeTo(null);
		mommy = parFenetre;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.createPanel();
		this.setVisible(true);
		}
	public void createPanel()
		{
		JPanel lePanel1 = new JPanel(); lePanel1.setLayout(new BoxLayout(lePanel1, BoxLayout.LINE_AXIS));
		JLabel lePseudo = new JLabel("     Identifiant:   "); lePanel1.add(lePseudo);
		saisiePseudo = new JTextField("");
		lePanel1.add(saisiePseudo);
		
		JPanel lePanel2 = new JPanel(); lePanel2.setLayout(new BoxLayout(lePanel2, BoxLayout.LINE_AXIS));
		JLabel lePassword = new JLabel("  Mot de passe:   "); lePanel2.add(lePassword);
		saisiePassword = new JTextField(""); lePanel2.add(saisiePassword);
		
		JPanel lePanel3 = new JPanel(); connect = new JButton("Connexion");
		connect.addActionListener(this);
		lePanel3.add(connect);
		
		JPanel lePanel4 = new JPanel(); lePanel4.setLayout(new BoxLayout(lePanel4, BoxLayout.PAGE_AXIS));
		lePanel4.add(lePanel1);
		lePanel4.add(lePanel2);
		lePanel4.add(lePanel3);
		add(lePanel4);
		
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		if(parEvent.getSource() == connect);
			try
				{
				mommy.createConnexion(mommy, saisiePseudo.getText(), saisiePassword.getText(), this, chServeur);
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
