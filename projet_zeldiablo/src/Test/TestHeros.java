package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;
import Personnages.Heros;
import Personnages.Monstre;

public class TestHeros {

	/**
	 * Test l'action subir dï¿½gats quand c'est juste
	 */
	@Test
	public void test_subirDegats_OK() {

		Heros h = new Heros("Stib", 5, 2, 4);
		h.subirDegats(5);
		boolean res = h.getVie() == 0;
		assertEquals("hï¿½ros subis dï¿½gats", true, res);
	}

	/**
	 * Test l'action subir dï¿½gats quand les degats subis sont ï¿½ 0
	 */
	@Test
	public void test_subirDegats_PasOK() {
		Heros h = new Heros("Stib", 5, 2, 4);
		h.subirDegats(-5);
		boolean res = h.getVie() == 0;
		assertEquals("hï¿½ros ne subis pas de dï¿½gats", false, res);
	}

	/**
	 * Test l'action attaquer quand la portee n'est pas sufisante
	 */
	@Test
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
		assertEquals("hï¿½ros ne subis pas de dï¿½gats", false, res);
	}

	/**
	 * Test l'action attaquer quand tout est ok
	 */
	@Test
	public void test_attaquer_OK() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Monstre m = new Monstre();
		h.setLabyrinthe(labyrinthe);
		m.setLabyrinthe(labyrinthe);
		h.setPosX(0);
		h.setPosY(0);
		m.setPosX(1);
		m.setPosY(0);
		boolean res = h.attaquer(m);
		assertEquals("Monstre attaque le deuxiï¿½me", true, res);
	}

	/**
	 * Test la mort du heros normalement
	 */
	@Test
	public void test_Mort_Heros_ok() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Monstre m = new Monstre(3, 6, labyrinthe, 5, 0, 0);
		h.setPosX(1);
		h.setPosY(0);
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
		Monstre m = new Monstre(15, 4, labyrinthe, 5, 0, 0);
		h.setPosX(1);
		h.setPosY(0);
		m.attaquer(h);
		boolean res = h.etreMort();
		assertEquals("Heros meurt pas", false, res);
	}

	/**
	 * Test herogagne quand tout est opérationnel
	 */
	@Test
	public void test_HeroGagne_Ok() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);
		Amulette a = new Amulette(0, 1, labyrinthe, "Amulette");
		h.setPosX(0);
		h.setPosY(1);
		h.prendreAmulette(a);
		boolean res = h.herosGagne();
		assertEquals("Amueltte récupéré", true, res);

	}

	/**
	 * Test herosGagne quand il n'a pas d'amulette
	 */
	@Test
	public void test_HeroGagne_PasOk() {
		Labyrinthe labyrinthe = new Labyrinthe(14, 14);
		Heros h = new Heros("Stib", 5, 5, labyrinthe, 2);

		boolean res = h.herosGagne();

		assertEquals("Le héros n'a pas l'amulette", false, res);

	}

}
