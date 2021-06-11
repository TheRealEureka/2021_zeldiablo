package moteurJeu;

/**
 * classe MoteurGraphique represente un moteur de jeu generique. On lui passe un
 * jeu et un afficheur et il permet d'executer un jeu.
 * <p>
 * Cette classe contient la boucle de jeu qui fait des appels reguliers
 * <ul>
 * <li>evoluer de jeu en charge de mettre a jour les donnees du jeu
 * <li>dessiner de dessinjeu en charge de dessiner l'etat du jeu
 * </ul>
 * 
 * @author vthomas
 */
public class MoteurGraphique {

	/**
	 * le jeu a executer
	 */
	private Jeu jeu;

	/**
	 * l'interface graphique
	 */
	private InterfaceGraphique gui;

	/**
	 * l'afficheur a utiliser pour le rendu
	 */
	private DessinJeu dessin;
	
	private boolean restart = true;

	/**
	 * construit un moteur
	 * 
	 * @param pJeu
	 *            jeu a lancer
	 * @param pAffiche
	 *            afficheur a utiliser
	 */
	public MoteurGraphique(Jeu pJeu, DessinJeu pAffiche) {
		// creation du jeu
		this.jeu = pJeu;
		this.dessin = pAffiche;
	}

	/**
	 * permet de lancer le jeu
	 */
	public void lancerJeu(int width, int height) throws InterruptedException {

		// creation de l'interface graphique
		this.gui = new InterfaceGraphique(this.dessin, width, height);
		Controleur controle = this.gui.getControleur();
		
		this.gui.dessiner();
		Thread.sleep(500);
		// boucle de jeu
		while (!this.jeu.etreFini() && restart) {
			// demande controle utilisateur
			
			Commande c = controle.getCommande();
			// fait evoluer le jeu
		
			this.jeu.evoluer(c);
			
			// affiche le jeu 
		
			this.gui.dessiner();
			
			
			// met en attente
			Thread.sleep(50);
			// salut mon pote
			
		}
		this.gui.dessiner();
		Thread.sleep(500);
		this.gui.closeFrame();
	}
	
	public void restart(int i, int j) throws InterruptedException {
		this.restart = true;
		this.jeu.restart();
	}
	
	

}
