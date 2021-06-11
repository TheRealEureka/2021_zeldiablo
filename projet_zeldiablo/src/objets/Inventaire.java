package objets;

public class Inventaire {

	/**
	 * attribut privé tableau de type objet
	 */
	private Objet tab[];

	/**
	 * construit un inventaire
	 */
	public Inventaire() {
		this.tab = new Objet[2];
	}

	public void toutVider() {
		for (int i = 0; i < tab.length; i++) {
			this.tab[i] = null;
		}
	}

	/**
	 * @param idx de type int
	 * @return un objet
	 */
	public Objet getObj(int idx) {
		Objet o = null;
		if (idx >= 0 && idx < tab.length) {

			o = tab[idx];
		}

		return o;
	}

	/**
	 * @param idx de type int
	 * @param o   de type objet permet l'ajout d'un objet
	 */
	public void setObj(int idx, Objet o) {
		if (idx >= 0 && idx < tab.length) {

			tab[idx] = o;
		}
	}

	/**
	 * @param idx de type int permet la supression d'un objet
	 */
	public void removeObj(int idx) {
		if (idx >= 0 && idx < tab.length) {
			tab[idx] = null;
		}
	}

	/**
	 * @return la taille du tableau
	 */
	public int getSize() {
		return tab.length;
	}

}
