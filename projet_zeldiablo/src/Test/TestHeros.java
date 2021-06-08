package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Labyrinthe.Labyrinthe;
import Personnages.Heros;
import Personnages.Monstre;

public class TestHeros {

	/**
	 * Test l'action subir d�gats quand c'est juste
	 */
	@Test
	public void test_subirDegats_OK() {

		Heros h = new Heros("Stib", 5, 2, 4);
		h.subirDegats(5);
		boolean res = h.getVie() == 0;
		assertEquals("h�ros subis d�gats", true, res);
	}

	/**
	 * Test l'action subir d�gats quand les degats subis sont � 0
	 */
	@Test
	public void test_subirDegats_PasOK() {
		Heros h = new Heros("Stib", 5, 2, 4);
		h.subirDegats(-5);
		boolean res = h.getVie() == 0;
		assertEquals("h�ros ne subis pas de d�gats", false, res);
	}



	/**
	 * Test l'action attaquer quand la portee n'est pas sufisante
	 */
	public void test_attaquer_Portee() {

		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Monstre m = new Monstre();
		Heros h = new Heros();
		h.setLabyrinthe(labyrinthe);
		m.setLabyrinthe(labyrinthe);
		h.setPortee(2);
		h.setPosX(0);
		h.setPosY(0);
		m.setPosX(10);
		m.setPosY(10);
		boolean res = m.attaquer(h);
		assertEquals("h�ros ne subis pas de d�gats", false, res);
	}

	/**
	 * Test l'action attaquer quand tout est ok
	 */
	@Test
	public void test_attaquer_OK() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Monstre m = new Monstre();
		boolean res = h.attaquer(m);
		assertEquals("Monstre attaque le deuxi�me", true, res);
	}

	/**
	 * Test la mort du heros normalement
	 */
	@Test
	public void test_Mort_Heros_ok() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Monstre m = new Monstre();
		m.attaquer(h);
		boolean res = h.etreMort();
		assertEquals("Heros meurt", true, res);
	}

	/**
	 * Pas asseza de degats
	 */
	@Test
	public void test_Mort_Heros_Pasok() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Monstre m = new Monstre();
		m.attaquer(h);
		boolean res = h.etreMort();
		assertEquals("Heros meurt pas", true, res);
	}

}
