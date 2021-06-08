
package Personnages;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;

/**
 * Classe Monstre qui implemente l'interface Personnage
 * 
 * @author Thomas
 *
 */
public class Monstre extends Personnage {

	private final static int LIMIT_X = 15;
	private final static int LIMIT_Y = 15;
	/**
	 * Constructeur avec param�tre pour la vie du monstre
	 * 
	 * @param v  vie du monstre
	 * @param pA degats du monstre
	 * @param la labyrinthe du monstre
	 * @param po portee du monstre
	 */
	public Monstre(int pv, int degats, Labyrinthe lab, int portee, int posX, int posY) {
		super(pv, degats, lab, portee, posX, posY);
		

	
	}

	public Monstre(int pv, int degats, Labyrinthe lab, int portee) {
		super(pv, degats, lab, portee);


	}

	/**
	 * Constructeur sans param�tre
	 */
	public Monstre() {
		super();
	}

	/**
	 * Constructeur avec param�tre
	 * 
	 * @param la labyrinthe du monstre
	 */
	public Monstre(Labyrinthe la) {
		super(la);
	}

	
	public void deplacer(Commande commande) {
		int x = this.getPosX();
		int y = this.getPosY();
		if (commande.gauche) {
			x--;
			if (x < 0)
				x = 0;
		}

		if (commande.droite) {
			x++;
			if (x > LIMIT_X)
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
			if (y > LIMIT_Y) {
				y = LIMIT_Y;
			}
		}
		if (this.getLab().etreAccessible(x, y) && (this.etreMort() != true)) {
			this.setPosX(x);
			this.setPosY(y);

		}

	}

	public void charger(Heros h) {
		if (this.getDistance(h) == 2) {
			if (this.getLab().etreAccessible(h.getPosX() - 1, h.getPosY() - 1)) {
				this.setPosX(h.getPosX() - 1);
				this.setPosY(h.getPosY() - 1);
				while (h.etreMort() == false) {
					this.attaquer(h);
				}
			} else if (this.getLab().etreAccessible(h.getPosX() + 1, h.getPosY() + 1)) {
				this.setPosX(h.getPosX() + 1);
				this.setPosY(h.getPosY() + 1);
				while (h.etreMort() == false) {
					this.attaquer(h);
				}

			} else if (this.getLab().etreAccessible(h.getPosX() + 1, h.getPosY() - 1)) {
				this.setPosX(h.getPosX() + 1);
				this.setPosY(h.getPosY() - 1);
				while (h.etreMort() == false) {
					this.attaquer(h);
				}

			} else if (this.getLab().etreAccessible(h.getPosX() + 1, h.getPosY() - 1)) {
				this.setPosX(h.getPosX());
				this.setPosY(h.getPosY());
				while (h.etreMort() == false) {
					this.attaquer(h);
				}
			}

		}
	}


	public String getType() {
		return "MONSTER";

	}

	
	public void bloquerDeplacement() {}

	public void autoriserDeplacement() {}

	@Override
	public boolean etreFini() {return false;}



}
