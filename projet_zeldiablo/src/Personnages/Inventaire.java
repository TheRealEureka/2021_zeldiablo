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
	
	public String toString() {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i<=2 ; i++) {
			bf.append(tab[i].toString());
		}
		return bf.toString();
	}

}
