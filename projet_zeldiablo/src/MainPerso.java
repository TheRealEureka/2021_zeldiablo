
import javax.swing.JFrame;


import Personnages.Heros;
import graphiques.DessinPerso;
import graphiques.Fin;
import labyrinthe.GenerationLaby;
import labyrinthe.Labyrinthe;
import moteurJeu.Jeu;
import moteurJeu.MoteurGraphique;
import objets.Inventaire;


public class MainPerso extends JFrame{

	/**
	 * main pour lancer le jeu arkanoid fourni en exemple
	 * 
	 * @param args arguments inutilises
	 * @throws InterruptedException en cas de soucis de methode thread.sleep()
	 */
	public static void main(String[] args) throws InterruptedException {
		// creation du jeu
		boolean restart = true;
		while(restart)
		{
		Labyrinthe lab = new Labyrinthe(15, 15);
		GenerationLaby gL = new GenerationLaby(lab);
		gL.labyRandom();
		Inventaire inv = new Inventaire();
		Jeu jeu = new Heros(lab, inv);
		DessinPerso aff = new DessinPerso(jeu, lab);
		lab.setPers(jeu);
		// classe qui lance le moteur de jeu generique
		MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
		// lance la boucle de jeu qui tourne jusque la fin du jeu
		
		moteur.lancerJeu(400, 450);
		Fin f = new Fin();
		JFrame j = new JFrame();
		j.setSize(200,100);
		j.setContentPane(f);
		j.setVisible(true);
		int stat = f.getStatus();
		gL.reset();
		while(stat==0)
		{
			stat = f.getStatus();
		}
		
		if(stat==1)
		{
			restart=true;
			j.dispose();
		}
		if(stat==2)
		{
			restart=false;
		}
		}
		System.exit(1);
	}

}
