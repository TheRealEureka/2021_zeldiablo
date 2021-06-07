package Labyrinthe;

import java.util.ArrayList;

public class Labyrinthe {
	
	private int largeur;
	private int hauteur; 
	public Amulette amulette;
	private ArrayList<Case> tab;
	
	public Labyrinthe(int l, int h) {
		tab = new ArrayList<Case>();
		if (this.hauteur>15 || this.hauteur<10) {
			this.hauteur = 10;
		}else {
			this.hauteur = h;
		}
		
		if (this.largeur>15 || this.largeur<10) {
			this.largeur = 10;
		}else {
			this.largeur = l;
		}
		
		this.amulette = new Amulette(3,4,this);
	}
	
	
	public boolean etreAccessible(int x, int y) {
		boolean resultat=true;
		for(int i = 0 ; i < tab.size(); i++)
		{
			if(tab.get(i).getX() == x && tab.get(i).getY() == y && tab.get(i).asCollider())
			{
				resultat=false;
			}
		}
	      return resultat;
	}
	
	public int getIndex(int x, int y)
	{
		int idx = -1;
		for(int i = 0 ; i < tab.size(); i++)
		{
			if(tab.get(i).getX() == x && tab.get(i).getY() == y)
			{
				idx=i;
				break;
			}
		}
		return idx;
	}
	
	public boolean addCase(Case c)
	{
		boolean place = false;
		if(getIndex(c.getX(), c.getY()) == -1 )
		{
			place=true;
			this.tab.add(c);
		}
		return place;
		
	}
	
	public void removeCase(int x, int y) {
		int idx = getIndex(x,y);
		if(idx!=-1)
		{
			this.tab.remove(idx);
		}
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public Amulette getAmulette() {
		return this.amulette;
	}
	
	public ArrayList<Case> getTab()
	{
		return this.tab;
	}
}
