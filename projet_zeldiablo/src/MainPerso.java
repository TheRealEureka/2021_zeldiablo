import java.util.Scanner;

import Labyrinthe.Case;
import Labyrinthe.GenerationLaby;
import Labyrinthe.Labyrinthe;
import jeuPerso.DessinPerso;
import jeuPerso.JeuPerso;
import moteurJeu.MoteurGraphique;

/**
 * class Main
 * <p>
 * Permet de lancer le jeu jeuPerso en utilisant le moteur graphique fourni.
 * 
 * @author vthomas
 * 
 */
public class MainPerso {

	/**
	 * main pour lancer le jeu arkanoid fourni en exemple
	 * 
	 * @param args arguments inutilises
	 * @throws InterruptedException en cas de soucis de methode thread.sleep()
	 */
	public static void main(String[] args) throws InterruptedException {
		// creation du jeu 
		Labyrinthe lab = new Labyrinthe(15,15);
		GenerationLaby gL = new GenerationLaby(lab);
		gL.labyTest();
		JeuPerso jeu = new JeuPerso(lab);
		DessinPerso aff = new DessinPerso(jeu, lab);

		// classe qui lance le moteur de jeu generique
		MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
		// lance la boucle de jeu qui tourne jusque la fin du jeu
		moteur.lancerJeu(400, 450);

		// lorsque le jeu est fini
		System.out.println("Fin du Jeu - appuyer sur entree");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		System.exit(1);
	}

}
