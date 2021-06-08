package Personnages;

import Labyrinthe.Objet;

public class Inventaire {
	
	private Objet tab [];
	
	public Inventaire( ) {
		this.tab = new Objet [2];
	}
	
	public void Ouvrir() {
		
	}
	
	public void vider(int index) {
		tab[index]=null;
	}
	
	public void toutVider() {
		for (int i = 0; i<=2 ; i++) {
			this.tab[i]=null;
		}
	}
	
	public Objet getTab(int index) {
		return tab[index];
	}
	
	public String toString() {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i<=2 ; i++) {
			bf.append(tab[i].toString());
		}
		return bf.toString();
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
