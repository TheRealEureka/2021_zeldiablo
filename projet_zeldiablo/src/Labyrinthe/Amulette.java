package Labyrinthe;

import Personnages.Heros;
import Personnages.Personnage;

public class Amulette {
	
	private int x;
	private int y;
	private boolean appartient;
	private Personnage porteur;
	public Amulette(int xc, int yc, Labyrinthe labi) {
		
		if(this.x > labi.getHauteur() ) {
			this.x = 10;
		}else {
			this.x = xc;
		}
		if(this.y > labi.getLargeur() ) {
			this.y = 10;
		}else {
			this.y = yc;
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getAppartient() {
		return this.appartient;
	}
	

	public void porteurPrendsAmulette(Personnage p) {
		if (p.getPosX() == this.x && p.getPosY() == this.y) {
			this.porteur = p;
			p.prendreAmulette(this);
		}
	}
	
	public boolean heroGagne(Heros h) {
		boolean fin = false;
		if (h.getPosX() == this.x && h.getPosY() == this.y) {
			fin = true;
		}
		return fin;
	}
	
}
