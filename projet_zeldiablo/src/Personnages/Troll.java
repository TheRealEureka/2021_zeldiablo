package Personnages;

import labyrinthe.Labyrinthe;

public class Troll extends Monstre{
	public Troll(Labyrinthe l)
	{
		super(3, 2, l ,1);
	}
	public String getType()
	{
		return "TROLL";
		
	}
	

}
