package effet;



import Personnages.Heros;
import Personnages.Personnage;

public class EffetPoison implements Effet{

	@Override
	public void effet(Personnage h) {
		h.hasEffect(true, "POISON");

		
	}
 	
}

