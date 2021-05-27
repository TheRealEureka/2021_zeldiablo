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
	 * Constructeur avec paramètre pour la vie du monstre
	 * @param v vie du monstre
	 */
	public Monstre(int v, int pA) {
		this.vie = v;
		this.pointsAttaque = pA;
	}
	/**
	 * Constructeur sans paramètre
	 */
	public Monstre() {
		this.vie = 150;
		this.pointsAttaque = 20;
	}
	/**
	 * Méthode setVie pour changer la vie du monstre
	 * @param v nouvelle vie du monstre
	 */
	@Override
	public void setVie(int v) {
		this.vie = v;
		
	}
	
	/**
	 * Méthode getVie pour récupérer la vie du monstre
	 */
	@Override
	public int getVie() {
		return this.vie;
	}
	
	/**
	 * Méthode attaquer pour attaquer un autre personnage
	 * @param cible, cible visée par l'attaque
	 */
	@Override
	public void attaquer(Personnage cible) {
		cible.subirDegats(this.pointsAttaque);
	}
	/**
	 * Méthode pour faire perdre des points de vies au monstre
	 */
	@Override
	public void subirDegats(int v) {
		this.vie -= v;
		
	}
	/**
	 * Méthode etreMort pour vérifier si le monstre est mort
	 */
	@Override
	public boolean etreMort() {
		return this.pointsAttaque == 0;
	}
	
	/**
	 * Méthode qui retourne les points de dégats du monstre
	 * @return pointsAttaque du monstre
	 */
	public int getPointsAttaque() {
		return this.pointsAttaque;
	}
	
}
