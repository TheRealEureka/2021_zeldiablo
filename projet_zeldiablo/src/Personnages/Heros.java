package Personnages;

import Labyrinthe.Labyrinthe;

public class Heros implements Personnage {

	/**
	 * Attributs : Vie : la vie du heros PointsAttaque : les degats du Heros labi :
	 * le labyrinte dans lequel se trouve le Heros
	 */
	private int vie;
	private int pointsAttaque;
	private Labyrinthe labi;
	private int portee;
	private Monstre monstre;
	private int posX;
	private int posY;

	/**
	 * Constructeur avec param�tre pour la vie du Heros
	 * 
	 * @param v  vie du Heros
	 * @param pA degats du Heros
	 * @param la labyrinthe du Heros
	 * @param po portee du Heros
	 */
	public Heros(int v, int pA, Labyrinthe la, int po) {
		this.vie = v;
		this.pointsAttaque = pA;
		this.labi = la;
		this.portee = po;
	}

	/**
	 * Constructeur sans param�tre
	 */
	public Heros() {
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
	public Heros(int v, int pA, int pO) {
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
		if ((this != null) && (victime != null) && (victime.etreDansLabyrinthe(this.labi)) && (victime.getVie() > 0)
				&& (this.vie > 0)) {
			victime.subirDegats(this.pointsAttaque);
			return true;

		}
		return false;
	}
	
	/**
	 * M�thode pour faire perdre des points de vies au monstre
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
		return this.pointsAttaque == 0;
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
	 * @param lab labyrinthe � v�rifier 
	 */
	@Override
	public boolean etreDansLabyrinthe(Labyrinthe lab) {
		return this.labi == lab;
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

}
