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
}
