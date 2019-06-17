package kutyatelep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kutyatelep.Kutya.Faj;

public class Test {
	
	static Random rnd = new Random();

	public static void main(String[] args) throws Exception  {
	//	Kutya elso = new Kutya(Faj.BULLDOG, true);
	//	Kutya masodik = new Kutya(Faj.BULLDOG, false);
		/*Kutya kicsi = new Kutya(Faj.BULLDOG,true,false,elso,masodik,1);
		
		System.out.println(elso);
		System.out.println(masodik);
		System.out.println(kicsi);
		
		masodik.tudszaporodni(elso);
		masodik.szaporodik(elso);
		*/
		
		/**
		 * Példányosítunk egy kutyatelepet max 180 kutyával
		 */
		KutyaTelep ktelep = new KutyaTelep(180);
		
		/*TEST*/
	//	ktelep.elhelyez(elso);
	//	ktelep.darabszam++;
	//	ktelep.elhelyez(masodik);
	//	ktelep.darabszam++;
		System.out.println(ktelep.darabszam);
		
		/**
		 * Elhelyezünk a telepen szülõnélküli kutyákat 
		 * random fajjal
		 * random nemmel
		 * random életkorral
		 * 60% eséllyel törzskönyvezettek
		 * összesen 40 db
		 */
		for(int i = 0; i < 40; i++) {
			//Random faj
			int rFaj = rnd.nextInt(100 -1)+1;
			
			Faj kFaja = null;
			
			if(rFaj < 25) {
				kFaja = Faj.BULLDOG;	
			}
			else if(rFaj >25 && rFaj <50) {
				kFaja = Faj.SPANIEL;
			}
			else if(rFaj > 50 && rFaj < 75) {
				kFaja = Faj.TERRIER;
			}
			else if(rFaj > 75) {
				kFaja = Faj.VIZSLA;
			}
			
			
			//Random életkor
			int rEletkor = rnd.nextInt(10-1)+1;
			//Random nem
			boolean rNem = (rnd.nextInt(100 -1)+1) < 50;
			// Random törzskönyv
			boolean rTorzskonyv = (rnd.nextInt(100 -1)+1) < 60;
			
			Kutya bloki = new Kutya(kFaja,rNem);
			bloki.setKora(rEletkor);
			bloki.setTorzskonyvezett(rTorzskonyv);
			ktelep.elhelyez(bloki);
			//ktelep.darabszam++;
		}
		/**
		 *  100 kísérletet tesz a szaporításra random 2 kutyával
		 *  Ellenõrzi ,hogy a két kutya tud e szaporodni a másikkal
		 *  Ha igen akkor meghívja a szaporodik függvényt
		 *  A kiskutyákat elhelyezi a kutya telepen ha lehet.
		 *  Ha nincs legalább 8 hely a kiskutyáknak akkor nem szaporítja a létszámot.
		 */
		
		
		/**
		 * Minden kutya öregszik 1 évet,
		 * Az idõsek elpusztulnak
		 * Ismételjük meg 20x és minden évben írjuk ki a telep: - létszámát
		 * 														- az éves szaporulatot (db)
		 * 														- A kiskutyák adatait amit már nem lehet elhelyezni a telepen
		 * Írjuk ki , hány kutya lett
		 * mennyi a törzskönyvezett
		 * a spániel fajuak adatait
		 * 
		 */
		for(int j = 0; j < 20; j++) {
			System.out.println("Év: " + (1 + j));
			System.out.println("Darabszám a telepen: " + ktelep.darabszam);
			List<Kutya> kisKutyaAkikNem = new ArrayList<Kutya>();
			List<Kutya> kisKutyaLista = new ArrayList<Kutya>();
			int szaporulat = 0;
			int elhelyezett = 0;
			
			for(int i = 0; i < 100; i++) {
				int k1 = rnd.nextInt(ktelep.darabszam);
				int k2 = rnd.nextInt(180 - ktelep.darabszam)+ ktelep.darabszam;
				
				k2 = k1;
				while(k2 == k1) {
				 	k2 = rnd.nextInt(ktelep.darabszam);
				 }
				Kutya k1Kutya, k2Kutya;
                if(ktelep.lekerdez(k1)!=null){
                    k1Kutya = ktelep.lekerdez(k1);
                }
                else{
                    System.err.println("Baj van, "+(k1+1)+". kutyát próbáljuk lekérdezni, összesen "+ktelep.getDarabszam()+" kutya van a listában.");
                    k1Kutya=ktelep.lekerdez(0);
                }

                
                if(ktelep.lekerdez(k2)!=null){
                    k2Kutya = ktelep.lekerdez(k2);
                }
                else{
                    System.err.println("Baj van, "+(k2+1)+". kutyát próbáljuk lekérdezni, összesen "+ktelep.getDarabszam()+" kutya van a listában.");
                    k2Kutya=ktelep.lekerdez(1);
                }
                //System.out.println((i+1)+". szaporítási kísérlet: A vizsgálandó kutyák: "+k1+" és "+k2);
                kisKutyaLista = k1Kutya.szaporodik(k2Kutya);
	
				if(kisKutyaLista != null) {
					szaporulat += kisKutyaLista.size();
					for(Kutya k : kisKutyaLista) {
						if(!(ktelep.getMaxLetszam() - 8 >= ktelep.darabszam)) {
							kisKutyaAkikNem.add(k);
						}else {
							if(ktelep.elhelyez(k)) {
								elhelyezett++;
							}
						}
					}
					kisKutyaLista.clear();
				}
			}
			
			ktelep.elteltEgyEv();
			System.out.println("A szaporulat: " + szaporulat);
			System.out.println("Ebbõl elhelyezett: " + elhelyezett);
			System.out.println("Kiskutyák akiket nem lehetett elhelyezni: ");
			if(kisKutyaAkikNem != null) {
				for(Kutya k : kisKutyaAkikNem) {
					System.out.println("Faja: "+ k.fajta);
					String him;
					if (k.isHim()) {
						him = "hím";
					}else {
						him = "nõstény";
					}
					System.out.println("A kiskutya neme: "+ him);
					System.out.println("A kutya kora: " +  k.getKora());
					System.out.println("Törzskönyvezett: " + k.isTorzskonyvezett());
				}
			}
			
		}
		
		int torzskonyvezett = 0;
		int spanielHim = 0;
		int spanielNosteny = 0;
		int spanielTorzskonyv = 0;
		for(int i = 0; i < ktelep.getDarabszam(); i++) {
			Kutya k = ktelep.lekerdez(i);
			if(k.isTorzskonyvezett()) {
				torzskonyvezett++;
			}
			if(k.fajta == Faj.SPANIEL) {
				if(k.isHim()) {
					spanielHim++;
				}else {
					spanielNosteny++;
				}
				if(k.isTorzskonyvezett()) {
					spanielTorzskonyv++;
				}
			}
		}
		
		System.out.println("A telephelyen összesen: " + ktelep.darabszam + " db kutya van.");
		System.out.println("Ebbõl " + torzskonyvezett + " db törzsköünyvezett.");
		System.out.println("Spániel: " + ktelep.fajDarabszam(Faj.SPANIEL) + " db van.");
		System.out.println("Ebbõl " + spanielHim + " db hím.");
		System.out.println("Ebbõl " + spanielNosteny + " db nõstény.");
		System.out.println("Ebbõl " + spanielTorzskonyv + " db rendelkezik törzskönnyvvel.");
		
	}

}
