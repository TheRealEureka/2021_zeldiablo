package objets;

import java.awt.image.BufferedImage;

import Personnages.Personnage;
import labyrinthe.Labyrinthe;

public abstract class Objet {

	/**
	 * attribut privée bi de type bufferedImage
	 */
	private BufferedImage bi;
	/**
	 * private x et y de type int
	 */
	private int x, y;
	/**
	 * attribut privée de type labyrinthe
	 */
	private Labyrinthe lab;

	/**
	 * @param n de type Labyrinthe permet la construction d'un objet
	 */
	public Objet(Labyrinthe n) {
		this.lab = n;
	}

	/**
	 * @param p de type personnage
	 * 
	 */
	public abstract void porteurPrends(Personnage p);

	public abstract void porteurPose();

	public abstract String toString();

	/**
	 * @return un atribut bufferedImage
	 */
	public BufferedImage getBi() {
		return this.bi;
	}

	/**
	 * @param b de type Buffered
	 */
	public void setBi(BufferedImage b) {
		this.bi = b;
	}

	/**
	 * @return un x de type int
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @param x de type int definie x par x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y de type int defini y par y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param x de type int
	 * @param y de type int defini x par x et y par y
	 */
	public void setPos(int x, int y) {
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
