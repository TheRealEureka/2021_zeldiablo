package Personnages;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;

public class Heros extends Personnage implements Jeu {

	/**
	 * Attributs : Vie : la vie du heros PointsAttaque : les degats du Heros labi :
	 * le labyrinte dans lequel se trouve le Heros
	 */
	private String nom;
	private Inventaire inv;
	private boolean deplacement;
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
	public Heros(String n, int pv, int degats, Labyrinthe lab, int portee, int posX, int posY, Inventaire i) {
		super(pv, degats, lab, portee, posX, posY);
		this.nom = n;
		this.deplacement = true;
		this.inv = i;

	}

	
	public Heros() {
		super();
		this.nom = "BOB";
		this.deplacement = true;
	

	}
	/**
	 * Constructeur avec param�tre pour la vie du Heros
	 * 
	 * @param v  vie du Heros
	 * @param pA degats du Heros
	 * @param po portee du heros
	 */
	public Heros(String n, int pv, int degats, Labyrinthe lab, int portee, Inventaire i) {
		super(pv, degats, lab, portee);
		this.nom = n;
		this.deplacement = true;
		this.inv = i;

	}

	/**
	 * Constructeur avec param�tre
	 * 
	 * @param la labyrinthe du Heros
	 */
	public Heros(Labyrinthe la, Inventaire i) {
		super(la);
		this.inv = i;
		this.nom = "Stib";
		this.deplacement = true;
	}

	public boolean herosGagne() {
		boolean res = false;
		if ((this.getAmulette() != null) && (this.etreMort() != true)) {
			res = true;

		}
		return res;
	}

	public void deplacer(Commande commande) {
		if (this.deplacement) {
			int x = this.getPosX();
			int y = this.getPosY();

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

			if (this.getLab().etreAccessible(x, y) && (this.etreMort() != true)) {
				this.setPosX(x);
				this.setPosY(y);
				int i = this.getLab().getIndex(x, y);
				if (i != -1) {
					if (this.getLab().getTab().get(i).getType() == "DEC") {
						this.getLab().getTab().get(i).effet(this);
					}
				}
				if (this.getLab().getAmulette() != null) {
					if (this.getLab().getAmulette().getX() == this.getPosX()
							&& this.getLab().getAmulette().getY() == this.getPosY() && this.getAmulette() == null) {
						this.getLab().getAmulette().porteurPrends(this);
						this.prendreAmulette(this.getLab().getAmulette());
					}
				}
			}
		}
		// mise en place de l'ia des monstres
		/*
		 * int t = this.labi.getMonstre().size(); for (int i = 0; i<t; i++) { Monstre m
		 * = this.labi.getMonstre().get(i); m.charger(this); }
		 */
	}

	public void bloquerDeplacement() {
		this.deplacement = false;
	}

	public void autoriserDeplacement() {
		this.deplacement = true;
	}

	@Override
	public String getType() {
		return "PJ";
	}

	@Override
	public void evoluer(Commande commande) {
		this.deplacer(commande);
		if (this.getAmulette() != null) {
			this.inv.setObj(1, this.getAmulette());
		} else {
			this.inv.removeObj(1);
		}
	}

	public Inventaire getInv() {
		return this.inv;
	}

	@Override
	public boolean etreFini() {
		return this.etreMort() || this.getAmulette() != null;
	}
	
	
}
