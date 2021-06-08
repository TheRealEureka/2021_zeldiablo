package Personnages;

import Labyrinthe.Labyrinthe;

public class Fantome extends Monstre {
	public Fantome(Labyrinthe l) {
		super(l);
	}

	public String getType() {
		return "GHOST";

	}

}
