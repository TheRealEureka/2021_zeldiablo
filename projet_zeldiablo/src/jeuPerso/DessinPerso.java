package jeuPerso;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
	 * @param j le jeutest a afficher
	 */
	public DessinPerso(JeuPerso j, Labyrinthe lab) {
		this.jeu = j;
		this.laby = lab;
	}

	/**
	 * dessiner un objet consiste a dessiner sur l'image suivante methode redefinie
	 * de Afficheur
	 * 
	 * @throws IOException
	 */
	private void dessinerObjet(String s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		BufferedImage image = null;
		BufferedImage background = null;
		BufferedImage stone = null;
		BufferedImage cd_off = null;
		BufferedImage cd_on = null;

		try {
			image = ImageIO.read(new File("src/images/2.png"));
			background =  ImageIO.read(new File("src/images/background.png"));
			stone =  ImageIO.read(new File("src/images/stone.png"));
			cd_off =  ImageIO.read(new File("src/images/cd_off.png"));
			cd_on =  ImageIO.read(new File("src/images/cd_on.png"));

		} catch (IOException e) {
		}

		switch (s) {
		case "BACKGROUND" : 
			for(int i = 0 ; i <= 15 ; i++)
			{
				for(int t = 0 ; t<= 15 ;t++)
				{
					crayon.drawImage(background, i * TAILLE_CASE, t * TAILLE_CASE, null);
					
					
				}
			}
			break;
		case "PJ":
			// crayon.setColor(Color.blue);
			// crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
			crayon.drawImage(image, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "MUR":
			//crayon.setColor(Color.gray);
			//crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
			crayon.drawImage(stone, x * TAILLE_CASE, y * TAILLE_CASE, null);
			crayon.setColor(Color.black);
			crayon.drawRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
			break;
		case "DEC":
			//crayon.setColor(Color.green);
			//crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
			crayon.drawImage(cd_on, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "DEC_USED":
			//crayon.setColor(Color.red);
			//crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
			crayon.drawImage(cd_off, x * TAILLE_CASE, y * TAILLE_CASE, null);
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
		this.dessinerObjet("BACKGROUND",0, 0, im);
		ArrayList<Case> tab = laby.getTab();
		for (int i = 0; i < tab.size(); i++) {
			this.dessinerObjet(tab.get(i).getType(), tab.get(i).getX(), tab.get(i).getY(), im);
		}
		this.dessinerObjet("PJ", pj.getPosX(), pj.getPosY(), im);

	}

}
