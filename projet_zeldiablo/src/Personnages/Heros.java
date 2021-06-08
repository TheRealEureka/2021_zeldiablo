package Personnages;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;

public class Heros implements Personnage {

	/**
	 * Attributs : Vie : la vie du heros PointsAttaque : les degats du Heros labi :
	 * le labyrinte dans lequel se trouve le Heros
	 */
	private String nom;
	private int vie;
	private int pointsAttaque;
	private Labyrinthe labi;
	private int portee;
	private Monstre monstre;
	private int posX;
	private int posY;
	private Amulette amul;

	private final static int LIMIT_X = 15;
	private final static int LIMIT_Y = 15;

	/**
	 * Constructeur avec param�tre pour la vie du Heros
	 * 
	 * @param v  vie du Heros
	 * @param pA degats du Heros
	 * @param la labyrinthe du Heros
	 * @param po portee du Heros
	 */
	public Heros(String n, int v, int pA, Labyrinthe la, int po) {
		this.nom = n;
		this.vie = v;
		this.pointsAttaque = pA;
		this.labi = la;
		this.portee = po;
	}

	/**
	 * Constructeur sans param�tre
	 */
	public Heros() {
		this.nom = "Stib";
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
	}

	/**
	 * Constructeur avec param�tre pour la vie du Heros
	 * 
	 * @param v  vie du Heros
	 * @param pA degats du Heros
	 * @param po portee du heros
	 */
	public Heros(String n, int v, int pA, int pO) {
		this.nom = n;
		this.vie = v;
		this.pointsAttaque = pA;
		this.portee = pO;

	}

	/**
	 * Constructeur avec param�tre
	 * 
	 * @param la labyrinthe du Heros
	 */
	public Heros(Labyrinthe la) {
		this.nom = "Stib";
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
		this.labi = la;
	}

	/**
	 * M�thode setVie pour changer la vie du Heros
	 * 
	 * @param v nouvelle vie du Heros
	 */
	@Override
	public void setVie(int v) {
		this.vie = v;

	}

	/**
	 * M�thode getVie pour r�cup�rer la vie du Heros
	 */
	@Override
	public int getVie() {
		return this.vie;
	}

	/**
	 * M�thode attaquer pour attaquer un autre personnage
	 * 
	 * @param cible, cible vis�e par l'attaque
	 */
	@Override
	public boolean attaquer(Personnage victime) {
		boolean res = false;
		if ((this != null) && (victime != null) && (victime.etreDansLabyrinthe(this.labi)) && (victime.getVie() > 0)
				&& (this.getPortee() >= this.getDistance(victime)) && (this.vie > 0)) {
			victime.subirDegats(this.pointsAttaque);
			res = true;

		}
		return res;
	}

	/**
	 * @param victime Monstre cible de l'attaque
	 * @return la distance entre l'attaquant et l'attaqu�.
	 */

	/**
	 * M�thode pour faire perdre des points de vies au monstre
	 * 
	 * @param v les points de vie � faire perdre
	 */
	@Override
	public void subirDegats(int v) {
		this.vie -= v;

	}

	/**
	 * M�thode etreMort pour v�rifier si le h�ros est mort
	 */
	@Override
	public boolean etreMort() {
		return this.pointsAttaque <= 0;
	}

	/**
	 * M�thode qui retourne les points de d�gats du monstre
	 * 
	 * @return pointsAttaque du h�ros
	 */
	@Override
	public int getPointsAttaque() {
		return this.pointsAttaque;
	}

	/**
	 * M�thode qui v�rifie si le heros est dans le labyrinthe
	 * 
	 * @param lab labyrinthe � v�rifier
	 */
	@Override
	public boolean etreDansLabyrinthe(Labyrinthe lab) {
		boolean res = false;
		if (lab != null) {
			res = this.labi == lab;
		}

		return res;
	}

	public Labyrinthe getLab() {
		return this.labi;
	}

	@Override
	public void setLabyrinthe(Labyrinthe lab) {
		this.labi = lab;
	}

	/**
	 * @return the portee
	 */
	public int getPortee() {
		return portee;
	}

	/**
	 * @param portee the portee to set
	 */
	public void setPortee(int portee) {
		this.portee = portee;
	}

	@Override
	public void setPosXY(int x, int y) {
		this.posX = x;
		this.posY = y;

	}

	@Override
	public int getPosX() {
		return this.posX;
	}

	@Override
	public int getPosY() {
		return this.posY;
	}

	@Override
	public boolean aAmulette() {
		boolean res = false;
		if (this.amul != null)
			res = true;
		return res;
	}

	public boolean prendreAmulette(Amulette a) {
		boolean res = false;
		if (a.getX() == this.getPosX() && a.getY() == this.getPosY() && a != null) {
			this.amul = a;
			res = true;
		}
		return res;
	}

	public boolean herosGagne(Amulette a) {
		boolean res = false;
		if (this.amul != null) {
			res = true;

		}
		return res;
	}

	@Override
	public void deplacer(Commande commande) {
		int x = this.posX;
		int y = this.posY;
		if (commande.gauche) {
			x--;
			if (x < 0)
				x = 0;
		}

		if (commande.droite) {
			x++;
			if (x >= LIMIT_X)
				x = LIMIT_X;
		}

		if (commande.haut) {
			y--;
			if (y < 0) {
				y = 0;
			}
		}

		if (commande.bas) {
			y++;
			if (y >= LIMIT_Y) {
				y = LIMIT_Y;
			}

		}
		if (labi.etreAccessible(x, y)) {
			this.posX = x;
			this.posY = y;
			int i = labi.getIndex(x, y);
			if (i != -1) {
				if (labi.getTab().get(i).getType() == "DEC") {
					labi.getTab().get(i).effet(this);
				}
			}
		}
	}

	public boolean mort() {
		boolean res = false;
		if (this.vie <= 0) {
			res = true;

		}
		return res;
	}

	public int getDistance(Personnage victime) {

		int distance = Math.abs(this.posX - victime.getPosX()) + Math.abs(this.posY - victime.getPosY());
		return distance;
	}
}
