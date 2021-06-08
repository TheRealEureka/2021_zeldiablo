package Personnages;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;

public interface Personnage {

	public int getVie();

	public boolean attaquer(Personnage victime);

	public void subirDegats(int v);

	public boolean etreMort();

	public int getPointsAttaque();

	public void setLabyrinthe(Labyrinthe lab);

	public Labyrinthe getLab();

	public int getPosX();

	public int getPosY();

	public void setPosX(int x);

	public void setPosY(int y);

	public Amulette getAmulette();

	public boolean prendreAmulette(Amulette a);

	public int getDistance(Personnage victime);

	public void deplacer(Commande commande);
}
