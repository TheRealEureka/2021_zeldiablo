package Personnages;

public class Monstre implements Personnage{
	private int vie;
	public Monstre(int v) {
		this.vie = v;
	}
	@Override
	public void setVie(int v) {
		this.vie = v;
		
	}

	@Override
	public int getVie() {
		return this.vie;
	}

	@Override
	public boolean attaquer(Personnage cible) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
