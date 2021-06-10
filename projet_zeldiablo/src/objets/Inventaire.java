package objets;

public class Inventaire {
	
	private Objet tab [];
	
	public Inventaire( ) {
		this.tab = new Objet [2];
	}
	
	
	
	
	public void toutVider() {
		for (int i = 0; i<tab.length ; i++) {
			this.tab[i]=null;
		}
	}
	

	public Objet getObj(int idx)
	{
		Objet o = null;
		System.out.println(idx);
		if(idx>=0 && idx<tab.length)
		{

			o = tab[idx];
		}

		return o;
	}
	public void setObj(int idx, Objet o)
	{
		if(idx>=0 && idx<tab.length)
		{

			tab[idx] = o;
		}
	}
	public void removeObj(int idx)
	{
		if(idx>=0 && idx<tab.length)
		{
			tab[idx] = null;
		}
	}
	public int getSize()
	{
		return tab.length;
	}
	
	

	
}
