package Labyrinthe;

import java.awt.image.BufferedImage;

import Personnages.Personnage;

public abstract class Objet {

	private String nom; 
	private BufferedImage bi;
	private int x,y;

	
	public Objet (String n) {
		this.nom=n;
	}
	
	public abstract void porteurPrends(Personnage p);
	public abstract void porteurPose();
	public abstract String toString();
	public abstract BufferedImage getBi();

	public String getNom() {
		return this.nom;
	}
	
}
