package moteurJeu;

import Personnages.Inventaire;

/**
 * permet de representer une commande de l'utilisateur
 * 
 * @author vthomas
 *
 */
public class Commande {

	/**
	 * boolean representant la commande de l'utilisateur
	 */
	public boolean gauche;
	public boolean droite;
	public boolean haut;
	public boolean bas;
	public boolean  i;
	public boolean attaque;

	public Commande()
	{
		
	}
	
	/**
	 * constructeur par copie
	 * copie la commande pour en creer une nouvelle
	 * @param commandeACopier
	 */
	public Commande(Commande commandeACopier)
	{
		this.bas=commandeACopier.bas;
		this.haut=commandeACopier.haut;
		this.gauche=commandeACopier.gauche;
		this.droite=commandeACopier.droite;	
		this.i=commandeACopier.i;
		this.attaque=commandeACopier.attaque;
	}
	public void off()
	{
		this.bas=false;
		this.haut = false;
		this.droite=false;
		this.gauche = false;
	}
}
