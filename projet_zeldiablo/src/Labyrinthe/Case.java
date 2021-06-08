package Labyrinthe;

import Effet.Effet;
import Personnages.Heros;
import Personnages.Personnage;

public class Case {
	private int x,y;
	private boolean collider;
	public Case(int _x,int _y) {
			this.x=_x;
			this.y=_y;
			this.collider = true;
	}
	
	public Case(int _x,int _y, boolean col) {
		this.x=_x;
		this.y=_y;
		this.collider=col;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean asCollider() {
		return collider;
	}

	public void setCollider(boolean collider) {
		this.collider = collider;
	}

	public String getType() {
		return "MUR";
	}

	

	public void effet(Personnage personnage) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
