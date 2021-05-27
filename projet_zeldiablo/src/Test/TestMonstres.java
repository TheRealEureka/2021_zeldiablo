package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import Labyrinthe.Labyrinthe;
import Personnages.Monstre;

public class TestMonstres {
	/**
	 * Test du constructeur de monstre vide
	 */
	@Test
	public void testConstructeurMonstreVide() {
		Monstre m = new Monstre();
		boolean res = m == null;
		assertFalse("Le monstre ne devrait pas être null", res);

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

	/**
	 * Test l'action attaquer quand la distance est trop grande
	 */
	@Test
	public void test_attaquer_PasOk() {
		Labyrinthe labyrinthe = new Labyrinthe();
		Heros h = new Heros();
		Monstre m = new Monstre();
		boolean res = m.attaquer(h);
		assertEquals("Monstre ne peux pas attaque le deuxième", false, res);
	}

	/**
	 * Test l'action attaquer quand tout est ok
	 */
	@Test
	public void test_attaquer_OK() {
		Labyrinthe labyrinthe = new Labyrinthe();
		Heros h = new Heros();
		Monstre m = new Monstre();
		boolean res = m.attaquer(h);
		assertEquals("Monstre attaque le deuxième", true, res);
	}
}
