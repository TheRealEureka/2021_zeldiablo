package Labyrinthe;

import Personnages.Heros;
import Personnages.Monstre;

public class MainTest {
	public static void main(String[] args) {
		Labyrinthe l = new Labyrinthe(25, 15);
		Monstre m = new Monstre(15, 25, l, 10);
		Heros h = new Heros("Stib", 5, 5, l, 1);
		
		
		System.out.println("Ces des personnages sont dans le même labyrinthe");
		System.out.println(m.etreDansLabyrinthe(l));
		System.out.println(h.etreDansLabyrinthe(l));
		
		System.out.println(m.etreMort());
		System.out.println("Le heros va tuer le monstre");
		while (!m.etreMort()) {
			System.out.println("Stib attaque le montre, avec un coup de : " + h.getPointsAttaque() + " dégats" );
			h.attaquer(m);
		}
		
		System.out.println("Le monstre est mort");
		System.out.println(m.etreMort());
	}
}
