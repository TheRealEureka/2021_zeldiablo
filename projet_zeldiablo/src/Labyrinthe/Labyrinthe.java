package Labyrinthe;

public class Labyrinthe {
	
	private int largeur;
	private int hauteur; 
	public Amulette amulette;

	public Labyrinthe(int l, int h) {
		
		if (this.hauteur>15 || this.hauteur<10) {
			this.hauteur = 10;
		}else {
			this.hauteur = h;
		}
		
		if (this.largeur>15 || this.largeur<10) {
			this.largeur = 10;
		}else {
			this.largeur = l;
		}
		
		this.amulette = new Amulette(3,4,this);
	}
	
	
	public boolean etreAccessible(int x, int y) {
		boolean resultat=true;
	      if ((x<0 || x>this.largeur-1) || (y<0 || y>this.hauteur-1)) {
	        resultat=false;
	      }
	      if ((x==3) && (y==0 || y==1 || y==2 || y==7 || y==8 || y==9)) {
	        resultat = false;
	      }
	      if ((x==7) && (y==3 || y==4 || y==5 || y==6)) {
	        resultat = false;
	      }
	      return resultat;
	}
	
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public Amulette getAmulette() {
		return this.amulette;
	}
}
