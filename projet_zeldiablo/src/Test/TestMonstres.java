package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Personnages.Monstre;

public class TestMonstres {
	/**
	 * Test du constructeur de monstre vide
	 */
	@Test
	public void testConstructeurMonstreVide() {
		Monstre m = new Monstre();
		boolean res = m == null;
		assertFalse("Le monstre ne devrait pas �tre null", res);

	}
	/**
	 * Test du constructeur de monstre non vide
	 */
	@Test
	public void testConstructeurMonstreNonVide() {
		Monstre m = new Monstre(3500, 150);
		int res = m.getVie();
		assertEquals("Le points de vies devrait etre de 3500", 3500, res);
		assertEquals("Les degats devrait etre de 150", 150, m.getPointsAttaque());
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
