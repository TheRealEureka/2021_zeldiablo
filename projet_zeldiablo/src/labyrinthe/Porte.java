package labyrinthe;

public class Porte extends Case{
	private Labyrinthe currentLabyrinthe;
	public Porte(int _x, int _y, Labyrinthe l) {
		super(_x, _y, false);
		this.currentLabyrinthe = l;
	}
	
	public void ouvrir()
	{
		this.currentLabyrinthe.getPers().setPosX(0);
		this.currentLabyrinthe.getPers().setPosY(0);
		GenerationLaby gen = new GenerationLaby(currentLabyrinthe); 
		gen.labyRandom();
	}
	public String getType() {
		return "PORTE";
	}
}
