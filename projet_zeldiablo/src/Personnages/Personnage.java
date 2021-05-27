package Personnages;

public interface Personnage {
	
	
	public void setVie(int v);
	
	public int getVie();
	
	public void attaquer(Personnage cible);
	
	public void subirDegats(int v);
	
}
