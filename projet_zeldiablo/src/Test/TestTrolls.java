package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import Labyrinthe.Labyrinthe;
import Personnages.Troll;

public class TestTrolls {
	/**
	 * Test du constructeur de troll vide
	 */
	@Test
	public void testConstructeurVide() {
		Labyrinthe l = new Labyrinthe(15,15);
		Troll t = new Troll(l);
		assertEquals("Le Troll devrait avoir 3 point de vie", 3, t.getVie());
		assertEquals("Le Troll devrait avoir une portee de 1", 1, t.getPortee());
		assertEquals("Le Troll devrait avoir les degats a 2", 2, t.getPointsAttaque());

	}



}
