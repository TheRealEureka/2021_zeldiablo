package Effet;

import Personnages.Heros;

public class EffetGagnerPv implements Effet{

	@Override
	public void effet(Heros h) {
		h.setVie(h.getVie() + 25);
	}
	
}
