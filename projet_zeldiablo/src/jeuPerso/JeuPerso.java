package jeuPerso;

import moteurJeu.Commande;
import moteurJeu.Jeu;
import Labyrinthe.Labyrinthe;
import Personnages.*;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class JeuPerso implements Jeu {

	/**
	 * le personnage du jeu
	 */
	private Personnage pj;
	private Inventaire inv;

	/**
	 * constructeur de jeu avec un Personnage
	 */
	public JeuPerso(Labyrinthe l, Inventaire i) {
		this.pj=new Heros(l);
		this.inv=i;
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		return ("" + this.getPj());
	}

	/**
	 * demande a deplacer le personnage
	 * 
	 * @param commande
	 *            chaine qui donne ordre
	 */
	public void evoluer(Commande commande) {
		this.getPj().deplacer(commande);

	}

	@Override
	public boolean etreFini() {
		
		return pj.etreMort() || pj.getAmulette()!=null;
	}

	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	
	public Personnage getPj() {
		return pj;
	}
	
	public Inventaire getInv() {
		return this.inv;
	}

}
