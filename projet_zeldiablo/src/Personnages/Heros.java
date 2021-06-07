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
	 * Constructeur avec paramï¿½tre pour la vie du Heros
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
	 * Constructeur sans paramï¿½tre
	 */
	public Heros() {
		this.nom = "Stib";
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
	}

	/**
	 * Constructeur avec paramï¿½tre pour la vie du Heros
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
	 * Constructeur avec paramï¿½tre
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
	 * Mï¿½thode setVie pour changer la vie du Heros
	 * 
	 * @param v nouvelle vie du Heros
	 */
	@Override
	public void setVie(int v) {
		this.vie = v;

	}

	/**
	 * Mï¿½thode getVie pour rï¿½cupï¿½rer la vie du Heros
	 */
	@Override
	public int getVie() {
		return this.vie;
	}

	/**
	 * Mï¿½thode attaquer pour attaquer un autre personnage
	 * 
	 * @param cible, cible visï¿½e par l'attaque
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
	 * @return la distance entre l'attaquant et l'attaqué.
	 */
	public int getDistance(Monstre victime) {

		int distance = Math.abs(this.posX - victime.getPosX()) + Math.abs(this.posY - victime.getPosY());
		return distance;
	}

	/**
	 * Mï¿½thode pour faire perdre des points de vies au monstre
	 * 
	 * @param v les points de vie ï¿½ faire perdre
	 */
	@Override
	public void subirDegats(int v) {
		this.vie -= v;

	}

	/**
	 * Mï¿½thode etreMort pour vï¿½rifier si le hï¿½ros est mort
	 */
	@Override
	public boolean etreMort() {
		return this.pointsAttaque <= 0;
	}

	/**
	 * Mï¿½thode qui retourne les points de dï¿½gats du monstre
	 * 
	 * @return pointsAttaque du hï¿½ros
	 */
	@Override
	public int getPointsAttaque() {
		return this.pointsAttaque;
	}

	/**
	 * Mï¿½thode qui vï¿½rifie si le heros est dans le labyrinthe
	 * 
	 * @param lab labyrinthe ï¿½ vï¿½rifier
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
		if (commande.gauche) {
			this.posX--;
			if (this.posX < 0)
				this.posX = 0;
		}

		if (commande.droite) {
			this.posX++;
			if (this.posX >= LIMIT_X)
				this.posX = LIMIT_X;
		}

		if (commande.haut) {
			this.posY--;
			if (this.posY < 0) {
				this.posY = 0;
			}
		}

		if (commande.bas) {
			this.posY++;
			if (this.posY >= LIMIT_Y) {
				this.posY = LIMIT_Y;
			}
		}
	}
}
