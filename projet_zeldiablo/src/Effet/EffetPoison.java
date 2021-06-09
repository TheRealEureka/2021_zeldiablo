package Effet;

import Personnages.Heros;
import Personnages.Personnage;

public class EffetPoison implements Effet{

	@Override
	public void effet(Personnage h) {
		
		//h.setSubirPoison(true);
		//h.subirPoison();
		long now = System.currentTimeMillis();
		long freq = 3000;
		long next = now + freq;
		int dgt = (int) (h.getVie() * 0.02);
		int i = 0;
		
	}
	
}
