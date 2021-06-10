package Personnages;

import labyrinthe.Labyrinthe;

public class Fantome extends Monstre {
	public Fantome(Labyrinthe l) {
		super(l);
		this.setCollider(false);
		this.setRange(2);
	}

	public String getType() {
		return "GHOST";

	}

}
