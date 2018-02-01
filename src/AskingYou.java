import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AskingYou extends JFrame implements ActionListener
	{
	static String pseudo;
	static String password;
	static JButton connect;
	public AskingYou(String parTitre)
		{
		super(parTitre);
		this.setSize(300, 175);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
		this.createPanel();
		}
	public void createPanel()
		{
		JPanel lePanel = new JPanel();
		GridLayout gl = new GridLayout(1, 4, 0, 0);
		lePanel.setLayout(gl);
		JLabel lePseudo = new JLabel("Identifiant: "); JTextField saisiePseudo = new JTextField(7);
		lePanel.add(lePseudo);
		lePanel.add(saisiePseudo);
		JLabel lePassword = new JLabel("Mot de passe: "); lePanel.add(lePassword);
		add(lePanel);
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		if(parEvent.getSource() == connect);
			InterfaceG fenetre = new InterfaceG("Base de données");
		}
	}
