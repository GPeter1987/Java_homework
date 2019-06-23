package koPapirOllo;

import java.util.Random;

import koPapirOllo.KinaiJatekos.Visszateres;

public class Foprogram {
	
	

	public static void main(String[] args) throws Exception {
		
		Random rnd = new Random();
		// P�ld�nyos�t egy j�t�kbarlangot, max 60 j�t�kossal, 
		// max 10 b�r�val
		JatekBarlang kaszino= new JatekBarlang(60,10); 
		
		// J�t�kosok gener�l�sa
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
		
		// B�r�k gener�l�sa
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
		
		// J�t�kok enged�lyez�se
		for(int i = 0; i < 100; i++) {
			Biro a = kaszino.bLista.get(rnd.nextInt(10));
			a.lebonyolit(kaszino.jLista.get(rnd.nextInt(kaszino.getMaxJatekos())), 
						 kaszino.jLista.get(rnd.nextInt(kaszino.getMaxJatekos())));
		}
		
		// ki�rja, h�ny j�t�kos ment t�nkre (kevesebb mint 3 rizse maradt), 
		int szamlalo = 0;
		for(int i = 0; i < kaszino.jLista.size(); i++) {
			if(kaszino.jLista.get(i).getRizsMenny() < 3) {
				szamlalo++;
			}
			
		}
		System.out.println(szamlalo + " db j�t�kos ment t�nkre.");
		
		// h�ny j�t�kos boldog (el�rte a moh�s�g�nak megfelel� nyeres�get), 
		int boldog = 0;
		for(int i = 0; i < kaszino.jLista.size(); i++ ) {
			if(kaszino.jLista.get(i).getRizsMenny() >= kaszino.jLista.get(i).getMohosag() * kaszino.jLista.get(i).getRizsKezdo()) {
				boldog++;
			}
		}
		System.out.println(boldog + " db j�t�kos �rte el a moh�s�g�nak megfelel� szint� nyerem�nyt.");
		
		// �s a maffia b�r�k �sszesen h�ny rizst gy�jt�ttek be. 
		int begyujtott = 0;
		for(int i = 0; i < kaszino.bLista.size(); i++) {
			if(kaszino.bLista.get(i).maffia ) {
				begyujtott += kaszino.bLista.get(i).getJutalek();
			}
		}
		System.out.println(begyujtott + " db rizst gy�jt�tek a maffia b�r�k.");
		
	}
}
