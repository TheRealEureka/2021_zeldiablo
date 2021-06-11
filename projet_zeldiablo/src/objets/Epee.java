package objets;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Personnages.Personnage;
import labyrinthe.Labyrinthe;

public class Epee extends Objet {

	/**
	 * attribut rivé de type personnage
	 */
	private Personnage porteur;

	/**
	 * @param xc   de type int
	 * @param yc   de type int
	 * @param labi de type labyrinthe Construit une epee dans un labyrinthe à une
	 *             position x et y donné
	 */
	public Epee(int xc, int yc, Labyrinthe labi) {

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
		File imgLoc = new File("src/images/sword.png");
		try {
			this.setBi(ImageIO.read(imgLoc));
		} catch (IOException ex) {
			System.out.println("aya");
		}

	}

	/**
	 * @param p de type personnage permet à un personage de prendre l'épee
	 */
	public void porteurPrends(Personnage p) {
		if (p.getPosX() == this.getX() && p.getPosY() == this.getY()) {
			this.porteur = p;
			p.setPointsAttaque(p.getPointsAttaque() + 5);
		}
	}

	/**
	 * permet de posé l'épee
	 */
	public void porteurPose() {
		if (this.porteur != null) {
			this.porteur = null;
		}
	}

	/**
	 * return un string
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Epee";
	}

}
