package Effet;

import Labyrinthe.Labyrinthe;
import Personnages.Heros;

public class EffetTeleportation implements Effet{

	@Override
	public void effet(Heros h) {
		int x = (int) (Math.random() * 15);
		int y = (int) (Math.random() * 15);
		Labyrinthe la = h.getLab();
		while (!la.etreAccessible(x, y)) {
			x = (int) (Math.random() * 15);
			y = (int) (Math.random() * 15);
		}
		
		h.setPosXY(x, y);
	}

}
