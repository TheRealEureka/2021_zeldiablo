package Labyrinthe;

import Personnages.Monstre;

public class GenerationLaby {
	private Labyrinthe l;

	public GenerationLaby(Labyrinthe l) {
		this.l = l;
	}

	public void labyTest() {

		for (int i = 0; i < 8; i++) {
			l.addCase(new Case(1, i));
			for(int y = 9 ; y < 16 ; y++ )
			{
			l.addCase(new Case(i, y));
			}
		}

		for (int y = 7; y >= 0; y--) {
			for (int i = 1; i <= 15; i++) {
				l.addCase(new Case(i, y));
			}
		}
		
		
		l.addCase(new CaseDeclencheuse(0, 1));
		Monstre m = new Monstre(l);
		m.setPosX(0);
		m.setPosY(4);
		
		l.addMonstre(m);
	}

	public void generationAleatoire() {
		for (int i = 0; i < 15; i++) {
			for (int y = 1; y < 15; y++) {
				int r = (int) (Math.random() * 3);
				if (r == 1) {
					l.addCase(new Case(i, y));
				} else if (r == 2) {

					l.addCase(new CaseDeclencheuse(i, y));
				}
			}
		}

	}
}
