package jeuPerso;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Labyrinthe.Case;
import Labyrinthe.Labyrinthe;
import Personnages.Personnage;
import moteurJeu.DessinJeu;

/**
 * un afficheur graphique associe au JeuTest fourni
 * 
 * @author vthomas
 */
public class DessinPerso implements DessinJeu {

	/**
	 * constante pour gerer la taille des cases
	 */
	private static int TAILLE_CASE = 25;

	/**
	 * lien vers le jeu a afficher
	 */
	private JeuPerso jeu;
	private Labyrinthe laby;
	/**
	 * appelle constructeur parent
	 * 
	 * @param j
	 *            le jeutest a afficher
	 */
	public DessinPerso(JeuPerso j, Labyrinthe lab) {
		this.jeu = j;
		this.laby = lab;
	}

	/**
	 * dessiner un objet consiste a dessiner sur l'image suivante methode
	 * redefinie de Afficheur
	 */
	private void dessinerObjet(String s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
	
		
		switch (s) {
		case "PJ":
			crayon.setColor(Color.blue);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "MUR":
			crayon.setColor(Color.gray);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			crayon.setColor(Color.black);
			crayon.drawRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "DEC":
			crayon.setColor(Color.green);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "DEC_USED":
			crayon.setColor(Color.red);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		default:
			throw new AssertionError("objet inexistant");
		}
	}

	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		Personnage pj = jeu.getPj();
		ArrayList<Case> tab = laby.getTab();
		for(int i = 0 ; i < tab.size(); i++)
		{
			this.dessinerObjet(tab.get(i).getType(), tab.get(i).getX(), tab.get(i).getY(), im);
		}
		this.dessinerObjet("PJ", pj.getPosX(), pj.getPosY(), im);

		
		
	}

}
