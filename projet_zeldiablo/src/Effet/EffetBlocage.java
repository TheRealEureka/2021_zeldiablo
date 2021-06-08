package Effet;

import Personnages.Heros;

public class EffetBlocage implements Effet {

	@Override
	public void effet(Heros h) {
		h.bloquerDeplacement();
		int i = 10;
		
		while (i > 0) {
			i--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		h.autoriserDeplacement();
	
	}

}
