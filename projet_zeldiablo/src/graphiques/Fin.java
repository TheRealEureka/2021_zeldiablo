package graphiques;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Fin extends JPanel implements ActionListener{
	private JButton b1,b2;
	private int status = 0;
	public Fin()
	{
		this.setPreferredSize(new Dimension(100,100));
		b1=new JButton("Restart");
		b2=new JButton("Quit");
		b1.addActionListener(this);
		b2.addActionListener(this);

		this.add(b1);
		this.add(b2);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton src = (JButton) (arg0.getSource());
		if(src==b1)
		{
			status=1;
		}
		if(src==b2)
		{
			status=2;
		}
		
	}
	public int getStatus()
	{
		return status;
	}
}
