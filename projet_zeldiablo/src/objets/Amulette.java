package objets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Personnages.Personnage;
import labyrinthe.Labyrinthe;

public class Amulette extends Objet {


	private Personnage porteur;



	public Amulette(int xc, int yc, Labyrinthe labi) {

		super (labi);
		
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
			   this.setBi(ImageIO.read(imgLoc)) ;
			} catch (IOException ex) {
			   System.out.println("aya");
			}
	 
	}



	public void porteurPrends(Personnage p) {
		if (p.getPosX() == this.getX() && p.getPosY() == this.getY()) {
			this.porteur = p;
			p.prendreAmulette(this);
		}
	}

	public void porteurPose() {
		if (this.porteur != null) {
			this.porteur = null;
		}
	}


	public String toString() {
		return "Amulette";
	}

}
