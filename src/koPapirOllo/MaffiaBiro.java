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
		
		// Ellenõrizzük ,hogy mind a két játékos rendelkezik-e minimum 3 rizzsel.
		if(jatekos1.getRizsMenny()>= 3 && jatekos2.getRizsMenny()>= 3) {
			
			jatekos1.vissza = jatekos1.felmutat();
			jatekos2.vissza = jatekos2.felmutat();
			
			System.out.println("Bíró: "+jatekos1.toString().split("@")[1]+": "+
								jatekos1.getVissza()+", "+jatekos2.toString().split("@")[1]+": "+
								jatekos2.getVissza());
			//Ha a játékosok nem ugyan azt mutatták fel.
			if(jatekos1.getVissza() != jatekos2.getVissza()) {
				// Ha Követ mutattunk
				if(jatekos1.getVissza() == Visszateres.KO ) {
					if(jatekos2.getVissza() == Visszateres.OLLO) {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gyõzött");
					}else {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gyõzött");
					}
				// Ha papírt mutattunk
				}else if(jatekos1.getVissza() == Visszateres.PAPIR) {
					if(jatekos2.getVissza() == Visszateres.KO) {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gyõzött");
					}else {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gyõzött");
					}
				// Ha ollót mutattunk	
				}else {
					if(jatekos2.getVissza() == Visszateres.KO) {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gyõzött");
					}else {
						jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
						jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
						System.out.println(jatekos1 + " Gyõzött");
					}
				}
				// Ha valakinek már nincs minimum 3 rizse
				if(jatekos1.getRizsMenny() < 3 || jatekos2.getRizsMenny() < 3) {
					System.out.println("Az egyik játékos tönkre ment.");
				}
				
			}
			//Ha ugyan azt mutatták
			else {
				System.out.println(jatekos1.toString().split("@")[1] +  " Döntetlent játszott" + 
									jatekos2.toString().split("@")[1] + "-vel.");
				setJutalek(getJutalek()+2);
			}
			
			
		}
		
	}
		
}
