package Test;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import Personnages.Heros;
import labyrinthe.Labyrinthe;
import objets.Epee;
import objets.Inventaire;

public class TestInventaire {

	@Test
	public void test() {
		Labyrinthe labi = new Labyrinthe(15, 15);
		Inventaire inv = new Inventaire();
		Heros h = new Heros(labi, inv);
		Epee e = new Epee(5, 5, labi);
		h.setPosX(5);
		h.setPosY(5);
		h.prendreEpee(e);
		boolean res = h.getInv().getObj(1) == null;

		assertFalse("L'epee devrait etre dans l'inventaire", res);

	}

}
