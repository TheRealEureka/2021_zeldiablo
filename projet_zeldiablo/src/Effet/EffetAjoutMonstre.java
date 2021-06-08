package Effet;

import Labyrinthe.Labyrinthe;
import Personnages.Fantome;
import Personnages.Heros;
import Personnages.Monstre;
import Personnages.Troll;

public class EffetAjoutMonstre implements Effet{

	@Override
	public void effet(Heros h) {
		
		Labyrinthe la = h.getLab();
		int x = h.getPosX();
		int y = h.getPosY();
		
		int nouveauX = x+1;
		int nouveauY = y;
		while (!la.etreAccessible(nouveauX, nouveauY)) {
			if (x == la.getLargeur()) {
				nouveauY++;
			}
			nouveauX++;
		}
		int r = (int) (Math.random() * 3);
		Monstre m;
		switch(r) {
		case 0:
			m = new Monstre(15, 22, la, 20);
			m.setPosX(nouveauX);
			m.setPosY(nouveauY);
			la.addMonstre(m);
			break;
		case 1:
			m = new Troll(la);
			m.setPosX(nouveauX);
			m.setPosY(nouveauY);
			la.addMonstre(m);
			break;
		case 2:
			m = new Fantome(la);
			m.setPosX(nouveauX);
			m.setPosY(nouveauY);
			la.addMonstre(m);
			break;
			
			
		}
		
	}

}
