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
		 * P�ld�nyos�tunk egy kutyatelepet max 180 kuty�val
		 */
		KutyaTelep ktelep = new KutyaTelep(180);
		
		/*TEST*/
	//	ktelep.elhelyez(elso);
	//	ktelep.darabszam++;
	//	ktelep.elhelyez(masodik);
	//	ktelep.darabszam++;
		System.out.println(ktelep.darabszam);
		
		/**
		 * Elhelyez�nk a telepen sz�l�n�lk�li kuty�kat 
		 * random fajjal
		 * random nemmel
		 * random �letkorral
		 * 60% es�llyel t�rzsk�nyvezettek
		 * �sszesen 40 db
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
			
			
			//Random �letkor
			int rEletkor = rnd.nextInt(10-1)+1;
			//Random nem
			boolean rNem = (rnd.nextInt(100 -1)+1) < 50;
			// Random t�rzsk�nyv
			boolean rTorzskonyv = (rnd.nextInt(100 -1)+1) < 60;
			
			Kutya bloki = new Kutya(kFaja,rNem);
			bloki.setKora(rEletkor);
			bloki.setTorzskonyvezett(rTorzskonyv);
			ktelep.elhelyez(bloki);
			//ktelep.darabszam++;
		}
		/**
		 *  100 k�s�rletet tesz a szapor�t�sra random 2 kuty�val
		 *  Ellen�rzi ,hogy a k�t kutya tud e szaporodni a m�sikkal
		 *  Ha igen akkor megh�vja a szaporodik f�ggv�nyt
		 *  A kiskuty�kat elhelyezi a kutya telepen ha lehet.
		 *  Ha nincs legal�bb 8 hely a kiskuty�knak akkor nem szapor�tja a l�tsz�mot.
		 */
		
		
		/**
		 * Minden kutya �regszik 1 �vet,
		 * Az id�sek elpusztulnak
		 * Ism�telj�k meg 20x �s minden �vben �rjuk ki a telep: - l�tsz�m�t
		 * 														- az �ves szaporulatot (db)
		 * 														- A kiskuty�k adatait amit m�r nem lehet elhelyezni a telepen
		 * �rjuk ki , h�ny kutya lett
		 * mennyi a t�rzsk�nyvezett
		 * a sp�niel fajuak adatait
		 * 
		 */
		for(int j = 0; j < 20; j++) {
			System.out.println("�v: " + (1 + j));
			System.out.println("Darabsz�m a telepen: " + ktelep.darabszam);
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
                    System.err.println("Baj van, "+(k1+1)+". kuty�t pr�b�ljuk lek�rdezni, �sszesen "+ktelep.getDarabszam()+" kutya van a list�ban.");
                    k1Kutya=ktelep.lekerdez(0);
                }

                
                if(ktelep.lekerdez(k2)!=null){
                    k2Kutya = ktelep.lekerdez(k2);
                }
                else{
                    System.err.println("Baj van, "+(k2+1)+". kuty�t pr�b�ljuk lek�rdezni, �sszesen "+ktelep.getDarabszam()+" kutya van a list�ban.");
                    k2Kutya=ktelep.lekerdez(1);
                }
                //System.out.println((i+1)+". szapor�t�si k�s�rlet: A vizsg�land� kuty�k: "+k1+" �s "+k2);
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
			System.out.println("Ebb�l elhelyezett: " + elhelyezett);
			System.out.println("Kiskuty�k akiket nem lehetett elhelyezni: ");
			if(kisKutyaAkikNem != null) {
				for(Kutya k : kisKutyaAkikNem) {
					System.out.println("Faja: "+ k.fajta);
					String him;
					if (k.isHim()) {
						him = "h�m";
					}else {
						him = "n�st�ny";
					}
					System.out.println("A kiskutya neme: "+ him);
					System.out.println("A kutya kora: " +  k.getKora());
					System.out.println("T�rzsk�nyvezett: " + k.isTorzskonyvezett());
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
		
		System.out.println("A telephelyen �sszesen: " + ktelep.darabszam + " db kutya van.");
		System.out.println("Ebb�l " + torzskonyvezett + " db t�rzsk��nyvezett.");
		System.out.println("Sp�niel: " + ktelep.fajDarabszam(Faj.SPANIEL) + " db van.");
		System.out.println("Ebb�l " + spanielHim + " db h�m.");
		System.out.println("Ebb�l " + spanielNosteny + " db n�st�ny.");
		System.out.println("Ebb�l " + spanielTorzskonyv + " db rendelkezik t�rzsk�nnyvvel.");
		
	}

}
