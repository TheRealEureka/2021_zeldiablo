package Personnages;

import Labyrinthe.Labyrinthe;

/**
 * Classe Monstre qui implemente l'interface Personnage
 * 
 * @author Thomas
 *
 */
public class Monstre implements Personnage {
	/**
	 * Attributs : Vie : la vie du monstre PointsAttaque : les degats du monstre
	 * labi : le labyrinte dans lequel se trouve le monstre
	 */
	private int vie;
	private int pointsAttaque;
	private Labyrinthe labi;
	private int portee;
	private Heros heros;

	/**
	 * Constructeur avec param�tre pour la vie du monstre
	 * 
	 * @param v  vie du monstre
	 * @param pA degats du monstre
	 * @param la labyrinthe du monstre
	 * @param po portee du monstre
	 */
	public Monstre(int v, int pA, Labyrinthe la, int po) {
		this.vie = v;
		this.pointsAttaque = pA;
		this.labi = la;
		this.portee = po;
	}

	/**
	 * Constructeur sans param�tre
	 */
	public Monstre() {
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
	}

	/**
	 * Constructeur avec param�tre pour la vie du monstre
	 * 
	 * @param v  vie du monstre
	 * @param pA degats du monstre
	 * @param pO portee du monstre
	 */
	public Monstre(int v, int pA, int pO) {
		this.vie = v;
		this.pointsAttaque = pA;
		this.portee = pO;
	}

	/**
	 * Constructeur avec param�tre
	 * 
	 * @param la labyrinthe du monstre
	 */
	public Monstre(Labyrinthe la) {
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
		this.labi = la;
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

	/**
	 * M�thode setVie pour changer la vie du monstre
	 * 
	 * @param v nouvelle vie du monstre
	 */
	@Override
	public void setVie(int v) {
		this.vie = v;

	}

	/**
	 * M�thode getVie pour r�cup�rer la vie du monstre
	 */
	@Override
	public int getVie() {
		return this.vie;
	}


	/**
	 * M�thode pour faire perdre des points de vies au monstre
	 */
	@Override
	public void subirDegats(int v) {
		this.vie -= v;

	}

	/**
	 * M�thode etreMort pour v�rifier si le monstre est mort
	 */
	@Override
	public boolean etreMort() {
		return this.pointsAttaque == 0;
	}

	/**
	 * M�thode qui retourne les points de d�gats du monstre
	 * 
	 * @return pointsAttaque du monstre
	 */
	@Override
	public int getPointsAttaque() {
		return this.pointsAttaque;
	}

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

//Rajouter && (this.getPortee() >= this.getDistance(victime)) une fois distance cr�er
	public boolean attaquer(Personnage victime) {
		if ((this != null) && (victime != null) && (victime.etreDansLabyrinthe(this.labi)) && (victime.getVie() > 0)
				&& (this.vie > 0)) {
			victime.subirDegats(this.pointsAttaque);
			return true;

		}
		return false;
	}
}
