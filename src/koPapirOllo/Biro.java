package koPapirOllo;

import koPapirOllo.KinaiJatekos.Visszateres;

public class Biro {

	/**
	 * @throws Exception 
	 * 
	 */
	public void lebonyolit(KinaiJatekos jatekos1, KinaiJatekos jatekos2) throws Exception {
		
		
		
		// Ellen�rizz�k ,hogy mind a k�t j�t�kos rendelkezik-e minimum 3 rizzsel.
		if(jatekos1.getRizsMenny()>= 3 && jatekos2.getRizsMenny()>= 3) {
			
			if(jatekos1.getVissza() != jatekos2.getVissza()) {
				if(jatekos1.getVissza() == Visszateres.KO && 
				   jatekos2.getVissza() == Visszateres.OLLO) {
					jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
					jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
				}
				else if(jatekos1.getVissza() == Visszateres.OLLO && 
						   jatekos2.getVissza() == Visszateres.PAPIR) {
							jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
							jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
				}
				else if(jatekos1.getVissza() == Visszateres.PAPIR && 
						   jatekos2.getVissza() == Visszateres.KO) {
							jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
							jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
				}
				else {
					jatekos2.setRizsMenny(jatekos2.getRizsMenny()+1); // Gy�ztes +1
					jatekos1.setRizsMenny(jatekos1.getRizsMenny()-1); // Vesztes -1
				}
			}
		}
		
	}
}