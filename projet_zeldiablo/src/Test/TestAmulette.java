package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import labyrinthe.Labyrinthe;
import objets.Amulette;

public class TestAmulette {

	@Test
	public void testConstructeurAmuletteDehorsH() {
		Labyrinthe labi = new Labyrinthe(10, 10);
		Amulette amu = new Amulette(15,2, labi);
		assertEquals("l'amulette est en dehors du labyrinthe", 10, labi.getHauteur());
	}
	
	@Test
	public void testConstructeurAmuletteDehorsL() {
		Labyrinthe labi = new Labyrinthe(10, 10);
		Amulette amu = new Amulette(2,15, labi);
		assertEquals("l'amulette est en dehors du labyrinthe", 10, labi.getLargeur());
	}
}
