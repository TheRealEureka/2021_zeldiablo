package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;

public class TestAmulette {

	@Test
	public void testConstructeurAmuletteDehorsH() {
		Labyrinthe labi = new Labyrinthe(10, 10);
		Amulette amu = new Amulette(15,2, labi, "Amulette");
		assertEquals("l'amulette est en dehors du labyrinthe", 10, labi.getHauteur());
	}
	
	@Test
	public void testConstructeurAmuletteDehorsL() {
		Labyrinthe labi = new Labyrinthe(10, 10);
		Amulette amu = new Amulette(2,15, labi, "Amulette");
		assertEquals("l'amulette est en dehors du labyrinthe", 10, labi.getLargeur());
	}
}
