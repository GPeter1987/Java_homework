package koPapirOllo;

import koPapirOllo.KinaiJatekos.Visszateres;

public class Biro {
	
	int jutalek = 0;
	boolean maffia = false;
	
	public boolean isMaffia() {
		return maffia;
	}
	
	public int getJutalek() {
		return jutalek;
	}
	public void setJutalek(int a) {
		 this.jutalek = this.getJutalek() + a;
	 }

	/**
	 *  
	 */
	public void lebonyolit(KinaiJatekos jatekos1, KinaiJatekos jatekos2) throws Exception {
		
		//jatekos1.felmutat();
		//jatekos2.felmutat();
		// Ellen�rizz�k ,hogy mind a k�t j�t�kos rendelkezik-e minimum 3 rizzsel.
		if(jatekos1.getRizsMenny()>= 3 && jatekos2.getRizsMenny()>= 3) {
			
			if(jatekos1.getVissza() != jatekos2.getVissza()) {
				if(jatekos1.getVissza() == Visszateres.KO && 
				   jatekos2.getVissza() == Visszateres.OLLO) {
					jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
					jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
					System.out.println(jatekos1 + " Gy�z�tt");
				}
				else if(jatekos1.getVissza() == Visszateres.OLLO && 
						   jatekos2.getVissza() == Visszateres.PAPIR) {
							jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
							jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
							System.out.println(jatekos1 + " Gy�z�tt");
				}
				else if(jatekos1.getVissza() == Visszateres.PAPIR && 
						   jatekos2.getVissza() == Visszateres.KO) {
							jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
							jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
							System.out.println(jatekos1 + " Gy�z�tt");
				}
				else {
					jatekos2.setRizsMenny(jatekos2.getRizsMenny()+1); // Gy�ztes +1
					jatekos1.setRizsMenny(jatekos1.getRizsMenny()-1); // Vesztes -1
					System.out.println(jatekos2 + " Gy�z�tt");
				}
			}
			else if(jatekos1.getVissza() == jatekos2.getVissza()) {
				System.out.println(jatekos1 +  " D�ntetlent jatszott. " + jatekos2 + "-vel.");
			}
			else if(jatekos1.getRizsMenny()<3 || jatekos2.getRizsMenny()<3) {
				System.out.println("Az egyik j�t�kos t�nkre ment.");
			}
		}
		
	}
}
