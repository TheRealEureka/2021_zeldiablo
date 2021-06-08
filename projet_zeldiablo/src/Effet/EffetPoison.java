package Effet;

import Personnages.Heros;

public class EffetPoison implements Effet{

	@Override
	public void effet(Heros h) {
		int i = 4;
		while (i > 0) {
			h.subirDegats((int) (h.getVie() * 0.2));
			i--;
		}
		
	}
	
}
