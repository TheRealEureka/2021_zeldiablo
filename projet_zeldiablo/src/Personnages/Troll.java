package Personnages;

import labyrinthe.Labyrinthe;

public class Troll extends Monstre {
	/**
	 * @param l de type labyrinthe permet la construction d'un troll dans un
	 *          labyrinthe defini
	 */
	public Troll(Labyrinthe l) {
		super(3, 2, l, 1);
	}

	/**
	 * @return un String
	 */
	public String getType() {
		return "TROLL";

	}

}
