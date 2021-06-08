package Labyrinthe;

import java.awt.image.BufferedImage;

import Personnages.Personnage;

public class Amulette extends Objet {

	private int x;
	private int y;
	private Personnage porteur;
	private String nom; 
	private BufferedImage bi;

	public Amulette(int xc, int yc, Labyrinthe labi, BufferedImage b, String n) {

		super (n,b);
		if (this.x > labi.getHauteur()) {
			this.x = 10;
		} else {
			this.x = xc;
		}
		if (this.y > labi.getLargeur()) {
			this.y = 10;
		} else {
			this.y = yc;
		}
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void porteurPrends(Personnage p) {
		if (p.getPosX() == this.x && p.getPosY() == this.y) {
			this.porteur = p;
			p.prendreAmulette(this);
		}
	}

	public void porteurPose() {
		if (this.porteur != null) {
			this.porteur = null;
		}
	}
	
	public String toString() {
		return "Amulette";
	}

}
