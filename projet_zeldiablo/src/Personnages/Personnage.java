package Personnages;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;

public interface Personnage {
	
	
	public void setVie(int v);
	
	public int getVie();
	
	public boolean attaquer(Personnage victime);
	
	public void subirDegats(int v);
	
	public boolean etreMort();
	
	public int getPointsAttaque();
	
	public boolean etreDansLabyrinthe(Labyrinthe lab);
	
	public void setLabyrinthe(Labyrinthe lab);
	
	public void setPosXY(int x, int y);
	
	public int getPosX();
	
	public int getPosY();
	
	public boolean aAmulette();
	
	public void prendreAmulette(Amulette a);

	
}
