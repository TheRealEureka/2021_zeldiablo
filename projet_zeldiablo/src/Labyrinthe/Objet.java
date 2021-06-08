package Labyrinthe;

import java.awt.image.BufferedImage;

import Personnages.Personnage;

public abstract class Objet {

	private String nom; 
	private BufferedImage bi;
	private int x;
	private int y;
	
	public Objet (String n, BufferedImage b) {
		this.nom=n;
		this.bi=b;
	}
	
	public abstract void porteurPrends(Personnage p);
	public abstract void porteurPose();
	public abstract String toString();
	
	public String getNom() {
		return this.nom;
	}
	
	public BufferedImage getBi() {
		return this.bi;
	}
}
