import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceG extends JFrame implements ActionListener
	{
	static String[] user;
	public InterfaceG(String parTitre)
		{
		super(parTitre);
		String[] user = new String[2];
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.actualiser();
		}
	public void askingYou(String[] parUser)
		{
		
		}
	public void actualiser()
		{
		this.revalidate();
		}
	public void actionPerformed(ActionEvent parEvent)
		{
		
		}
	}
