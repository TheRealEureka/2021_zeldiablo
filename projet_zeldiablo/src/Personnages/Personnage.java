package Personnages;

import Labyrinthe.Amulette;
import Labyrinthe.Labyrinthe;
import moteurJeu.Commande;

public abstract class Personnage {

	private int vie;
	private int pointsAttaque;
	private Labyrinthe labi;
	private int portee;
	private int posX = 0;
	private int posY = 0;
	private Amulette amul;
	private boolean asCollider = true;
	
	private int deltaT = 0;
	private int tpsTimer = 100;
	private int tpsMax = 0;
	private boolean subir = false;
	public Personnage(int pv, int degats, Labyrinthe lab, int portee, int posX, int posY) {
		this.vie = pv;
		this.pointsAttaque = degats;
		this.labi = lab;
		this.portee = portee;
		this.posX = posX;
		this.posY = posY;

	}

	public Personnage(int pv, int degats, Labyrinthe lab, int portee) {
		this.vie = pv;
		this.pointsAttaque = degats;
		this.labi = lab;
		this.portee = portee;

	}

	public Personnage(Labyrinthe l) {
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
		this.labi = l;
	}

	public Personnage() {
		this.vie = 150;
		this.pointsAttaque = 20;
		this.portee = 1;
	}

	public void subirDegats(int degats) {
		if (this.vie - degats < 0) {
			this.vie = 0;
		} else {
			this.vie -= degats;
		}
	}

	public boolean attaquer(Personnage victime) {
		boolean res = false;
		if ((this != null) && (victime != null) && (victime.getVie() > 0)
				&& (this.getPortee() >= this.getDistance(victime)) && (this.etreMort() != true)
				&& (this.labi == victime.getLab())) {
			victime.subirDegats(this.pointsAttaque);
			res = true;

		}
		return res;
	}

	public int getDistance(Personnage victime) {

		int distance = Math.abs(this.posX - victime.getPosX()) + Math.abs(this.posY - victime.getPosY());
		return distance;
	}

	public boolean etreMort() {
		boolean res = false;
		if (this.vie == 0) {
			System.out.println(this + " sest mort");
			res = true;

		}
		return res;
	}

	public boolean prendreAmulette(Amulette a) {
		boolean res = false;
		if ((a.getX() == this.getPosX()) && (a.getY() == this.getPosY()) && (a != null) && (this != null)
				&& (this.labi == a.getLab())) {
			this.amul = a;
			res = true;
		}
		return res;

	}

	public void poserAmulette() {
		if ((this.amul != null) && (this != null)) {
			amul.porteurPose();
			this.amul = null;

		}
	}

	public int getPointsAttaque() {
		return this.pointsAttaque;
	}

	public Labyrinthe getLab() {
		return this.labi;

	}

	public void setLabyrinthe(Labyrinthe lab) {
		this.labi = lab;
	}

	public int getVie() {
		return this.vie;
	}

	public int getPortee() {
		return portee;
	}

	public void setPosX(int x) {
		this.posX = x;
	}

	public void setPosY(int y) {
		this.posY = y;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public Amulette getAmulette() {

		return this.amul;
	}

	public boolean isCollider() {
		return asCollider;
	}

	public void setCollider(boolean asCollider) {
		this.asCollider = asCollider;
	}

	public abstract String getType();

	public abstract void bloquerDeplacement();

	public abstract void autoriserDeplacement();

	public abstract boolean etreFini();

	public void setSubirPoison(boolean h)
	{
		this.subir=h;
	}
	public void subirPoison() {
		int dgt = (int) (this.getVie() * 0.02);
		if(deltaT >= tpsTimer && tpsMax <= 4 && subir)
		{
			//subir
			deltaT =0;
		}
		else
		{
			deltaT+=50;
			tpsMax+=50;
		}
		if(tpsMax >= 4 )
		{
			subir=false;
		}
		
	}

}
