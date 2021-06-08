package Labyrinthe;

import Effet.Effet;
import Personnages.Heros;
import Personnages.Personnage;

public class CaseDeclencheuse extends Case{
	private boolean used = false;
	public CaseDeclencheuse(int _x, int _y) {
		super(_x, _y, false);
	}
	public String getType()
	{
		String res;
		if(used)
		{
			res = "DEC_USED";
		}
		else
		{
			res = "DEC";
		}
		return res;
	}

	@Override
	public void effet(Heros heros, Effet e) {
		this.used=true;
		e.effet(heros);
	}
	
	
}
