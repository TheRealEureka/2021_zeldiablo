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
	
	/**
	 * Constructeur avec paramètre pour la vie du monstre
	 * @param v vie du monstre
	 */
	public Monstre(int v) {
		this.vie = v;
	}
	/**
	 * Constructeur sans paramètre
	 */
	public Monstre() {
		this.vie = 150;
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
		
	}
	/**
	 * Méthode pour faire perdre des points de ves au monstre
	 */
	@Override
	public void subirDegats(int v) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
