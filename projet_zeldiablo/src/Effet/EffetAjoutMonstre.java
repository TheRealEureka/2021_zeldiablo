package Effet;

import Labyrinthe.Labyrinthe;
import Personnages.Heros;
import Personnages.Monstre;

public class EffetAjoutMonstre implements Effet{

	@Override
	public void effet(Heros h) {
		Labyrinthe la = h.getLab();
		int x = h.getPosX();
		int y = h.getPosY();
		
		int nouveauX = x++;
		int nouveauY = y;
		while (!la.etreAccessible(nouveauX, nouveauY)) {
			if (x == la.getLargeur()) {
				nouveauY++;
			}
			nouveauX++;
		}
		
		Monstre m = new Monstre(5, 22, la, 20);
		m.setPosX(nouveauX);
		m.setPosY(nouveauY);
		
	}

}
