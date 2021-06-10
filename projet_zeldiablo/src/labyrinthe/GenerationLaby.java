package labyrinthe;

import Personnages.Fantome;
import Personnages.Monstre;
import Personnages.Troll;
import objets.Amulette;
import objets.Epee;

public class GenerationLaby {
	private Labyrinthe l;
	private static int tour = 0;
	private final static int NB_MAP=3;
	
	public GenerationLaby(Labyrinthe l) {
		this.l = l;
	}

	
	public void gen1()
	{
		this.l.reset();
		tour = 0;
		tour++;
		if(tour>3)
		{
			l.setAmulette(new Amulette(15, 6, l));
		}
		else
		{
			l.addCase(new Porte(15,6,l));
		}
		l.setEpee(new Epee(0,2, l));
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
	
	public void gen2() {
		this.l.reset();
		tour = 0;
		tour++;
		if(tour>2 && tour < 4)
		{
			l.setEpee(new Epee(6,13, l));
			
		}
		else if (tour > 5 && tour < 7){
			l.setAmulette(new Amulette(14, 2, l));
		}else {
			l.addCase(new Porte(14,4,l));
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
		
		for (int i = 1; i < 8; i++) {
			l.addCase(new Case(i, 1));
		}
		
		for (int i = 9; i < 15; i++) {
			l.addCase(new Case(i, 1));
		}
		
		for (int i = 1; i <= 15; i++) {
			l.addCase(new Case(15, i));
			l.addCase(new Case(0, i));
			l.addCase(new Case(i, 15));
		}
		
		for (int i = 2; i < 12; i++) {
			l.addCase(new Case(i, 3));
			
			l.addCase(new Case(i, 7));
			l.addCase(new Case(i, 9));
			l.addCase(new Case(i, 12));
			l.addCase(new Case(i, 14));
		}
		
		for (int i = 0; i < 6; i++) {
			l.addCase(new Case(i, 5));
		}
		l.addCase(new Case(7, 5));
		l.addCase(new Case(9, 6));
		l.addCase(new Case(9, 5));
		l.addCase(new CaseDeclencheuse(12, 3));
		l.addCase(new Case(13, 3));
		l.addCase(new Case(14, 3));
		l.addCase(new Case(11, 6));
		l.addCase(new CaseDeclencheuse(12, 6));
		l.addCase(new Case(11, 7));
		l.addCase(new Case(7, 4));
		l.addCase(new Case(12, 9));
		l.addCase(new Case(8, 11));
		l.addCase(new Case(5, 10));
		l.addCase(new Case(2, 13));
		l.addCase(new Case(2, 11));
		l.addCase(new CaseDeclencheuse(8, 10));
		
		for (int i = 3; i < 14; i++) {
			l.addCase(new Case(13, i));
			
		}
		
		for (int i = 0; i < 6; i++) {
			int dx = (int) (Math.random() * l.getLargeur());
			int dy = (int) (Math.random() * l.getHauteur());
			l.addCase(new CaseDeclencheuse(dx, dy));
		}
		
		}
	
	
	
	public void gen3() {
		tour++;
		if(tour < 4)
		{
			l.addCase(new Porte(14,4,l));
			
		}
		else if (tour > 5 && tour < 7){
			l.setAmulette(new Amulette(14, 2, l));
		}else {
			l.setEpee(new Epee(14, 2, l));
		}
		l.addCase(new Case(0,4));
		l.addCase(new Case(0,12));
		l.addCase(new Case(0,13));
		l.addCase(new Case(0,14));

		l.addCase(new Case(1,0));
		l.addCase(new Case(1,1));
		l.addCase(new Case(1,2));
		l.addCase(new Case(1,4));
		l.addCase(new Case(1,9));
		l.addCase(new Case(1,10));
		l.addCase(new Case(1,11));
		l.addCase(new Case(1,12));
		l.addCase(new Case(1,14));

		l.addCase(new Case(2,4));
		l.addCase(new Case(2,6));
		l.addCase(new Case(2,7));
		l.addCase(new Case(2,8));
		l.addCase(new Case(2,9));
		l.addCase(new Case(2,11));
		l.addCase(new Case(2,12));
		l.addCase(new Case(2,14));

		l.addCase(new Case(3,0));
		l.addCase(new Case(3,1));
		l.addCase(new Case(3,2));
		l.addCase(new Case(3,4));
		l.addCase(new Case(3,11));
		l.addCase(new Case(3,14));

		l.addCase(new Case(4,1));
		l.addCase(new Case(4,4));
		l.addCase(new Case(4,6));
		l.addCase(new Case(4,7));
		l.addCase(new Case(4,8));
		l.addCase(new Case(4,9));
		l.addCase(new Case(4,14));

		l.addCase(new Case(5,4));
		l.addCase(new Case(5,9));
		l.addCase(new Case(5,10));
		l.addCase(new Case(5,11));
		l.addCase(new Case(5,12));
		l.addCase(new Case(5,14));

		l.addCase(new Case(6,0));
		l.addCase(new Case(6,1));
		l.addCase(new Case(6,3));
		l.addCase(new Case(6,4));
		l.addCase(new Case(6,6));
		l.addCase(new Case(6,7));
		l.addCase(new Case(6,8));
		l.addCase(new Case(6,9));
		l.addCase(new Case(6,14));
		l.addCase(new Case(7,8));
		l.addCase(new Case(7,12));
		l.addCase(new Case(7,14));

		l.addCase(new Case(8,1));
		l.addCase(new Case(8,2));
		l.addCase(new Case(8,4));
		l.addCase(new Case(8,5));
		l.addCase(new Case(8,6));
		l.addCase(new Case(8,8));
		l.addCase(new Case(8,9));
		l.addCase(new Case(8,10));
		l.addCase(new Case(8,11));
		l.addCase(new Case(8,12));
		l.addCase(new Case(8,14));

		l.addCase(new Case(9,1));
		l.addCase(new Case(9,6));
		l.addCase(new Case(9,8));
		l.addCase(new Case(9,14));

		l.addCase(new Case(10,1));
		l.addCase(new Case(10,3));
		l.addCase(new Case(10,6));
		l.addCase(new Case(10,10));
		l.addCase(new Case(10,11));
		l.addCase(new Case(10,12));
		l.addCase(new Case(10,13));
		l.addCase(new Case(10,14));

		l.addCase(new Case(11,1));
		l.addCase(new Case(11,3));
		l.addCase(new Case(11,8));

		l.addCase(new Case(12,3));
		l.addCase(new Case(12,5));
		l.addCase(new Case(12,6));
		l.addCase(new Case(12,7));
		l.addCase(new Case(12,8));
		l.addCase(new Case(12,9));
		l.addCase(new Case(12,11));
		l.addCase(new Case(12,12));
		l.addCase(new Case(12,13));
		l.addCase(new Case(12,14)); 

		l.addCase(new Case(13,1));
		l.addCase(new Case(13,3));
		l.addCase(new Case(13,6));

		for(int i = 0; i<=14; i++){
		  l.addCase(new Case(14,i));
		}

		l.addCase(new CaseDeclencheuse(1, 7));
		l.addCase(new CaseDeclencheuse(3, 3));
		l.addCase(new CaseDeclencheuse(3, 10));
		l.addCase(new CaseDeclencheuse(5, 5));
		l.addCase(new CaseDeclencheuse(8, 3));
		l.addCase(new CaseDeclencheuse(9, 13));
		l.addCase(new CaseDeclencheuse(11, 6));
		l.addCase(new CaseDeclencheuse(11, 11));
		l.addCase(new CaseDeclencheuse(13, 8));

	
		
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
	}
	public void labyRandom() {
		this.l.reset();
		int r = (int) (Math.random() * NB_MAP);
	
		switch(r)
		{
		case 0:
				this.gen1();
				break;
		case 1:
			this.gen2();
			break;
		case 2:
			this.gen3();
			break;
			
		default :
			break;
		}

	}
	
}
