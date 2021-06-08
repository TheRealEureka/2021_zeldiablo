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
		Amulette a = new Amulette(3, 3, la, "Amulette");
		JeuPerso p = new JeuPerso(la);
		p.getPj().setPosX(3);
		p.getPj().setPosY(3);
		a.porteurPrends(p.getPj());
		p.getPj().prendreAmulette(a);
		
		assertTrue("Le jeu devrait etre fini", p.etreFini());
	}
	
	@Test
	public void testEtreFini_PasOk_Amulette() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Amulette a = new Amulette(3, 3, la, "Amulette");
		JeuPerso p = new JeuPerso(la);
		p.getPj().setPosX(3);
		p.getPj().setPosY(3);
		assertFalse("Le jeu ne devrait etre fini", p.etreFini());
	}
	
	@Test
	public void testEtreFini_Ok_Mort() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Amulette a = new Amulette(3, 3, la, "Amulette");
		JeuPerso p = new JeuPerso(la);
		p.getPj().subirDegats(200);
		System.out.println(p.getPj().etreMort());
		assertTrue("Le jeu devrait etre fini", p.etreFini());
	}

}
