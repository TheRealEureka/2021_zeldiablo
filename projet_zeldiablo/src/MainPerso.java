import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Personnages.Heros;
import Personnages.Personnage;
import graphiques.DessinPerso;
import labyrinthe.GenerationLaby;
import labyrinthe.Labyrinthe;
import moteurJeu.Jeu;
import moteurJeu.MoteurGraphique;
import objets.Amulette;
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
		Labyrinthe lab = new Labyrinthe(15, 15);
		GenerationLaby gL = new GenerationLaby(lab);
		gL.labyRandom();
		String restart;
		Inventaire inv = new Inventaire();
		Scanner sc = new Scanner(System.in);
		Jeu jeu = new Heros(lab, inv);
		DessinPerso aff = new DessinPerso(jeu, lab);
		lab.setPers(jeu);
		// classe qui lance le moteur de jeu generique
		MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
		// lance la boucle de jeu qui tourne jusque la fin du jeu
		moteur.lancerJeu(400, 450);
		
		
		System.out.println("Appuyez pour O pour rejouer et N pour sortir !");
		restart = sc.nextLine();
		
		while(restart.equals("O")) {
		moteur.restart(400,  450);
	
		
		
		System.out.println("Appuyez pour O pour rejouer et N pour sortir !");
		restart = sc.nextLine();
		}
		

		// lorsque le jeu est fini
		System.out.println("Fin du Jeu - appuyer sur entree");
		
		sc.nextLine();
		System.exit(1);
	}

}
