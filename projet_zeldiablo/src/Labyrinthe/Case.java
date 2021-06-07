package Labyrinthe;

import Personnages.Heros;

public class Case {
	private int x,y;
	private boolean collider;
	private String type;
	public Case(int _x,int _y) {
			this.x=_x;
			this.y=_y;
			this.collider = true;
			this.type="MUR";
	}
	
	public Case(int _x,int _y, boolean col, String type) {
		this.x=_x;
		this.y=_y;
		this.collider=col;
		this.type = type;
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
		return this.type;
	}
	public void setType(String t)
	{
		this.type=t;
	}

	
	public void effet(Heros heros) {
	//LAISSER VIDE, K.	
	}
	
	
	
	
}
