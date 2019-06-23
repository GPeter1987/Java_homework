package koPapirOllo;

import java.util.Random;

import koPapirOllo.KinaiJatekos.Visszateres;

public class Foprogram {
	
	

	public static void main(String[] args) throws Exception {
		
		Random rnd = new Random();
		// Példányosít egy játékbarlangot, max 60 játékossal, 
		// max 10 bíróval
		JatekBarlang kaszino= new JatekBarlang(60,10); 
		
		// Játékosok generálása
		for(int i = 0; i <= kaszino.getMaxJatekos(); i++) {
			int szam = rnd.nextInt(100);
			
			if(szam <= 30) {
				FixKinaiJatekos fix = new FixKinaiJatekos(5,5,Visszateres.OLLO);
				kaszino.jLista.add(fix);
			}
			else if(szam > 30 && szam <= 100) {
				KinaiJatekos jatekos = new KinaiJatekos(5,5);
				kaszino.jLista.add(jatekos);
			}
		}
		
		// Bírók generálása
		for(int i = 0; i <= kaszino.getMaxBiro(); i++) {
			int szam = rnd.nextInt(100);
			
			if(szam <= 80) {
				Biro biro = new Biro();
				kaszino.bLista.add(biro);
			}
			else if(szam > 80 && szam <= 100) {
				MaffiaBiro mBiro = new MaffiaBiro();
				kaszino.bLista.add(mBiro);
			}
		}
		
		// Játékok engedélyezése
		for(int i = 0; i < 100; i++) {
			Biro a = kaszino.bLista.get(rnd.nextInt(10));
			a.lebonyolit(kaszino.jLista.get(rnd.nextInt(kaszino.getMaxJatekos())), 
						 kaszino.jLista.get(rnd.nextInt(kaszino.getMaxJatekos())));
		}
		
		// kiírja, hány játékos ment tönkre (kevesebb mint 3 rizse maradt), 
		int szamlalo = 0;
		for(int i = 0; i < kaszino.jLista.size(); i++) {
			if(kaszino.jLista.get(i).getRizsMenny() < 3) {
				szamlalo++;
			}
			
		}
		System.out.println(szamlalo + " db játékos ment tönkre.");
		
		// hány játékos boldog (elérte a mohóságának megfelelõ nyereséget), 
		int boldog = 0;
		for(int i = 0; i < kaszino.jLista.size(); i++ ) {
			if(kaszino.jLista.get(i).getRizsMenny() >= kaszino.jLista.get(i).getMohosag() * kaszino.jLista.get(i).getRizsKezdo()) {
				boldog++;
			}
		}
		System.out.println(boldog + " db játékos érte el a mohóságának megfelelõ szintû nyereményt.");
		
		// és a maffia bírók összesen hány rizst gyûjtöttek be. 
		int begyujtott = 0;
		for(int i = 0; i < kaszino.bLista.size(); i++) {
			if(kaszino.bLista.get(i).maffia ) {
				begyujtott += kaszino.bLista.get(i).getJutalek();
			}
		}
		System.out.println(begyujtott + " db rizst gyûjtötek a maffia bírók.");
		
	}
}
