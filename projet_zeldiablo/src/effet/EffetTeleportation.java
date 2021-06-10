package effet;

import Personnages.Heros;
import Personnages.Personnage;
import labyrinthe.Labyrinthe;

public class EffetTeleportation implements Effet{

	@Override
	public void effet(Personnage h) {
		
		Labyrinthe la = h.getLab();
		int x = (int) (Math.random() * la.getLargeur());
		int y = (int) (Math.random() * la.getHauteur());
		
		while (!la.etreAccessible(x, y)) {
			x = (int) (Math.random() * la.getLargeur());
			y = (int) (Math.random() * la.getHauteur());
		}
		
		h.setPosX(x);
		h.setPosY(y);
	
	}
		
	}

