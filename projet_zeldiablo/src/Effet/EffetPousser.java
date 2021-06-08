package Effet;

import Labyrinthe.Labyrinthe;
import Personnages.Heros;

public class EffetPousser implements Effet{

	@Override
	public void effet(Heros h) {
		Labyrinthe la = h.getLab();
		int dir = (int) (Math.random() * 4);
		int longeur = (int) (Math.random() * 15);
		switch (dir) {
		case 0:
			if (!la.etreAccessible(h.getPosX()+longeur, h.getPosY())) {
				h.subirDegats(5);
			}
			h.setPosX(h.getPosX()+longeur);
			break;
		case 1:
			if (!la.etreAccessible(h.getPosX()-longeur, h.getPosY())) {
				h.subirDegats(5);
			}
			h.setPosX(h.getPosX()-longeur);
			break;
		case 2:
			if (!la.etreAccessible(h.getPosX(), h.getPosY()+longeur)) {
				h.subirDegats(5);
			}
			h.setPosY(h.getPosY() + longeur);
			break;
		case 3:
			if (!la.etreAccessible(h.getPosX(), h.getPosY()-longeur)) {
				h.subirDegats(5);
			}
			h.setPosY(h.getPosY() - longeur);
			break;
			
		}
		
		
	}

	
}
