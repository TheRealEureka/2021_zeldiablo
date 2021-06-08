package Personnages;

import Labyrinthe.Objet;

public class Inventaire {
	
	private Objet tab [];
	
	public Inventaire( ) {
		this.tab = new Objet [2];
	}
	
	public Objet getObj(int idx)
	{
		Objet o = null;
		if(idx>=9 && idx<tab.length)
		{
			o = tab[idx];
		}
		return o;
	}
	public int getSize()
	{
		return tab.length;
	}
	
	

}
