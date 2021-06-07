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
		Troll t = new Troll();
		assertEquals("Le Troll devrait avoir 3 point de vie", 3, t.getVie());
		assertEquals("Le Troll devrait avoir une portee de 1", 3, t.getVie());
		assertEquals("Le Troll devrait avoir les degats à 2", 3, t.getVie());

	}



}
