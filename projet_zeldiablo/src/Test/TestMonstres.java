package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import Labyrinthe.Labyrinthe;
import Personnages.Heros;
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
		Monstre m = new Monstre(3500, 150, 42);
		int res = m.getVie();
		assertEquals("Le points de vies devrait etre de 3500", 3500, res);
		assertEquals("Les degats devrait etre de 150", 150, m.getPointsAttaque());
	}

	/**
	 * Test l'action subir d�gats quand c'est juste
	 */
	public void test_subirDegats_OK() {

		Heros h = new Heros("Stib", 5, 2, 4);
		h.subirDegats(5);
		boolean res = h.getVie() == 0;
		assertEquals("h�ros subis d�gats", true, res);
	}

	/**
	 * Test l'action subir d�gats quand les degats subis sont � 0
	 */
	public void test_subirDegats_PasOK() {
		Heros h = new Heros("Stib", 5, 2, 4);
		h.subirDegats(-5);
		boolean res = h.getVie() == 0;
		assertEquals("h�ros ne subis pas de d�gats", false, res);
	}

	/**
	 * Test l'action attaquer quand la distance est trop grande
	 */
	@Test
	public void test_attaquer_PasOk() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros();
		Monstre m = new Monstre();
		boolean res = m.attaquer(h);
		System.out.println(m.etreDansLabyrinthe(h.getLab()));
		assertEquals("Monstre ne peux pas attaque le deuxi�me", false, res);
	}

	/**
	 * Test l'action attaquer quand tout est ok
	 */
	@Test
	public void test_attaquer_OK() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros();
		Monstre m = new Monstre();
		h.setLabyrinthe(labyrinthe);
		m.setLabyrinthe(labyrinthe);
		boolean res = m.attaquer(h);
		assertEquals("Monstre attaque le deuxi�me", true, res);
	}

	/**
	 * Test la mort du heros normalement
	 */
	@Test
	public void test_Mort_Monstre_ok() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Monstre m = new Monstre(10, 5, labyrinthe, 2);
		m.subirDegats(6);
		boolean res = m.etreMort();
		assertEquals("Heros meurt", true, res);
	}

	/**
	 * Pas asseza de degats
	 */
	@Test
	public void test_Mort_Monstre_Pasok() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Monstre m = new Monstre(10, 4, labyrinthe, 2);
		m.subirDegats(4);
		boolean res = m.etreMort();
		assertEquals("Heros meurt pas", true, res);
	}

	/**
	 * Pas asseza de degats
	 */
	@Test
	public void test_Mort_Monstre_null() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h;
		Monstre m = null;
		boolean res = m.etreMort();
		assertEquals("Monstre null", false, res);
	}

}
