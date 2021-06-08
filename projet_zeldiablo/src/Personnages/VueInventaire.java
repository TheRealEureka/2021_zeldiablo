package Personnages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueInventaire extends JPanel {
	
	private Inventaire inv;
	
	public void PaintComponent(Graphics g) {
		this.setPreferredSize(new Dimension(20,10));
		this.setBackground( new Color(0,0,0,25));
		JLabel jl = new JLabel();
		jl.setText("inventaire");
		this.add(jl);
		JLabel obj1 = new JLabel();
		obj1.setIcon(new ImageIcon((this.inv.getTab(1).getBi())));
		JLabel obj2 = new JLabel();
		jl.setIcon(new ImageIcon((this.inv.getTab(2).getBi())));
		
	}
}
