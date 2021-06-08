package Labyrinthe;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Personnages.Personnage;

public class Amulette extends Objet {

	private int x;
	private int y;
	private Personnage porteur;
	private String nom;
	private BufferedImage bi;
	private Labyrinthe labyrinthe;

	/**
	 * @return the labyrinthe
	 */
	public Labyrinthe getLab() {
		return labyrinthe;
	}

	/**
	 * @param labyrinthe the labyrinthe to set
	 */
	public void setLabyrinthe(Labyrinthe labyrinthe) {
		this.labyrinthe = labyrinthe;
	}

	public Amulette(int xc, int yc, Labyrinthe labi, String n) {

		super (n);
		
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
		this.labyrinthe = labi;
		File imgLoc = new File("src/images/totem.png");
		try {
			   bi = ImageIO.read(imgLoc);
			} catch (IOException ex) {
			   System.out.println("aya");
			}
	 
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
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
	public BufferedImage getBi()
	{
		return this.bi;
		
	}

	public String toString() {
		return "Amulette";
	}

}
