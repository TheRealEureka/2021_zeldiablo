package Labyrinthe;
import Personnages.Personnage;
import moteurJeu.Commande;
import moteurJeu.Jeu;
public class JeuPerso implements Jeu{
	private Personnage perso;
	
	
	
	public JeuPerso(Personnage p) {
		this.perso = p;
	}
	@Override
	public void evoluer(Commande commandeUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean etreFini() {
		boolean res = false;
		if (this.perso.etreMort())
			res = true;
		
		
		
		
		return res;
	}

}
