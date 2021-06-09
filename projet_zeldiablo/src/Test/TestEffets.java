package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Effet.Effet;
import Effet.EffetGagnerPv;
import Effet.EffetPoison;
import Effet.EffetTeleportation;
import Labyrinthe.Labyrinthe;
import Personnages.Heros;

public class TestEffets {

	@Test
	public void testEffetGagnerPv() {
		Labyrinthe la = new Labyrinthe(12, 12);
		Effet e = new EffetGagnerPv();
		Heros h = new Heros();
		e.effet(h);
		
		assertEquals("Les points de vies ne sont pas les bons", 175, h.getVie());

	}

	@Test
	public void testEffetPoison() {
		Effet e = new EffetPoison();
		Heros h = new Heros();
		
		e.effet(h);
		System.out.println(h.getVie());
		assertEquals("Les points de vies ne sont pas bons", 138, h.getVie());
	}
	
	
	@Test
	public void testEffetTeleportation() {
		Labyrinthe la = new Labyrinthe(15, 15);
		Effet e = new EffetTeleportation();
		Heros h = new Heros();
		h.setLabyrinthe(la);
		int ancienX = h.getPosX();

		e.effet(h);
		boolean res = ancienX == h.getPosX();
		
		assertFalse("Le heros devrait avoir bougé", res);
		
		
	}
}
