package Labyrinthe;

import Personnages.Heros;
import Personnages.Personnage;

public class CaseDeclencheuse extends Case{
	private boolean used = false;
	public CaseDeclencheuse(int _x, int _y) {
		super(_x, _y, false, "DEC");
	}
	

	@Override
	public void effet(Heros heros) {
		this.setType("DEC_USED");
		this.used=true;
	}
	
	
}
