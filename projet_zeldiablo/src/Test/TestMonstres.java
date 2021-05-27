package Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMonstres {

	@Test
	public void testConstructeurMonstre() {
		Jeu j = new Jeu();
		j.genererLabyrinthe();
		Monstre m = new Monstre();
		j.ajouterMonstre(m);
		assertFalse("Le monstre ne devrait pas être null", m == null);
		
	}

}
