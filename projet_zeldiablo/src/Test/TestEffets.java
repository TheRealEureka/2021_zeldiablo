package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Effet.Effet;
import Effet.EffetGagnerPv;
import Effet.EffetPoison;
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

}
