package Personnages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class VueInventaire extends JPanel {
	
	public void PaintComponent(Graphics g) {
	this.setPreferredSize(new Dimension(20,10));
	this.setBackground( new Color(0,0,0,25) );
	}
}
