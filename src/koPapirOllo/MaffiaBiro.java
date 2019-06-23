package koPapirOllo;

import koPapirOllo.KinaiJatekos.Visszateres;

public class MaffiaBiro extends Biro{
	
	int jutalek = 0;
	boolean maffia = true;
	
	public int getJutalek() {
		return jutalek;
	}
	
	public boolean isMaffia() {
		return maffia;
	}
	
public void lebonyolit(KinaiJatekos jatekos1, KinaiJatekos jatekos2) throws Exception {
		
		// Ellenõrizzük ,hogy mind a két játékos rendelkezik-e minimum 3 rizzsel.
		if(jatekos1.getRizsMenny()>= 3 && jatekos2.getRizsMenny()>= 3) {
			
			if(jatekos1.getVissza() != jatekos2.getVissza()) {
				if(jatekos1.getVissza() == Visszateres.KO && 
				   jatekos2.getVissza() == Visszateres.OLLO) {
					jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
					jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
					System.out.println(jatekos1 + " Gyõzött");
				}
				else if(jatekos1.getVissza() == Visszateres.OLLO && 
						   jatekos2.getVissza() == Visszateres.PAPIR) {
							jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
							jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
							System.out.println(jatekos1 + " Gyõzött");
				}
				else if(jatekos1.getVissza() == Visszateres.PAPIR && 
						   jatekos2.getVissza() == Visszateres.KO) {
							jatekos1.setRizsMenny(jatekos1.getRizsMenny()+1); // Gyõztes +1
							jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); // Vesztes -1
							System.out.println(jatekos1 + " Gyõzött");
				}
				else {
					jatekos2.setRizsMenny(jatekos2.getRizsMenny()+1); // Gyõztes +1
					jatekos1.setRizsMenny(jatekos1.getRizsMenny()-1); // Vesztes -1
					System.out.println(jatekos2 + " Gyõzött");
				}
			}
			else if(jatekos1.getVissza() == jatekos2.getVissza()) {
				jatekos2.setRizsMenny(jatekos2.getRizsMenny()-1); 
				jatekos1.setRizsMenny(jatekos1.getRizsMenny()-1);
				
				jutalek += 2;
				
				System.out.println("Döntetlen.");
			}
		}
		
	}
		
}
