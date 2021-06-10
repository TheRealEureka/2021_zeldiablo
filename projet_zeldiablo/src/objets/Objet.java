package objets;

import java.awt.image.BufferedImage;

import Personnages.Personnage;
import labyrinthe.Labyrinthe;

public abstract class Objet {

	private BufferedImage bi;
	private int x,y;
	private Labyrinthe lab;

	
	public Objet (Labyrinthe n) {
		this.lab=n;
	}
	
	public abstract void porteurPrends(Personnage p);
	public abstract void porteurPose();
	public abstract String toString();
	public  BufferedImage getBi() {
		return this.bi;
	}
	public  void setBi(BufferedImage b) {
		this.bi = b;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	/**
	 * @return the labyrinthe
	 */
	public Labyrinthe getLab() {
		return lab;
	}

	/**
	 * @param labyrinthe the labyrinthe to set
	 */
	public void setLabyrinthe(Labyrinthe labyrinthe) {
		this.lab = labyrinthe;
	}
}
