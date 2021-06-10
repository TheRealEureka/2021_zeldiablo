package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Personnages.Heros;
import Personnages.Personnage;
import labyrinthe.Labyrinthe;
import objets.Amulette;
import objets.Inventaire;

public class TestEtreFini {

	@Test
	public void testEtreFini_OK_Amulette() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Amulette a = new Amulette(3, 3, la);
		Personnage p = new Heros(la, new Inventaire());
		p.setPosX(3);
		p.setPosY(3);
		a.porteurPrends(p);
		p.prendreAmulette(a);
		
		assertTrue("Le jeu devrait etre fini", p.etreFini());
	}
	
	@Test
	public void testEtreFini_PasOk_Amulette() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Amulette a = new Amulette(3, 3, la);
		Personnage p = new Heros(la, new Inventaire());
		p.setPosX(3);
		p.setPosY(3);
		assertFalse("Le jeu ne devrait etre fini", p.etreFini());
	}
	
	@Test
	public void testEtreFini_Ok_Mort() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Amulette a = new Amulette(3, 3, la);
		Personnage p = new Heros(la, new Inventaire());
		p.subirDegats(200);
		System.out.println(p.etreMort());
		assertTrue("Le jeu devrait etre fini", p.etreFini());
	}

}
