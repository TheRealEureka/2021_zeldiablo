package Labyrinthe;

public class GenerationLaby {
	private Labyrinthe l;
	public GenerationLaby(Labyrinthe l)
	{
		this.l=l;
	}
	
	public void labyTest()
	{
		for(int i =0 ; i < 8 ; i++)
		{
			l.addCase(new Case(1,i));
			l.addCase(new Case(i,9));

		}
		for(int i =1 ; i < 8 ; i++)
		{
			l.addCase(new Case(i,7));		
		}
		l.addCase(new CaseDeclencheuse(0,1));
		
	}
	
	
	public void generationAleatoire() {
		for (int i = 0; i < 15; i++) {
			for (int y = 1; y < 15; y++) {
			int r = (int) (Math.random() * 3);
			if (r == 1) {
				l.addCase(new Case(i, y));
			}else if (r == 2) {
				
				l.addCase(new CaseDeclencheuse(i, y));
			}
		}
	}
		
		
	}
}
