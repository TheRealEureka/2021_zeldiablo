package Personnages;

import labyrinthe.Labyrinthe;

public class Fantome extends Monstre {
	/**
	 * @param l de type labyrinthe construit un fantome
	 */
	public Fantome(Labyrinthe l) {
		super(l);
		this.setCollider(false);
		this.setRange(3);
	}

	/**
	 * @return un String
	 */
	public String getType() {
		return "GHOST";

	}

}
