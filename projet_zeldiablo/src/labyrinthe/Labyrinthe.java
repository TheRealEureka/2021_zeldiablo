package labyrinthe;

import java.util.ArrayList;

import Personnages.Heros;
import Personnages.Monstre;
import moteurJeu.Jeu;
import objets.Amulette;
import objets.Epee;

public class Labyrinthe {

	private int largeur;
	private int hauteur;
	private Amulette amulette;
	private Epee epee;

	private Heros pers;
	private ArrayList<Case> tab;
	private ArrayList<Monstre> mon;

	/**
	 * @param l de type int
	 * @param h de type int constructeur d'un labyrinthe
	 */
	public Labyrinthe(int l, int h) {
		tab = new ArrayList<Case>();
		mon = new ArrayList<Monstre>();

		if (this.hauteur > 15 || this.hauteur < 10) {
			this.hauteur = 10;
		} else {
			this.hauteur = h;
		}

		if (this.largeur > 15 || this.largeur < 10) {
			this.largeur = 10;
		} else {
			this.largeur = l;
		}

	}

	/**
	 * @return pers de type heros
	 */
	public Heros getPers() {
		return pers;
	}

	/**
	 * @param pers de type heros définie pers par pers
	 */
	public void setPers(Jeu pers) {
		this.pers = (Heros) pers;
	}

	/**
	 * @param x de type int
	 * @param y de type int
	 * @return un boolean pour savoir si la case est accessible ou non
	 */
	public boolean etreAccessible(int x, int y) {
		boolean resultat = true;
		int i = getIndex(x, y);
		if (i != -1) {
			if (tab.get(i).getX() == x && tab.get(i).getY() == y && tab.get(i).asCollider()) {
				resultat = false;
			}
		}
		return resultat;
	}

	/**
	 * @param x de type int
	 * @param y de type int
	 * @return idx
	 */
	public int getIndex(int x, int y) {
		int idx = -1;
		for (int i = 0; i < tab.size(); i++) {
			if (tab.get(i).getX() == x && tab.get(i).getY() == y) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	/**
	 * @param a de type amulette défini amulette par a
	 */
	public void setAmulette(Amulette a) {

		this.amulette = a;

	}

	/**
	 * @param e de type Epee défini epee par e
	 */
	public void setEpee(Epee e) {

		this.epee = e;

	}

	/**
	 * @param m de type monstre Ajoute des monstre
	 */
	public void addMonstre(Monstre m) {
		if (m != null) {
			this.mon.add(m);
		}
	}

	/**
	 * @param idx de type int supprime un monstre à une position donné
	 */
	public void removeMonstre(int idx) {
		try {
			this.mon.remove(idx);
		} catch (Exception e) {
		}
	}

	/**
	 * @param c de type Case
	 * @return un boolean pour l'ajout d'une case
	 */
	public boolean addCase(Case c) {
		boolean place = false;
		if (getIndex(c.getX(), c.getY()) == -1) {
			place = true;
			this.tab.add(c);
		}
		return place;

	}

	/**
	 * @param x de type int
	 * @param y de type int supprime une case
	 */
	public void removeCase(int x, int y) {
		int idx = getIndex(x, y);
		if (idx != -1) {
			this.tab.remove(idx);
		}
	}

	/**
	 * @return largeur
	 */
	public int getLargeur() {
		return this.largeur;
	}

	/**
	 * @return Hauteur
	 */
	public int getHauteur() {
		return this.hauteur;
	}

	/**
	 * @return amulette
	 */
	public Amulette getAmulette() {
		return this.amulette;
	}

	/**
	 * @return epee
	 */
	public Epee getEpee() {
		return this.epee;
	}

	/**
	 * @return tab
	 */
	public ArrayList<Case> getTab() {
		return this.tab;
	}

	/**
	 * @return mon
	 */
	public ArrayList<Monstre> getMonstre() {
		return this.mon;
	}

	/**
	 * @param monstre de type Monstre
	 * @return un int
	 */
	public int getIndexMonster(Monstre monstre) {
		int res = -1;
		for (int i = 0; i < this.mon.size(); i++) {
			if (this.mon.get(i).equals(monstre)) {
				res = i;
				break;
			}
		}
		return res;
	}

	/**
	 * 
	 */
	public void tourJeu() {
		for (int i = 0; i < this.mon.size(); i++) {
			mon.get(i).charger(pers);
			// pers.subirPoison();

		}
	}

	/**
	 * @param h de type Heros
	 * @return un monstre
	 */
	public Monstre monstreAProximite(Heros h) {
		Monstre res = null;
		for (int i = 0; i < this.mon.size(); i++) {
			Monstre m = this.mon.get(i);
			if (h.getDistance(m) <= h.getPortee()) {
				res = m;
			}

		}

		return res;
	}

	/**
	 * 
	 */
	public void reset() {
		this.tab = new ArrayList<Case>();
		this.mon = new ArrayList<Monstre>();
		this.amulette = null;
		this.epee = null;

	}

}
