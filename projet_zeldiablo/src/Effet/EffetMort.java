package Effet;

import Personnages.Heros;

public class EffetMort implements Effet{

	@Override
	public void effet(Heros h) {
		h.subirDegats(h.getVie());
		
	}
	

}
