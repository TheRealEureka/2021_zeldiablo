package Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMonstres {

	@Test
	public void testConstructeurMonstreValide() {
		Monstre m = new Monstre();
		boolean res = m == null;
		assertFalse("Le monstre ne devrait pas être null", res);
		
	}
	
	@Test
	public void testConstructeurMonstreInvalide() {
		Monstre m = new Monstre("Troll");
		boolean res = m == null;
		assertTrue("Le monstre ne devrait pas être null", res);
		
	}

}
