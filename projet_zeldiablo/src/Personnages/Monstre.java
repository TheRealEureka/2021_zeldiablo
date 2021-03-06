
package Personnages;

import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import objets.Amulette;

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
	private int range = 5;

	private int tpsAttaque = 400;
	private int tpsDep = 350;

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
	
	/**
	 * Méthode qui permet de deplacer le héros en fonction de la commande correspondante à l'endroit où il souhaite aller
	 * @param commande
	 */

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
	
	/**
	 * Méthode qui permet au monstre de se déplacer vers un héros
	 * @param h
	 */
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

				
					if (deltaT >= tpsDep) {

						if (this.getDistance(h) > this.getPortee() && this.getDistance(h) <= range) {
								if(this.getPosX()>h.getPosX())
									c.gauche=true;
								if(this.getPosX()<h.getPosX())
									c.droite=true;
								if(this.getPosY()<h.getPosY())
									c.bas=c.bas = true;
								if(this.getPosY()>h.getPosY())
									c.haut=true;
						}
						if(this.getDistance(h) > range)
						{
						int dir = (int) (Math.random() * 10);
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


					} 
						deltaT = 0;

				}
					else {
						deltaT += 50;
					}
			}
			this.deplacer(c);

		}
	}
	
	/**
	 * Méthode qui retourne la portee du monstre
	 * @return range
	 */
	public int getRange() {
		return range;
	}
	
	/**
	 * Méthode qui permet de mettre une nouvelle portee au montre
	 * @param range 
	 */
	public void setRange(int range) {
		this.range = range;
	}
	/**
	 * Méthode etreMort qui retourne vrai si et seulement si le monstre est mort
	 */
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
	
	/**
	 * Méthode qui retourne le type du monstre
	 */
	public String getType() {
		return "MONSTER";

	}

	/**
	 * Méthode etreFini qui retourne faux
	 */
	public boolean etreFini() {
		return false;
	}
	
	/**
	 * Méthode qui permet de mettre un effet sur le personnage
	 * @param b boolean
	 * @param s string effet a subir
	 */
	@Override
	public void hasEffect(boolean b, String s) {
		//Rien
	}

}
