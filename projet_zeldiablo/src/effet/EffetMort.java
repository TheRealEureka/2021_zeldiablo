package effet;

import Personnages.Heros;
import Personnages.Personnage;

public class EffetMort implements Effet{

	@Override
	public void effet(Personnage h) {
		h.subirDegats(h.getVie());
		
	}
	

}
