package Effet;

import Personnages.Heros;
import Personnages.Personnage;

public class EffetGagnerPv implements Effet{

	@Override
	public void effet(Personnage h) {
		
		h.subirDegats(-25);
	}
	
}
