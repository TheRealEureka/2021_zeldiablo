package Personnages;

import labyrinthe.Labyrinthe;
import moteurJeu.Commande;
import moteurJeu.Jeu;
import objets.Amulette;
import objets.Epee;
import objets.Inventaire;
import objets.Objet;

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
	private boolean hasEffect = false;
	private String effect;
	private boolean isPause = false;

	private int deltaT = 0;
	private int tpsEffet = 100;

	private int tpsTotal = 0;
	private int dureeEffet = 400;


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
		if (!this.isPause) {
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
			
			if(commande.attaque) {
				this.attaquer(this.getLab().monstreAProximite(this));
			}

			if (this.getLab().etreAccessible(x, y) && !this.etreMort() && deplacement) {
				this.setPosX(x);
				this.setPosY(y);
				int i = this.getLab().getIndex(x, y);
				if (i != -1) {
					if (this.getLab().getTab().get(i).getType() == "DEC") {
						this.getLab().getTab().get(i).effet(this);
					}
					if (this.getLab().getTab().get(i).getType() == "PORTE") {
						this.getLab().getTab().get(i).ouvrir();
					}
				}
				if (this.getLab().getAmulette() != null) {
					if (this.getLab().getAmulette().getX() == this.getPosX()
							&& this.getLab().getAmulette().getY() == this.getPosY() && this.getAmulette() == null) {
						this.getLab().getAmulette().porteurPrends(this);
						this.prendreAmulette(this.getLab().getAmulette());
					}
		
				}
				if(this.getLab().getEpee()!=null)
				{
					if (this.getLab().getEpee().getX() == this.getPosX()
							&& this.getLab().getEpee().getY() == this.getPosY()) {
						this.getLab().getEpee().porteurPrends(this);
						this.prendreEpee(this.getLab().getEpee());
					}
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


	
	public boolean etreMort() {
		boolean res = false;
		if (this.getVie() == 0) {
			res = true;

		}
		return res;
	}

	@Override
	public String getType() {
		return "PJ";
	}

	@Override
	public void evoluer(Commande commande) {
		this.deplacer(commande);
		if (this.getAmulette() != null) {
			this.inv.setObj(0, this.getAmulette());
		} else {
			this.inv.removeObj(0);
		}
		this.effet();
		
	}
	public void prendreEpee(Epee a)
	{
		a.porteurPrends(this);
		this.inv.setObj(1, a);
		this.getLab().setEpee(null);
	}
	
	public void effet()
	{
		if(this.hasEffect)
		{
			if(tpsTotal <= dureeEffet)
			{
			if(deltaT>=tpsEffet)
			{
				switch(this.effect)
				{
				case "POISON" :
						this.subirDegats((int) (this.getVie() * 0.005));
						break;
				case "BLOCAGE" :
					this.deplacement=false;
					break;
				}
				deltaT=0;
			}
			else
			{
				deltaT+=50;
				tpsTotal+=50;
			}
			}
			else
			{
				tpsTotal = 0;
				this.deplacement=true;
				this.hasEffect = false;
			}
		}
	}
	public Inventaire getInv() {
		return this.inv;
	}

	@Override
	public boolean etreFini() {
		return this.etreMort() || this.getAmulette() != null;
	}


	public void hasEffect(boolean b, String s)
	{
		this.hasEffect = b;
		this.effect = s;
	}

	public boolean isPause() {
		return this.isPause;
	}
	

	
	public void pause() {
		this.isPause = true;
		
		
	
	}

	public void unPause() {
		this.isPause = false;
	}
	
	public void restart() {
		if (this.etreMort()) {
			super.subirDegats(-150);
		}
	}
}
