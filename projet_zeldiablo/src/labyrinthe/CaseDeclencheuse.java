package labyrinthe;

import Personnages.Heros;
import Personnages.Personnage;
import effet.*;

public class CaseDeclencheuse extends Case {
	private boolean used = false;
	private static final Effet[] tab = {new EffetMort(),new EffetAjoutMonstre(), new EffetGagnerPv(), new EffetPoison(),
			new EffetTeleportation(), new EffetBlocage(), new EffetAjoutMonstre(), new EffetGagnerPv(), new EffetPoison(),
			new EffetTeleportation(), new EffetBlocage()};

	public CaseDeclencheuse(int _x, int _y) {
		super(_x, _y, false);
	}

	public String getType() {
		String res;
		if (used) {
			res = "DEC_USED";
		} else {
			res = "DEC";
		}
		return res;
	}

	@Override
	public void effet(Personnage heros) {
		this.used = true;
		int r = (int) (Math.random() * tab.length);
		if(r==0)
		{
			r = (int) (Math.random() * tab.length);

		}
	
		tab[r].effet(heros);
		
	}

}