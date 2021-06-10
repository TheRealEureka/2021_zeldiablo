package effet;

import Personnages.Heros;
import Personnages.Personnage;

public class EffetBlocage implements Effet {

	@Override
	public void effet(Personnage h) {
		h.hasEffect(true, "BLOCAGE");
}
}