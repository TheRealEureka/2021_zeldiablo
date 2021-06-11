package objets;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Personnages.Personnage;
import labyrinthe.Labyrinthe;

public class Amulette extends Objet {

	/**
	 * attribut privé de type porteur
	 */
	private Personnage porteur;

	/**
	 * @param xc   de type int
	 * @param yc   de type int
	 * @param labi de type labyrinthe construit une amulette
	 */
	public Amulette(int xc, int yc, Labyrinthe labi) {

		super(labi);

		if (this.getX() > labi.getHauteur()) {
			this.setX(10);
		} else {
			this.setX(xc);
		}
		if (this.getY() > labi.getLargeur()) {
			this.setY(10);
		} else {
			this.setY(yc);
		}
		File imgLoc = new File("src/images/totem.png");
		try {
			this.setBi(ImageIO.read(imgLoc));
		} catch (IOException ex) {
			System.out.println("aya");
		}

	}

	/**
	 * @param p de type personnage permet au personnage de prendre l'amulette
	 */
	public void porteurPrends(Personnage p) {
		if (p.getPosX() == this.getX() && p.getPosY() == this.getY()) {
			this.porteur = p;
			p.prendreAmulette(this);
		}
	}

	/**
	 * peremet de poser l'amulette
	 */
	public void porteurPose() {
		if (this.porteur != null) {
			this.porteur = null;
		}
	}

	/**
	 * return un string
	 */
	public String toString() {
		return "Amulette";
	}

}
