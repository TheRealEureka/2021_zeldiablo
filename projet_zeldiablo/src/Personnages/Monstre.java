package Personnages;
/**
 * Classe Monstre qui implemente l'interface Personnage
 * @author Thomas
 *
 */
public class Monstre implements Personnage{
	/**
	 * Attributs :
	 * Vie : la vie du monstre
	 */
	private int vie;
	private int pointsAttaque;
	/**
	 * Constructeur avec param�tre pour la vie du monstre
	 * @param v vie du monstre
	 */
	public Monstre(int v, int pA) {
		this.vie = v;
		this.pointsAttaque = pA;
	}
	/**
	 * Constructeur sans param�tre
	 */
	public Monstre() {
		this.vie = 150;
		this.pointsAttaque = 20;
	}
	/**
	 * M�thode setVie pour changer la vie du monstre
	 * @param v nouvelle vie du monstre
	 */
	@Override
	public void setVie(int v) {
		this.vie = v;
		
	}
	
	/**
	 * M�thode getVie pour r�cup�rer la vie du monstre
	 */
	@Override
	public int getVie() {
		return this.vie;
	}
	
	/**
	 * M�thode attaquer pour attaquer un autre personnage
	 * @param cible, cible vis�e par l'attaque
	 */
	@Override
	public void attaquer(Personnage cible) {
		cible.subirDegats(this.pointsAttaque);
	}
	/**
	 * M�thode pour faire perdre des points de vies au monstre
	 */
	@Override
	public void subirDegats(int v) {
		this.vie -= v;
		
	}
	/**
	 * M�thode etreMort pour v�rifier si le monstre est mort
	 */
	@Override
	public boolean etreMort() {
		return this.pointsAttaque == 0;
	}
	
	/**
	 * M�thode qui retourne les points de d�gats du monstre
	 * @return pointsAttaque du monstre
	 */
	public int getPointsAttaque() {
		return this.pointsAttaque;
	}
	
}
