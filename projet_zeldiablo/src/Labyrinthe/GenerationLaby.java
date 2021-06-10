package Labyrinthe;

import Personnages.Fantome;
import Personnages.Monstre;
import Personnages.Troll;

public class GenerationLaby {
	private Labyrinthe l;
	private static int tour = 0;
	private final static int NB_MAP=1;
	public GenerationLaby(Labyrinthe l) {
		this.l = l;
	}



	public void generationAleatoire() {
		this.l.reset();
		tour++;
		int caseDec = 0;
		for (int i = 0; i < 15; i++) {
			for (int y = 1; y < 15; y++) {
				int r = (int) (Math.random() * 6);
				if (r == 1) {
					l.addCase(new Case(i, y));
				} else if (r == 4 && caseDec < 22) {
					caseDec++;
					l.addCase(new CaseDeclencheuse(i, y));
				}
			}
		}
		
		
		for (int i = 0; i < 4; i++) {
			int r = (int) (Math.random() * 3);
			int x = (int) (Math.random() * l.getLargeur());
			int y = (int) (Math.random() * l.getHauteur());
			while (!l.etreAccessible(x, y)) {
				x = (int) (Math.random() * l.getLargeur());
				y = (int) (Math.random() * l.getLargeur());
			}
			switch(r) {
			case 0:
				Monstre m = new Fantome(l);
				m.setPosX(x);
				m.setPosY(y);
				l.addMonstre(m);
			
				break;
			case 1:
				Monstre t = new Troll(l);
				t.setPosX(x);
				t.setPosY(y);
				l.addMonstre(t);
		
				break;
			case 2:
				Monstre mn = new Monstre(l);
				mn.setPosX(x);
				mn.setPosY(y);
				l.addMonstre(mn);
			
				break;
			}
		}
	}
	
	public void gen1()
	{
		this.l.reset();
		tour++;
		if(tour>3)
		{
			l.setAmulette(new Amulette(15, 6, l, "String"));
		}
		else
		{
			l.addCase(new Porte(15,6,l));
		}
		for (int i = 0; i < 8; i++) {
			l.addCase(new Case(1, i+1));
			l.addCase(new Case(3, i+2));

			l.addCase(new Case(i+1, 10));

		}
		for (int i = 1; i <= 15; i++) {
			l.addCase(new Case(i, 0));

		}
		for (int i = 4; i <= 14; i++) {
			l.addCase(new Case(i, 4));
		}
		l.addCase(new Case(5, 1));
		l.addCase(new Case(5, 2));

		for (int i = 6; i <= 13; i++) {
			l.addCase(new Case(i, 2));
		}
		for (int i = 1; i < 10; i++) {
			l.addCase(new Case(i, 14));
			l.addCase(new Case(i+1, 12));
		}
		for (int i = 11; i <= 14; i++) {
			l.addCase(new Case(1, i));
		}
		for (int i = 5; i <= 10; i++) {
			l.addCase(new Case(10, i));
			l.addCase(new Case(i, 6));
			l.addCase(new Case(i-2, 8));
			l.addCase(new Case(15, i-5));

		}
		for (int i = 6; i <= 15; i++) {
			l.addCase(new Case(12, i));
		}
		for (int i = 6; i <= 14; i++) {
			l.addCase(new Case(14, i));
		}
		
		for (int i = 0; i < 6; i++) {
			int r = (int) (Math.random() * 3);
			int x = (int) (Math.random() * l.getLargeur()+1);
			int y = (int) (Math.random() * l.getHauteur()+1);
			while (!l.etreAccessible(x, y) || (x==0 && y==0)) {
				x = (int) (Math.random() * l.getLargeur());
				y = (int) (Math.random() * l.getLargeur());
			}
			switch(r) {
			case 0:
				Monstre m = new Fantome(l);
				m.setPosX(x);
				m.setPosY(y);
				l.addMonstre(m);
			
				break;
			case 1:
				Monstre t = new Troll(l);
				t.setPosX(x);
				t.setPosY(y);
				l.addMonstre(t);
		
				break;
			case 2:
				Monstre mn = new Monstre(l);
				mn.setPosX(x);
				mn.setPosY(y);
				l.addMonstre(mn);
			
				break;
			}
		}
		l.addCase(new Case(11, 14));
		l.addCase(new Case(14, 5));

		
		
		for (int i = 0; i < 15; i++) {
			int x = (int) (Math.random() * l.getLargeur());
			int y = (int) (Math.random() * l.getHauteur());
			while (!l.etreAccessible(x, y)|| (x==0 && y==0)) {
				x = (int) (Math.random() * l.getLargeur());
				y = (int) (Math.random() * l.getHauteur());
				}
				l.addCase(new CaseDeclencheuse(x, y));	
		}
	}

	public void labyRandom() {
		this.l.reset();
		int r = (int) (Math.random() * NB_MAP);
		switch(r)
		{
		case 0:
				this.gen1();
				break;
		default :
			this.gen1();
		}

	}
	
}
