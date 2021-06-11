package labyrinthe;

import Personnages.Heros;
import Personnages.Personnage;
import effet.Effet;

public class Case {
	/**
	 * attribut de type position
	 */
	private int x,y;
	/**
	 * attribut de type boolean pour géré les collisions
	 */
	private boolean collider;
	/**
	 * @param _x de type int 
	 * @param _y de type int
	 * constructeur de case dur 
	 * 
	 */
	public Case(int _x,int _y) {
			this.x=_x;
			this.y=_y;
			this.collider = true;
	}
	
	/**
	 * @param _x de type int
	 * @param _y de type int
	 * @param col de type boolean
	 * constructeur de case vide
	 */
	public Case(int _x,int _y, boolean col) {
		this.x=_x;
		this.y=_y;
		this.collider=col;
	}

	/**
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x de type int
	 * defini x par x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y de type int
	 * defini x par x
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return collider
	 */
	public boolean asCollider() {
		return collider;
	}

	/**
	 * @param collider de type boolean
	 * qui defini collider par collider
	 */
	public void setCollider(boolean collider) {
		this.collider = collider;
	}

	/**
	 * @return "MUR" de type string
	 */
	public String getType() {
		return "MUR";
	}

	

	/**
	 * @param personnage de type Personnage
	 */
	public void effet(Personnage personnage) {		
	}
	
	public void ouvrir() {}
	
	
}
