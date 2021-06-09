package Effet;



import Personnages.Heros;
import Personnages.Personnage;

public class EffetPoison implements Effet{

	@Override
	public void effet(Personnage h) {
		int dgt = (int) (h.getVie() * 0.02);
		int i = 0;
		
		
		

		
	
		while(i < 4){
			h.subirDegats(dgt);
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			i++;
			}
	
		}
	}
 	

