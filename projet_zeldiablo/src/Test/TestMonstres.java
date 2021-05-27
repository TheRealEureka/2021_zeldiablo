package Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMonstres {

	@Test
	public void testConstructeurMonstre() {
		Monstre m = new Monstre();
		boolean res = m == null;
		assertFalse("Le monstre ne devrait pas être null", res);
		
	}

}
