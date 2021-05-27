package Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMonstres {

	@Test
	public void testConstructeurMonstreValide() {
		Monstre m = new Monstre();
		boolean res = m == null;
		assertFalse("Le monstre ne devrait pas �tre null", res);

	}

	@Test
	public void testConstructeurMonstreInvalide() {
		Monstre m = new Monstre("Troll");
		boolean res = m == null;
		assertTrue("Le monstre ne devrait pas �tre null", res);

	}

	/**
	 * Test l'action subir d�gats quand c'est juste
	 */
	public void test_subirDegats_OK() {
		Labyrinthe labyrinthe = new Labyrinthe();
		heros h = new heros("Stib", 5, 2);
		h.subirDegats(5);
		boolean res = h.getPv() == 0;
		assertEquals("h�ros subis d�gats", true, res);
	}

	/**
	 * Test l'action subir d�gats quand les degats subis sont � 0
	 */
	public void test_subirDegats_PasOK() {
		Labyrinthe labyrinthe = new Labyrinthe();
		heros h = new heros("Stib", 5, 2);
		h.subirDegats(-5);
		boolean res = h.getPv() == 0;
		assertEquals("h�ros ne subis pas de d�gats", false, res);
	}

}
