package jeuPerso;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Labyrinthe.Case;
import Labyrinthe.Labyrinthe;
import Labyrinthe.Objet;
import Personnages.Monstre;
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

	private BufferedImage troll, fantome, image, background, stone, cd_off, cd_on, monstre, amulette;
	private String source =  "src/images/";
	/**
	 * appelle constructeur parent
	 * 
	 * @param j le jeutest a afficher
	 */
	public DessinPerso(JeuPerso j, Labyrinthe lab) {
		this.jeu = j;
		this.laby = lab;
		try {
			image = ImageIO.read(new File(source+"2.png"));
			background =  ImageIO.read(new File(source+"background.png"));
			stone =  ImageIO.read(new File(source+"stone.png"));
			cd_off =  ImageIO.read(new File(source+"cd_off.png"));
			cd_on =  ImageIO.read(new File(source+"cd_on.png"));
			monstre =  ImageIO.read(new File(source+"monstre.png"));
			troll =  ImageIO.read(new File(source+"troll.png"));
			fantome =  ImageIO.read(new File(source+"fantome.png"));
			amulette = ImageIO.read(new File(source+"totem.png"));

		} catch (IOException e) {
		}
	}

	/**
	 * dessiner un objet consiste a dessiner sur l'image suivante methode redefinie
	 * de Afficheur
	 * 
	 * @throws IOException
	 */
	private void dessinerObjet(String s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		switch (s) {
		case "BACKGROUND" : 
			for(int i = 0 ; i <= 15 ; i++)
			{
				for(int t = 0 ; t<= 16 ;t++)
				{
					crayon.drawImage(background, i * TAILLE_CASE, t * TAILLE_CASE, null);
				}
			}
			break;
		case "INV_UI" :
			crayon.setColor(new Color(61,223,120));
			crayon.fillRect(0, 401, 400, 50);
			crayon.setColor(Color.BLACK);
			crayon.drawString("Inventaire",180,410);
			crayon.drawString("PV : "+jeu.getPj().getVie(),0,410);
			BufferedImage img1;
			BufferedImage img2;
			Objet o1 = jeu.getInv().getObj(1);
			if(o1!=null) {
				img1 = o1.getBi(); 
			}
			Objet o2 = jeu.getInv().getObj(2);
			if(o2!=null) {
				img2 = o2.getBi(); 
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
		case "MONSTER" :
			crayon.drawImage(monstre, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "TROLL" :
			crayon.drawImage(troll, x * TAILLE_CASE, y * TAILLE_CASE, null);

			break;
		case "GHOST" :
			crayon.drawImage(fantome, x * TAILLE_CASE, y * TAILLE_CASE, null);
			break;
		case "AMULETTE" : 
			crayon.drawImage(amulette, x * TAILLE_CASE, y * TAILLE_CASE, null);
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
		ArrayList<Monstre> mon = laby.getMonstre();
		for (int i = 0; i < tab.size(); i++) {
			this.dessinerObjet(tab.get(i).getType(), tab.get(i).getX(), tab.get(i).getY(), im);
		}
		for (int i = 0; i < mon.size(); i++) {
			this.dessinerObjet(mon.get(i).getType(), mon.get(i).getPosX(), mon.get(i).getPosY(), im);
		}
		this.dessinerObjet("INV_UI", 0, 0, im);
		if(laby.getAmulette()!=null)
		{
		this.dessinerObjet("AMULETTE",laby.getAmulette().getX(),laby.getAmulette().getY(),im);
		}
		this.dessinerObjet("PJ", pj.getPosX(), pj.getPosY(), im);
		
	}

}
