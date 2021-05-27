package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Labyrinthe.Labyrinthe;

public class TestLabyrinthe {

	@Test
	public void testConstructeurHauteurFauxtp() {
		Labyrinthe labi = new Labyrinthe(10,2);
		assertEquals("le labyrinthe est trop petit en hauteur", 10, labi.getHauteur());
	}
	
	@Test
	public void testConstructeurLargeurFauxtp() {
		Labyrinthe labi = new Labyrinthe(2,10);
		assertEquals("le labyrinthe est trop petit en largeur", 10, labi.getLargeur());
	}
	
	@Test
	public void testConstructeurHauteurFauxtg() {
		Labyrinthe labi = new Labyrinthe(10,20);
		assertEquals("le labyrinthe est trop grand en hauteur", 10, labi.getHauteur());
	}
	
	@Test
	public void testConstructeurLargeurFauxtg() {
		Labyrinthe labi = new Labyrinthe(20,10);
		assertEquals("le labyrinthe est trop grand en largeur", 10, labi.getLargeur());
	}
	
	@Test
	public void testConstructeurHauteurVrai() {
		Labyrinthe labi = new Labyrinthe(10,10);
		assertEquals("le labyrinthe est à la bonne taille", 10, labi.getHauteur());
	}
	
	@Test
	public void testConstructeurLargeurVrai() {
		Labyrinthe labi = new Labyrinthe(10,10);
		assertEquals("le labyrinthe est à la bonne taille", 10, labi.getLargeur());
	}
	
}
