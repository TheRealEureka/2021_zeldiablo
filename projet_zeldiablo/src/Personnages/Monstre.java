
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
	private int deltaT = 0;
	private int deltaT2 = 0;

	private int tpsAttaque = 150;
	private int tpsDep = 400;

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
		if ((this.etreMort() != true)) {
			if (this.isCollider()) {
				if (this.getLab().etreAccessible(x, y)) {
					this.setPosX(x);
					this.setPosY(y);
				}

			} else {
				this.setPosX(x);
				this.setPosY(y);
			}

		}

	}

	public void charger(Heros h) {
		Commande c = new Commande();
		if (!this.etreMort()) {

			if (this.getDistance(h) <= this.getPortee()) {

				if (deltaT2 >= tpsAttaque) {
					this.attaquer(h);
					deltaT2 = 0;

				} else {
					deltaT2 += 50;

				}
			} else {
				int diffX = this.getPosX() - h.getPosX();
				int diffY = this.getPosY() - h.getPosY();
				if (this.getDistance(h) > this.getPortee() && this.getDistance(h) <= 4) {
					if (diffX >= 1 && diffX < 3 && diffY == 0) {
						c.off();
						c.bas = true;
					}
					if (diffX <= -1 && diffX > -3 && diffY == 0) {
						c.off();
						c.haut = true;
					}
					if (diffY >= 1 && diffY < 3 && diffY == 0) {
						c.off();
						c.droite = true;
					}
					if (diffY <= -1 && diffY > -3 && diffY == 0) {
						c.off();
						c.gauche = true;
					}

					if (deltaT >= tpsDep) {
						int dir = (int) (Math.random() * 5);
						switch (dir) {
						case 0:
							c.haut = true;
							break;
						case 1:
							c.bas = true;
							break;
						case 2:
							c.droite = true;
							break;
						case 3:
							c.gauche = true;
							break;
						}

						this.deplacer(c);

						deltaT = 0;
					} else {
						deltaT += 50;
					}
				}
			}
		}
	}
	public boolean etreMort() {
		boolean res = false;
		if (this.getVie() == 0) {
			int idx = this.getLab().getIndexMonster(this);
			if(idx!=-1)
			{
				this.getLab().removeMonstre(idx);
			}
			res = true;

		}
		return res;
	}

	public String getType() {
		return "MONSTER";

	}

	public void bloquerDeplacement() {
	}

	public void autoriserDeplacement() {
	}

	public boolean etreFini() {
		return false;
	}

}
