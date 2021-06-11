package Personnages;

import labyrinthe.Labyrinthe;
import objets.Amulette;

public abstract class Personnage {

	private int vie;
	private int maxVie = 1;
	private int pointsAttaque;

	/**
	 * @param pointsAttaque méthode permettnt de modifier les points d'attaque
	 */
	public void setPointsAttaque(int pointsAttaque) {
		this.pointsAttaque = pointsAttaque;
	}

	private Labyrinthe labi;
	private int portee;
	private int posX = 0;
	private int posY = 0;
	private Amulette amul;
	private boolean asCollider = true;

	/**
	 * @param pv     de type int
	 * @param degats de type int
	 * @param lab    de type int
	 * @param portee de type int
	 * @param posX   de type int
	 * @param posY   de type int permet de construire un personnage
	 */
	public Personnage(int pv, int degats, Labyrinthe lab, int portee, int posX, int posY) {
		this.vie = pv;
		this.maxVie = pv;
		this.pointsAttaque = degats;
		this.labi = lab;
		this.portee = portee;
		this.posX = posX;
		this.posY = posY;

	}

	/**
	 * @param pv     de type int
	 * @param degats de type int
	 * @param lab    de type int
	 * @param portee de type int
	 */
	public Personnage(int pv, int degats, Labyrinthe lab, int portee) {
		this.vie = pv;
		this.pointsAttaque = degats;
		this.labi = lab;
		this.portee = portee;
		this.maxVie = pv;

	}

	/**
	 * @param l crée un personnage p r défaut dans un l birynthe l
	 */
	public Personnage(Labyrinthe l) {
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
		this.labi = l;
		this.maxVie = 150;

	}

	/**
	 * @param l crée un personnage par defaut
	 */
	public Personnage() {
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
		this.maxVie = 150;

	}

	/**
	 * @param degats permet un personn ge de subir des dégats lorsqu'il est attaqué
	 */
	public void subirDegats(int degats) {
		if (this.vie - degats < 0) {
			this.vie = 0;
		} else {
			this.vie -= degats;
		}
	}

	/**
	 * @param victime
	 * @return res Permet a un personnage de subir des dégats lorsqu'il est attaqué
	 */
	public boolean attaquer(Personnage victime) {
		boolean res = false;
		if ((this != null) && (victime != null) && (victime.getVie() > 0)
				&& (this.getPortee() >= this.getDistance(victime)) && (this.etreMort() != true)
				&& (this.labi == victime.getLab())) {
			victime.subirDegats(this.pointsAttaque);
			res = true;

		}
		return res;
	}

	/**
	 * @param victime
	 * @return distance Distance entre u personnage et sa victime
	 */
	public int getDistance(Personnage victime) {

		int distance = Math.abs(this.posX - victime.getPosX()) + Math.abs(this.posY - victime.getPosY());
		return distance;
	}

	public abstract boolean etreMort();

	/**
	 * @param a
	 * @return res Permet au personnage d'attraper l' amulette lorsqu'ils sont sur
	 *         la même case
	 */
	public boolean prendreAmulette(Amulette a) {
		boolean res = false;
		if ((a.getX() == this.getPosX()) && (a.getY() == this.getPosY()) && (a != null) && (this != null)
				&& (this.labi == a.getLab())) {
			this.amul = a;
			res = true;
		}
		return res;

	}

	/**
	 * méthode qui permet au joueur de poser l'amulette (non utilisé car pas la
	 * nécéssité mais utile pour une éventeulle version antérieur)
	 */
	public void poserAmulette() {
		if ((this.amul != null) && (this != null)) {
			amul.porteurPose();
			this.amul = null;

		}
	}

	/**
	 * @return int permet de donner les points d'attaques du personnage
	 */
	public int getPointsAttaque() {
		return this.pointsAttaque;
	}

	/**
	 * @return Labyrinthe méthode qui permet de donner le labyrinthe courant d'un
	 *         Personnage
	 */
	public Labyrinthe getLab() {
		return this.labi;

	}

	/**
	 * @param lab permet de réactualiser le labyrinthe courant du joueur
	 */
	public void setLabyrinthe(Labyrinthe lab) {
		this.labi = lab;
	}

	/**
	 * @return int return le nombre de vie du personnge
	 */
	public int getVie() {
		return this.vie;
	}

	/**
	 * @return int retourne la portée d'un personnage
	 */
	public int getPortee() {
		return portee;
	}

	/**
	 * @param x actualise la positio d'un personnage en x
	 */
	public void setPosX(int x) {
		this.posX = x;
	}

	/**
	 * @param x actualise la positio d'un personnage en y
	 */
	public void setPosY(int y) {
		this.posY = y;
	}

	/**
	 * @param portee actualise la portée d'un monstre
	 */
	public void setPortee(int portee) {
		this.portee = portee;
	}

	/**
	 * @return int donne la position d'un personnage en x
	 */
	public int getPosX() {
		return this.posX;
	}

	/**
	 * @return int donne la position d'un personnage en y
	 */
	public int getPosY() {
		return this.posY;
	}

	/**
	 * @return int donne le max de vie d'un personnage
	 */
	public int getMaxVie() {
		return this.maxVie;
	}

	public Amulette getAmulette() {

		return this.amul;
	}

	/**
	 * @return boolean si la colision existe (vrai) alors les personages ne peuvent
	 *         pas se rtraverser
	 */
	public boolean isCollider() {
		return asCollider;
	}

	public void setCollider(boolean asCollider) {
		this.asCollider = asCollider;
	}

	public abstract String getType();

	public abstract boolean etreFini();

	public abstract void hasEffect(boolean b, String s);

}
