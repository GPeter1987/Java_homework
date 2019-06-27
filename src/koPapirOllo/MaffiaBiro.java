package koPapirOllo;

import koPapirOllo.KinaiJatekos.Visszateres;

public class MaffiaBiro extends Biro{
	
	public MaffiaBiro() {
		maffia = true;
	}
	
	@Override
	public int getJutalek() {
		return jutalek;
	}
	@Override
	 public void setJutalek(int a) {
		 this.jutalek = this.getJutalek() + a;
	 }
	
	
	@Override
	public void lebonyolit(KinaiJatekos jatekos1, KinaiJatekos jatekos2) throws Exception {
		
		// Ellen�rizz�k ,hogy mind a k�t j�t�kos rendelkezik-e minimum 3 rizzsel.
		if(jatekos1.getRizsMenny()>= 3 && jatekos2.getRizsMenny()>= 3) {
			
			jatekos1.vissza = jatekos1.felmutat();
			jatekos2.vissza = jatekos2.felmutat();
			
			System.out.println("B�r�: "+jatekos1.toString().split("@")[1]+": "+
								jatekos1.getVissza()+", "+jatekos2.toString().split("@")[1]+": "+
								jatekos2.getVissza());
			//Ha a j�t�kosok nem ugyan azt mutatt�k fel.
			if(jatekos1.getVissza() != jatekos2.getVissza()) {
				// Ha K�vet mutattunk
				if(jatekos1.getVissza() == Visszateres.KO ) {
					if(jatekos2.getVissza() == Visszateres.OLLO) {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gy�z�tt");
					}else {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gy�z�tt");
					}
				// Ha pap�rt mutattunk
				}else if(jatekos1.getVissza() == Visszateres.PAPIR) {
					if(jatekos2.getVissza() == Visszateres.KO) {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gy�z�tt");
					}else {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gy�z�tt");
					}
				// Ha oll�t mutattunk	
				}else {
					if(jatekos2.getVissza() == Visszateres.KO) {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gy�z�tt");
					}else {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gy�ztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gy�z�tt");
					}
				}
				// Ha valakinek m�r nincs minimum 3 rizse
				if(jatekos1.getRizsMenny() < 3 || jatekos2.getRizsMenny() < 3) {
					System.out.println("Az egyik j�t�kos t�nkre ment.");
				}
				
			}
			//Ha ugyan azt mutatt�k
			else {
				System.out.println(jatekos1.toString().split("@")[1] +  " D�ntetlent j�tszott" + 
									jatekos2.toString().split("@")[1] + "-vel.");
				setJutalek(getJutalek()+2);
			}
			
			
		}
		
	}
		
}
