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
		assertFalse("Le monstre ne devrait pas ï¿½tre null", res);

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
	 * Test l'action subir dï¿½gats quand c'est juste
	 */
	public void test_subirDegats_OK() {

		Monstre m = new Monstre(5, 2, 4);
		m.subirDegats(5);
		boolean res = m.getVie() == 0;
		assertEquals("hï¿½ros subis dï¿½gats", true, res);
	}

	/**
	 * Test l'action subir dï¿½gats quand les degats subis sont ï¿½ 0
	 */
	public void test_subirDegats_PasOK() {
		Monstre m = new Monstre(5, 2, 4);
		m.subirDegats(-5);
		boolean res = m.getVie() == 0;
		assertEquals("hï¿½ros ne subis pas de dï¿½gats", false, res);
	}

	/**
	 * Test l'action attaquer quand la portee n'est pas sufisante
	 */
	public void test_attaquer_Portee() {

		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Monstre m = new Monstre();
		Heros h = new Heros();
		m.setLabyrinthe(labyrinthe);
		h.setLabyrinthe(labyrinthe);
		m.setPortee(2);
		m.setPosXY(0, 0);
		h.setPosXY(10, 10);
		boolean res = m.attaquer(h);
		assertEquals("hï¿½ros ne subis pas de dï¿½gats", false, res);
	}

	/**
	 * Test l'action attaquer quand pas dans le même labyrinthe
	 */
	@Test
	public void test_attaquer_PasOk() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros();
		Monstre m = new Monstre();
		boolean res = m.attaquer(h);
		System.out.println(m.etreDansLabyrinthe(h.getLab()));
		assertEquals("Monstre ne peux pas attaque le deuxiï¿½me", false, res);
	}

	/**
	 * Test l'action attaquer quand tout est ok
	 */
	@Test
	public void test_attaquer_OK() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Monstre m = new Monstre(10, 3, labyrinthe, 2);
		boolean res = m.attaquer(h);
		assertEquals("Monstre attaque le deuxiï¿½me", true, res);
	}
}
