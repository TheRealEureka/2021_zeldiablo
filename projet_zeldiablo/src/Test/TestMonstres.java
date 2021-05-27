package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Personnages.Monstre;

public class TestMonstres {

	@Test
	public void testConstructeurMonstreVide() {
		Monstre m = new Monstre();
		boolean res = m == null;
		assertFalse("Le monstre ne devrait pas être null", res);

	}

	@Test
	public void testConstructeurMonstreNonVide() {
		Monstre m = new Monstre(3500);
		int res = m.getVie();
		assertEquals("Le points de vies devrait etre de 3500", 3500, res);

	}

	/**
	 * Test l'action subir dégats quand c'est juste
	 */
	public void test_subirDegats_OK() {
		Labyrinthe labyrinthe = new Labyrinthe();
		heros h = new heros("Stib", 5, 2);
		h.subirDegats(5);
		boolean res = h.getPv() == 0;
		assertEquals("héros subis dégats", true, res);
	}

	/**
	 * Test l'action subir dégats quand les degats subis sont à 0
	 */
	public void test_subirDegats_PasOK() {
		Labyrinthe labyrinthe = new Labyrinthe();
		heros h = new heros("Stib", 5, 2);
		h.subirDegats(-5);
		boolean res = h.getPv() == 0;
		assertEquals("héros ne subis pas de dégats", false, res);
	}

}
