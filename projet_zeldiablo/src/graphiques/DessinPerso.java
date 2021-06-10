package graphiques;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import Personnages.Heros;
import Personnages.Monstre;
import Personnages.Personnage;
import labyrinthe.Case;
import labyrinthe.Labyrinthe;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import objets.Objet;

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
	private Heros joueur;
	private Labyrinthe laby;

	private BufferedImage troll, fantome, image, background, stone, cd_off, cd_on, monstre, amulette, no, wood,dead,trap,sword;
	private String source_lin = "src/images/";
	private int deltaT=0;
		private boolean isStarted = false;
	/**
	 * appelle constructeur parent
	 * 
	 * @param j le jeutest a afficher
	 */
	public DessinPerso(Jeu j, Labyrinthe lab) {
		this.joueur = (Heros) j;
		this.laby = lab;
		try {
			image = ImageIO.read(new File(source_lin + "pers.png"));
			background = ImageIO.read(new File(source_lin + "background.png"));
			stone = ImageIO.read(new File(source_lin + "stone.png"));
			cd_off = ImageIO.read(new File(source_lin + "cd_off.png"));
			cd_on = ImageIO.read(new File(source_lin + "cd_on.png"));
			monstre = ImageIO.read(new File(source_lin + "monstre.png"));
			troll = ImageIO.read(new File(source_lin + "troll.png"));
			fantome = ImageIO.read(new File(source_lin + "fantome.png"));
			amulette = ImageIO.read(new File(source_lin + "totem.png"));
			no = ImageIO.read(new File(source_lin + "no.png"));
			wood = ImageIO.read(new File(source_lin + "wood.png"));
			dead = ImageIO.read(new File(source_lin + "dead.png"));
			trap = ImageIO.read(new File(source_lin + "trapdoor.png"));
			sword = ImageIO.read(new File(source_lin + "sword.png"));

		} catch (IOException e) {

			System.out.println("aya");
		}
	}

	/**
	 * dessiner un objet consiste a dessiner sur l'image suivante methode redefinie
	 * de Afficheur
	 * 
	 * @throws IOException
	 */
	private void dessinerObjet(String s, int x, int y, Personnage p, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
	
		
		switch (s) {
		case "START" :
				this.joueur.pause();
				crayon.setColor(new Color(0, 0, 0, 150));
				crayon.fillRect(0, 150, 400, 60);
				crayon.setColor(Color.WHITE);
				Font fa = new Font("Serif", Font.BOLD, 14);
				crayon.setFont(fa);
				crayon.drawString("Z - HAUT | S - BAS | D - DROITE | Q - GAUCHE | P - ATTAQUER", 0, 170);
				Font fe = new Font("Serif", Font.BOLD, 20);
				crayon.setFont(fe);
				crayon.drawString("Le jeu demarrera dans quelques secondes", 0, 200);
				

				break;
		case "BACKGROUND":
			for (int i = 0; i <= 15; i++) {
				for (int t = 0; t <= 16; t++) {
					if(laby.getIndex(i,t)==-1)
					{
						crayon.drawImage(background, i * TAILLE_CASE, t * TAILLE_CASE, null);

					}
				}
			}
			break;
		case "INV_UI":
			Font myFont = new Font("Serif", Font.BOLD, 16);
			crayon.setFont(myFont);

			// crayon.setColor(new Color(61,223,120));
			// crayon.fillRect(0, 401, 400, 50);
			for (int i = 0; i <= 15; i++) {
				for (int t = 16; t <= 19; t++) {
					crayon.drawImage(wood, i * TAILLE_CASE, t * TAILLE_CASE, null);

				}
			}
			crayon.setColor(Color.BLACK);
			crayon.drawString("Inventaire", 160, 413);
			crayon.drawString("PV : " + joueur.getVie(), 3, 416);
			if(joueur.etreMort())
			{
				crayon.setColor(new Color(0, 0, 0, 150));
				crayon.fillRect(0, 150, 400, 60);
				crayon.setColor(Color.RED);
				Font f = new Font("Serif", Font.BOLD, 50);
				crayon.setFont(f);
				crayon.drawString("WASTED", 85, 197);
				

				
			}
			BufferedImage img1 = no;
			BufferedImage img2 = no;
			Objet o1 = joueur.getInv().getObj(0);
			if (o1 != null) {
				img1 = o1.getBi();
			}

			Objet o2 = joueur.getInv().getObj(1);
			if (o2 != null) {
				img2 = o2.getBi();
			}
			crayon.setColor(Color.BLACK);

			crayon.drawRect(173, 417, 25, 25);
			crayon.drawImage(img1, 173, 417, null);
			crayon.drawRect(202, 417, 25, 25);
			crayon.drawImage(img2, 202, 417, null);

			break;
		case "PJ":
			if(!this.joueur.etreMort())
			{
			crayon.drawImage(image, x * TAILLE_CASE, y * TAILLE_CASE, null);
			}
			else
			{
			crayon.drawImage(dead, x * TAILLE_CASE, y * TAILLE_CASE, null);

			}
			break;
		case "MUR":
			crayon.drawImage(stone, x * TAILLE_CASE, y * TAILLE_CASE, null);
			crayon.setColor(Color.black);
			crayon.drawRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
			break;
		case "DEC":
			crayon.drawImage(cd_on, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "DEC_USED":
			crayon.drawImage(cd_off, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "MONSTER":
			crayon.setColor(Color.white);
			crayon.fillRect(x * TAILLE_CASE+2, (y * TAILLE_CASE)-5, 21, 3);
			crayon.setColor(Color.red);
			crayon.fillRect(x * TAILLE_CASE+2, (y * TAILLE_CASE)-5, (21*p.getVie())/p.getMaxVie(), 3);
			crayon.drawImage(monstre, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "TROLL":
			crayon.setColor(Color.white);
			crayon.fillRect(x * TAILLE_CASE+2, (y * TAILLE_CASE)-5, 21, 3);
			crayon.setColor(Color.red);
			crayon.fillRect(x * TAILLE_CASE+2, (y * TAILLE_CASE)-5, (21*p.getVie())/p.getMaxVie(), 3);
			crayon.drawImage(troll, x * TAILLE_CASE, y * TAILLE_CASE, null);

			break;
		case "GHOST":
			crayon.setColor(Color.white);
			crayon.fillRect(x * TAILLE_CASE+2, (y * TAILLE_CASE)-5, 21, 3);
			crayon.setColor(Color.red);
			crayon.fillRect(x * TAILLE_CASE+2, (y * TAILLE_CASE)-5, (21*p.getVie())/p.getMaxVie(), 3);
			crayon.drawImage(fantome, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "AMULETTE":
			crayon.drawImage(amulette, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "SWORD":
			crayon.drawImage(sword, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "PORTE":
			crayon.drawImage(stone, x * TAILLE_CASE, y * TAILLE_CASE, null);

			crayon.drawImage(trap, x * TAILLE_CASE, y * TAILLE_CASE, null);

			break;
		default:
			throw new AssertionError("objet inexistant");
		}

	}

	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		this.dessinerObjet("BACKGROUND", 0, 0,null, im);
		ArrayList<Case> tab = laby.getTab();
		ArrayList<Monstre> mon = laby.getMonstre();
		for (int i = 0; i < tab.size(); i++) {
			this.dessinerObjet(tab.get(i).getType(), tab.get(i).getX(), tab.get(i).getY(),null, im);
		}
		for (int i = 0; i < mon.size(); i++) {
			this.dessinerObjet(mon.get(i).getType(), mon.get(i).getPosX(), mon.get(i).getPosY(),  mon.get(i),im);
		}
		if (laby.getAmulette() != null) {
			this.dessinerObjet("AMULETTE", laby.getAmulette().getX(), laby.getAmulette().getY(), null, im);
		}
		if (laby.getEpee() != null) {
			this.dessinerObjet("SWORD", laby.getEpee().getX(), laby.getEpee().getY(), null, im);
		}
		this.dessinerObjet("PJ", joueur.getPosX(), joueur.getPosY(), null,im);

		this.dessinerObjet("INV_UI", 0, 0,null, im);
		
		
		if(!isStarted)
		{
			
			this.dessinerObjet("START", 0, 0,null, im);
			if(deltaT>1000)
			{	
				
				this.joueur.unPause();
				this.isStarted=true;
		
			}
			else
			{
				deltaT+=50;
			}
		}
		laby.tourJeu();
		

	}

}
