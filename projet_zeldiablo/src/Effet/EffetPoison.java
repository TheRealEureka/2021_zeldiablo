package Effet;

import Personnages.Heros;
import Personnages.Personnage;

public class EffetPoison implements Effet{

	@Override
	public void effet(Personnage h) {
		int i = 0;
		int dgt = (int) (h.getVie() * 0.02);
		
		while (i < 4) {
			
			h.subirDegats(dgt);
			i++;
		}
		
	}
	
}
