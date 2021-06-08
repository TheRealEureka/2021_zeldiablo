package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;
import jeuPerso.JeuPerso;

public class TestEtreFini {

	@Test
	public void testEtreFini_OK_Amulette() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Amulette a = new Amulette(3, 3, la);
		JeuPerso p = new JeuPerso(la);
		p.getPj().setPosXY(3, 3);
		p.getPj().prendreAmulette(a);
		assertTrue("Le jeu devrait etre fini", p.etreFini());
	}
	
	@Test
	public void testEtreFini_PasOk_Amulette() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Amulette a = new Amulette(3, 3, la);
		JeuPerso p = new JeuPerso(la);
		p.getPj().setPosXY(3, 3);
		assertFalse("Le jeu devrait etre fini", p.etreFini());
	}
	
	@Test
	public void testEtreFini_Ok_Mort() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Amulette a = new Amulette(3, 3, la);
		JeuPerso p = new JeuPerso(la);
		p.getPj().subirDegats(200);
		System.out.println(p.getPj().etreMort());
		assertTrue("Le jeu devrait etre fini", p.etreFini());
	}

}
